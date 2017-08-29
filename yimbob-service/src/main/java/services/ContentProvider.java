package services;

import api.GetQuestions;
import java.util.List;
import objects.BasicQuestion;
import objects.BasicQuestionTransformer;
import objects.QuestionsResponse;
import objects.QuestionsResponseObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class ContentProvider {

    @Autowired
    GetQuestions questionsService;

    @Autowired
    BasicQuestionTransformer transformer;

    /**
     * Gets the contents from the Questions service and returns with the List of BasicQuestions.
     */
    public QuestionsResponseObject provideContents(String name) {
        QuestionsResponse response = questionsService.getQuestions(name);
        List<BasicQuestion> questions= transformer.transformResponse(response.getContent());

        return new QuestionsResponseObject(questions, response.getRequestor(), response.getId());
    }
}
