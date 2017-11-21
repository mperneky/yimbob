package com.dtos.objects;

/**
 * SimpleQuestion definition.
 *
 * @author Matyas_Perneky
 */
public class SimpleQuestion {
    private final String question;
    private final String answer;

    public SimpleQuestion(String question, String answer) {
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
