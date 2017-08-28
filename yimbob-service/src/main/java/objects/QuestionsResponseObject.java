package objects;

import java.util.List;

/**
 * Created by Yimbo on 2017.08.28..
 */
public class QuestionsResponseObject {
    private List<Question> questions;
    private String requestor;
    private Long id;

    public QuestionsResponseObject(List<Question> questions, String requestor, Long id) {
        this.questions = questions;
        this.requestor = requestor;
        this.id = id;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public String getRequestor() {
        return requestor;
    }

    public Long getId() {
        return id;
    }
}
