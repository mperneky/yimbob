package objects;

import com.dtos.objects.SimpleQuestion;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

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
