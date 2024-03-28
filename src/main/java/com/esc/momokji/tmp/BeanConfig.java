package com.esc.momokji.tmp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public Object bean1() throws Exception {
        return new Object();
    }

    @Bean
    public Object bean2() throws Exception {
        return new Object();
    }
}
