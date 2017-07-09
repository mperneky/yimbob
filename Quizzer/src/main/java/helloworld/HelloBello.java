package com.helloworld;

/**
 * Created by Yimbo on 2017.07.02..
 */
public class HelloBello {
    private final long id;
    private final String content;

    public HelloBello(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
