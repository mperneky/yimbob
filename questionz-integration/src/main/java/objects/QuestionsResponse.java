package objects;

/**
 * Created by Yimbo on 2017.08.28..
 */
public class QuestionsResponse {
    private Long id;
    private String content;
    private String requestor;

    public QuestionsResponse() {
    }

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
