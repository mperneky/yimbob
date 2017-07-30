package questionz;

/**
 * Created by Yimbo on 2017.07.30..
 */
public class Question {
  private final String question;
  private final String answer;

  public Question(String question, String answer) {
    this.question = question;
    this.answer = answer;
  }

  public String getQuestion() {
    return question;
  }

  public String getAnswer() {
    return answer;
  }
}
