package objects;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.dtos.objects.SimpleQuestion;
import com.dtos.objects.YimbobQuestionsObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * @author Matyas_Perneky
 */
@Component
public class SimpleQuestionTransformer {

    public YimbobQuestionsObject transformResponse(QuestionsResponse resp) {
        List<SimpleQuestion> questions = new ArrayList<>();

        for (JsonElement element : getContentAsJsonArray(resp.getContent())) {
            String p1 = getJsonObjectData(element.toString(), "Question");
            String p2 = getJsonObjectData(element.toString(), "Answer");
            questions.add(new SimpleQuestion(p1, p2));
        }

        return new YimbobQuestionsObject(resp.getId(), questions, resp.getRequestor());
    }


    private JsonArray getContentAsJsonArray(String content) {
        return new JsonParser().parse(content).getAsJsonObject().get("Questions").getAsJsonArray();
    }

    private String getJsonObjectData(String object, String target) {
        return new JsonParser().parse(object).getAsJsonObject().get(target).getAsString();
    }
}