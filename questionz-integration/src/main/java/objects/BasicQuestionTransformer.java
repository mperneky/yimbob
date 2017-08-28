package objects;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;

public class BasicQuestionTransformer {

    /**
     * Transforms the Questions response string to a List of Yimbob basic questions.
     */
    public List<BasicQuestion> transformResponse(String resp) {
        List<BasicQuestion> questions = new ArrayList<>();

        String primitive = getJsonObjectData(resp, "content");
        JsonObject obj = (new JsonParser().parse(primitive).getAsJsonObject());

        for (JsonElement element : transformJsonObjectToJsonArray(obj, "Questions")) {
            String p1 = getJsonObjectData(element.toString(), "Question");
            String p2 = getJsonObjectData(element.toString(), "Answer");
            questions.add(new BasicQuestion(p1, p2));
        }

        return questions;
    }

    private String getJsonObjectData(String object, String target) {
        return new JsonParser().parse(object).getAsJsonObject().get(target).getAsString();
    }

    private JsonArray transformJsonObjectToJsonArray(JsonObject object, String target) {
        return object.get(target).getAsJsonArray();
    }
}
