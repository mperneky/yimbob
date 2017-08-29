package api;

import objects.QuestionsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class GetQuestionsRestImpl implements GetQuestions {

    private final String URI = "http://localhost:8090/questions/?requestor={name}";

    @Autowired
    RestTemplate restTemplate;

    @Override
    public QuestionsResponse getQuestions(String name) {
        return restTemplate.getForObject(URI, QuestionsResponse.class, name);
    }
}
