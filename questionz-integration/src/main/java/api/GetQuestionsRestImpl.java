package api;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import objects.BasicQuestion;
import objects.BasicQuestionTransformer;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


public class GetQuestionsRestImpl implements GetQuestions {
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
        try (InputStream stream = entity.getContent()) {
          Scanner s = new Scanner(stream).useDelimiter("\\A");
          content = s.hasNext() ? s.next() : "";
        }
      }
    }
    return transform(content);
  }

  private List<BasicQuestion> transform(String resp) {
    return new BasicQuestionTransformer().transformResponse(resp);
  }

  private HttpGet setHeaders(HttpGet getRequest) {
    getRequest.addHeader("Accept", Headers.ACCEPT.toString());
    getRequest.addHeader("Accept-Encoding", Headers.ACCEPT_ENCODING.toString());
    getRequest.addHeader("Accept-Language", Headers.ACCEPT_LANGUAGE.toString());
    getRequest.addHeader("Cache-Control", Headers.CACHE_CONTROL.toString());
    getRequest.addHeader("Connection", Headers.CONNECTION.toString());
    getRequest.addHeader("User-Agent", Headers.USER_AGENT.toString());
    return getRequest;
  }
}
