package object;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dtos.objects.SimpleQuestion;

/**
 * @author Matyas_Perneky
 */
@Component
public class SimpleQuestionSqlTransformer {
    public List<SimpleQuestion> transformSqlResponse(List<SqlQuestion> resp) {
        List<SimpleQuestion> questions = new ArrayList<>();

        for (SqlQuestion question : resp) {
            questions.add(new SimpleQuestion(question.getQuestion(), question.getAnswer()));
        }

        return questions;
    }
}
