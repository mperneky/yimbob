package com.web.domain;

import objects.BasicQuestion;
import objects.QuestionsResponseObject;

import org.springframework.stereotype.Component;

import com.dtos.objects.YimbobQuestionsObject;

/**
 * Created by Yimbo on 2017.08.29..
 */
@Component
public class ContentFiller {

    private final String template = "%s \n %s";

    public String getPageContents(QuestionsResponseObject questions) {
        String result = "";
        for (BasicQuestion question : questions.getBasicQuestions()) {
            result = result + "\n" + String
                .format(template, question.getQuestion(), question.getAnswer()) + "\n\n";
        }
        return result;
    }

    public Long getRequestId(QuestionsResponseObject questions) {
        return questions.getId();
    }
}
