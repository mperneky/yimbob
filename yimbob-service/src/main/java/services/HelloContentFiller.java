package services;

import integration.BasicQuestion;
import integration.RestGetQuestionzImplementation;
import java.util.List;

// Just use the interface here, and inject the right bean from spring?
public class HelloContentFiller {
  private final String template = "%s \n %s";

  public String provideContents() {
    RestGetQuestionzImplementation comm = new RestGetQuestionzImplementation();
    List<BasicQuestion> content;
    String result = "";
    try {
      content = comm.getQuestions();
      for (BasicQuestion question : content) {
        result = result + "\n" + String.format(template, question.getQuestion(), question.getAnswer()) + "\n\n";
      }
    } catch (Exception e){
      System.out.print(e.getMessage());
    }
    return result;
  }
}
