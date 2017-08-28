package services;

import api.GetQuestionsRestImpl;
import java.util.List;
import objects.BasicQuestion;

public class HelloContentFiller {

    /**
     * Gets the contents from the Questions service and returns with the List of BasicQuestions.
     */
    public String provideContents() {
        GetQuestionsRestImpl comm = new GetQuestionsRestImpl();
        List<BasicQuestion> content;
        String result = "";
        try {
            content = comm.getQuestions();
            for (BasicQuestion question : content) {
                result =
                    result + "\n" + question.getQuestion() + "\n" + question.getAnswer() + "\n";
            }
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return result;
    }
}
