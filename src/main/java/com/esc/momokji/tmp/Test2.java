package com.esc.momokji.tmp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "test2/")
@Component
public class Test2 {
    @RequestMapping(value = "test")
    @ResponseBody
    public void test() throws Exception {
        /*for (int cnt = 0; cnt < 5; cnt++) {
            TestDTO t = (TestDTO)a.getBean("beanTest");

            System.out.println("test2 : " + t);
        }*/
    }
}