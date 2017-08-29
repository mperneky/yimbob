package objects;

/**
 * Created by Yimbo on 2017.08.28..
 */
public class BasicQuestion {
    private String question;
    private String answer;

    public BasicQuestion(String question, String answer) {
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
