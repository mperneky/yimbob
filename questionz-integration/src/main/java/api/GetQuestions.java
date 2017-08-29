package api;

import objects.QuestionsResponse;

public interface GetQuestions {

    QuestionsResponse getQuestions(String name);
}
