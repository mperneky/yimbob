package services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import api.GetQuestions;
import restapi.GetQuestionsRestImpl;
import sqlapi.GetQuestionsSQLImpl;

/**
 * @author Matyas_Perneky
 */
@Configuration
@ComponentScan({"sqlapi", "restapi", "objects"})
public class ServiceConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean(name = "rest")
    public GetQuestions getRestQuestions() {
        return new GetQuestionsRestImpl();
    }

    @Bean(name = "sql")
    public GetQuestions getSqlQuestions() {
        return new GetQuestionsSQLImpl();
    }
}
