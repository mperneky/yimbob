package services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Matyas_Perneky
 */
@Configuration
@ComponentScan({"api", "objects"})
public class ServiceConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
