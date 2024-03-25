package com.esc.momokji.tmp;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

@Controller
@RequestMapping(value = "test/")
public class Test {
    @Autowired Test2 t2;

    private AnnotationConfigApplicationContext a;
    private AnnotationConfigApplicationContext a2;

    public Test() {
        a = new AnnotationConfigApplicationContext(BeanFactoryTest1.class);
        a2 = new AnnotationConfigApplicationContext(BeanFactoryTest2.class);

        String b[] = a.getBeanDefinitionNames();

        for (String bb : b) {
            System.out.println("$$$$" + bb);
        }
    }


    @RequestMapping(value = "test1")
    @ResponseBody
    public void test1() throws Exception {
        for (int cnt = 0; cnt < 5; cnt++) {
            TestDTO t = (TestDTO)a.getBean("beanTest");

            System.out.println("instance Value With Spring Bean : " + t);
        }

        t2.test();
    }

    @RequestMapping(value = "test2")
    @ResponseBody
    public String test2(HttpServletRequest request) throws Exception {
        String var = request.getParameter("var");

        for (int cnt = 0; cnt < 5; cnt++) {
            TestDTO t = (TestDTO)a2.getBean("beanTest2");

            if (var != null && !var.isEmpty()) {
                t.setMsg(var);
            }

            System.out.println("instance Value With Spring Bean : " + t + " && var : " + t.getMsg());
        }

        getConnectionWithLoopBack();

        return "test2 ended";
    }

    public void getConnectionWithLoopBack() throws Exception {
        String urlPath = "http://localhost:8000/test/test2?";

        HttpURLConnection uc;

        for (int cnt = 0; cnt < 5; cnt++) {
            if (cnt == 0) {
                urlPath += "var=zz";
            } else {
                urlPath = urlPath.replace("var=zz", "");
            }

            URL url = new URL(urlPath);
            uc = (HttpURLConnection)url.openConnection();

            uc.getResponseCode();
            System.out.println(uc.getResponseMessage());
        }
    }
}