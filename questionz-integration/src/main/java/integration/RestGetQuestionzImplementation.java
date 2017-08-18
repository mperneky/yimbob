package integration;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class RestGetQuestionzImplementation implements GetQuestionz{
  private final String uri = "http://localhost:8090/questions";

  @Override
  public List<BasicQuestion> getQuestions() throws IOException {
    String content = null;

    CloseableHttpClient httpclient = HttpClients.createDefault();
    HttpGet httpget = new HttpGet(uri);
    httpget = setHeaders(httpget);
    try (CloseableHttpResponse response = httpclient.execute(httpget)) {
      HttpEntity entity = response.getEntity();
      if (entity != null) {
        try (InputStream instream = entity.getContent()) {
          Scanner s = new Scanner(instream).useDelimiter("\\A");
          content = s.hasNext() ? s.next() : "";
        }
      }
    }
    return transformResponse(content);
    }

  // TODO: A transform class should handle this!
  private List<BasicQuestion> transformResponse(String resp) {
    List<BasicQuestion> questions = new ArrayList<>();

    String primitive = new JsonParser().parse(resp).getAsJsonObject().get("content").getAsString();
    JsonObject prim2 = new JsonParser().parse(primitive).getAsJsonObject();
    JsonArray array = prim2.get("Questions").getAsJsonArray();

    for (JsonElement pa : array) {
      String p1 = new JsonParser().parse(pa.toString()).getAsJsonObject().get("Question").getAsString();
      String p2 = new JsonParser().parse(pa.toString()).getAsJsonObject().get("Answer").getAsString();
      questions.add(new BasicQuestion(p1, p2));
    }

    return questions;
  }

  // TODO: Not nice at all, it just works. Discard it or make it better!
  private HttpGet setHeaders(HttpGet getRequest) {
    getRequest.addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
    getRequest.addHeader("Accept-Encoding", "gzip, deflate, br");
    getRequest.addHeader("Accept-Language", "en-US,en;q=0.8");
    getRequest.addHeader("Cache-Control", "max-age=0");
    getRequest.addHeader("Connection", "keep-alive");
    getRequest.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
    return getRequest;
  }
}
