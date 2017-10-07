package restapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dtos.objects.YimbobQuestionsObject;

import api.GetQuestions;
import objects.QuestionsResponse;
import objects.SimpleQuestionRestTransformer;

@Component
public class GetQuestionsRestImpl implements GetQuestions {

    private final String URI = "http://localhost:8090/questions/?requestor={name}";

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SimpleQuestionRestTransformer transformer;

    @Override
    public YimbobQuestionsObject getQuestions(String name) {
//        return restTemplate.getForObject(URI, YimbobQuestionsObject.class, name);

        QuestionsResponse obj = restTemplate.getForObject(URI, QuestionsResponse.class, name);
        return transformer.transformResponse(obj);
    }
}
