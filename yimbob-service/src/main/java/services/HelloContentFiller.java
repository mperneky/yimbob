package services;

import api.GetQuestions;
import objects.QuestionsResponse;
import org.springframework.beans.factory.annotation.Autowired;

public class HelloContentFiller {

    // TODO: WHY ARE YOU NULL?
    @Autowired
    GetQuestions questionsService;

    /**
     * Gets the contents from the Questions service and returns with the List of BasicQuestions.
     */
    public String provideContents() {
        QuestionsResponse response = questionsService.getQuestions();

        return null;
    }
}
