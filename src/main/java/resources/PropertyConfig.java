package resources;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class PropertyConfig {
    @Bean(name = "staticConfig")
    public PropertiesFactoryBean propertiesFactoryBean() throws Exception {
        PropertiesFactoryBean pb = new PropertiesFactoryBean();
        ClassPathResource cr = new ClassPathResource("properties/config.properties");

        pb.setLocation(cr);

        return pb;
    }
}
