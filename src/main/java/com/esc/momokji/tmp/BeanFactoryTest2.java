package com.esc.momokji.tmp;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanFactoryTest2 {
    public BeanFactoryTest2() {
        System.out.println("BeanFactoryTest2 Instanced");
    }

    @Bean(name = "beanTest2")
    public TestDTO getTestDTO() throws Exception {
        return new TestDTO();
    }
}
