package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dtos.objects.YimbobQuestionsObject;

import objects.QuestionsResponseObject;
import objects.SimpleQuestionTransformer;

@Component
public class GetQuestionsRestImpl implements GetQuestions {

    private final String URI = "http://localhost:8090/questions/?requestor={name}";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SimpleQuestionTransformer transformer;

    @Override
    public YimbobQuestionsObject getQuestions(String name) {
//        return restTemplate.getForObject(URI, YimbobQuestionsObject.class, name);
        QuestionsResponseObject obj = restTemplate.getForObject(URI, QuestionsResponseObject.class, name);
        return transformer.transformResponse(obj);
    }
}
