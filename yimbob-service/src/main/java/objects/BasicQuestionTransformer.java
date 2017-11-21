package objects;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dtos.objects.SimpleQuestion;

@Component
public class BasicQuestionTransformer {

    public List<BasicQuestion> transformResponse(List<SimpleQuestion> resp) {
        List<BasicQuestion> questions = new ArrayList<>();

        for (SimpleQuestion question : resp) {
            questions.add(new BasicQuestion(question.getQuestion(), question.getAnswer()));
        }

        return questions;
    }

}
