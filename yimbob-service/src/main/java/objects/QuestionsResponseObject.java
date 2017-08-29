package objects;

import java.util.List;

/**
 * Created by Yimbo on 2017.08.28..
 */
public class QuestionsResponseObject {

    private List<BasicQuestion> basicQuestions;
    private String requestor;
    private Long id;

    public QuestionsResponseObject(List<BasicQuestion> basicQuestions, String requestor, Long id) {
        this.basicQuestions = basicQuestions;
        this.requestor = requestor;
        this.id = id;
    }

    public List<BasicQuestion> getBasicQuestions() {
        return basicQuestions;
    }

    public String getRequestor() {
        return requestor;
    }

    public Long getId() {
        return id;
    }
}
