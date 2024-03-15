package com.esc.momokji;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
    @PropertySource("classpath:/properties/config.properties"),
    @PropertySource("classpath:/properties/message.properties")
})
public class MomokjiApplication {
    public static void main(String[] args) {
        SpringApplication.run(MomokjiApplication.class, args);
    }

}
