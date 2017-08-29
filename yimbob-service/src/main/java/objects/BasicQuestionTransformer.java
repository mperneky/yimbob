package objects;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * Created by Yimbo on 2017.08.29..
 */
@Component
public class BasicQuestionTransformer {

    public List<BasicQuestion> transformResponse(String resp) {
        List<BasicQuestion> questions = new ArrayList<>();

        for (JsonElement element : getContentAsJsonArray(resp)) {
            String p1 = getJsonObjectData(element.toString(), "Question");
            String p2 = getJsonObjectData(element.toString(), "Answer");
            questions.add(new BasicQuestion(p1, p2));
        }

        return questions;
    }

    private JsonArray getContentAsJsonArray(String content) {
        return new JsonParser().parse(content).getAsJsonObject().get("Questions").getAsJsonArray();
    }

    private String getJsonObjectData(String object, String target) {
        return new JsonParser().parse(object).getAsJsonObject().get(target).getAsString();
    }
}
