package api;

import java.io.IOException;
import java.util.List;
import objects.BasicQuestion;

public interface GetQuestions {

    List<BasicQuestion> getQuestions() throws IOException;
}
