package services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.dtos.objects.YimbobQuestionsObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import api.GetQuestions;
import objects.BasicQuestion;
import objects.BasicQuestionTransformer;
import objects.QuestionsResponseObject;

@Component
public class ContentProvider {
    private final Long fallbackId = 42L;

    //    @Autowired
    //    private GetQuestions questionsService;

    @Autowired
    @Qualifier("rest")
    private GetQuestions questionsRestService;

    @Autowired
    @Qualifier("sql")
    private GetQuestions questionsSqlService;

    @Autowired
    private BasicQuestionTransformer transformer;

    /**
     * Gets the contents from the Questions service and returns with the List of BasicQuestions.
     */
    @HystrixCommand(fallbackMethod = "worstCaseScenarion")
    public QuestionsResponseObject provideContents(String name) {
//        YimbobQuestionsObject response = questionsRestService.getQuestions(name);
        YimbobQuestionsObject response = questionsSqlService.getQuestions(name);
        return new QuestionsResponseObject(transformer.transformResponse(response.getContent()), response.getRequestor(), response.getId());
    }

    public QuestionsResponseObject worstCaseScenarion(String name) {
        BasicQuestion question = new BasicQuestion("We ran out of questions!", "Answers as well!");
        List<BasicQuestion> questions = new ArrayList<>();
        questions.add(question);
        return new QuestionsResponseObject(questions, name, fallbackId);
    }
}
