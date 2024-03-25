package com.esc.momokji.tmp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactoryTest1 {
    public BeanFactoryTest1() {
        System.out.println("BeanFactoryTest1 Instanced");
    }

    @Bean(name = "beanTest")
    public TestDTO getTestDTO() throws Exception {
        return new TestDTO();
    }
}
