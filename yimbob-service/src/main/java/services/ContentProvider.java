package services;

import api.GetQuestions;
import objects.QuestionsResponse;
import objects.QuestionsResponseObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class ContentProvider {

    @Autowired
    GetQuestions questionsService;

    /**
     * Gets the contents from the Questions service and returns with the List of BasicQuestions.
     */
    public QuestionsResponseObject provideContents() {
        QuestionsResponse response = questionsService.getQuestions();

        return null;
    }
}
