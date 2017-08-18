package integration;

import java.io.IOException;
import java.util.List;

public interface GetQuestionz {
    List<BasicQuestion> getQuestions() throws IOException;
}
