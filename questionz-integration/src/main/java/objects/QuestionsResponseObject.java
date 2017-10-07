package objects;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * @author Matyas_Perneky
 */
public class QuestionsResponseObject {
    private Long id;
    private String content;
    private String requestor;

    @JsonCreator
    public QuestionsResponseObject() {
    }

//    public QuestionsResponseObject(Long id, String content, String requestor) {
//        this.id = id;
//        this.content = content;
//        this.requestor = requestor;
//    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRequestor(String requestor) {
        this.requestor = requestor;
    }

    public String getRequestor() {
        return requestor;
    }

    public String getContent() {
        return content;
    }

    public Long getId() {
        return id;
    }
}
