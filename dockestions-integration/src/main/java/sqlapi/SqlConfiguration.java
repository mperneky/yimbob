package sqlapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import object.SimpleQuestionSqlTransformer;

/**
 * @author Matyas_Perneky
 */
@Configuration
@ComponentScan
public class SqlConfiguration {
    @Bean
    public SimpleQuestionSqlTransformer getTransformer() {
        return new SimpleQuestionSqlTransformer();
    }
}
