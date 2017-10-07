package com.dtos.objects;

import java.util.List;

public class YimbobQuestionsObject {
    private Long id;
    private List<SimpleQuestion> content;
    private String requestor;

    public YimbobQuestionsObject(Long id, List<SimpleQuestion> content, String requestor) {
        this.id = id;
        this.content = content;
        this.requestor = requestor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setContent(List<SimpleQuestion> content) {
        this.content = content;
    }

    public void setRequestor(String requestor) {
        this.requestor = requestor;
    }

    public String getRequestor() {
        return requestor;
    }

    public List<SimpleQuestion> getContent() {
        return content;
    }

    public Long getId() {
        return id;
    }
}
