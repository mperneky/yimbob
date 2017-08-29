package services;

import api.GetQuestions;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import java.util.ArrayList;
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
    private final Long fallbackId = Long.valueOf(42);

    @Autowired
    GetQuestions questionsService;

    @Autowired
    BasicQuestionTransformer transformer;

    /**
     * Gets the contents from the Questions service and returns with the List of BasicQuestions.
     */
    @HystrixCommand(fallbackMethod = "worstCaseScenarion")
    public QuestionsResponseObject provideContents(String name) {
        QuestionsResponse response = questionsService.getQuestions(name);
        List<BasicQuestion> questions= transformer.transformResponse(response.getContent());

        return new QuestionsResponseObject(questions, response.getRequestor(), response.getId());
    }

    public QuestionsResponseObject worstCaseScenarion(String name) {
        BasicQuestion question = new BasicQuestion("We ran out of questions!", "Answers as well!");
        List<BasicQuestion> questions = new ArrayList<>();
        questions.add(question);
        return new QuestionsResponseObject(questions, name, fallbackId);
    }
}
