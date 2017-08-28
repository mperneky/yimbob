package objects;

/**
 * Created by Yimbo on 2017.08.28..
 */
public class QuestionsResponse {
    private String requestor;
    private String questions;
    private Long id;

    public QuestionsResponse(String requestor, String questions, Long id) {
        this.requestor = requestor;
        this.questions = questions;
        this.id = id;
    }

    public String getRequestor() {
        return requestor;
    }

    public String getQuestions() {
        return questions;
    }

    public Long getId() {
        return id;
    }
}
