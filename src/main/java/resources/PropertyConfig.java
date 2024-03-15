package resources;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class PropertyConfig {
    
    /* 전역 설정 */
    /*@Bean(name = "staticConfig")
    public PropertiesFactoryBean createStaticConfigFactoryBean() throws Exception {
        PropertiesFactoryBean pb = new PropertiesFactoryBean();
        ClassPathResource cr = new ClassPathResource("properties/config.properties");

        pb.setLocation(cr);

        return pb;
    }*/
    
    /* 메세지 */
    /*@Bean(name = "messageConfig")
    public PropertiesFactoryBean createMessageConfigFactoryBean() throws Exception {
        PropertiesFactoryBean pb = new PropertiesFactoryBean();
        ClassPathResource cr = new ClassPathResource("properties/message.properties");

        pb.setLocation(cr);

        return pb;
    }*/
}
