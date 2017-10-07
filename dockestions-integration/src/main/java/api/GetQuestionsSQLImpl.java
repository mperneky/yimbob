package api;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.dtos.objects.YimbobQuestionsObject;

/**
 * @author Matyas_Perneky
 */
public class GetQuestionsSQLImpl implements GetQuestions {
    private static SessionFactory factory;
    private static final String USE_QUESTIONSDB = "SELECT Questions FROM QuestionsDB";
    private static final String QUERY = "SELECT * FROM Questions";

    @Override
    public YimbobQuestionsObject getQuestions(String name) {
        factory = new Configuration().configure().buildSessionFactory();
        factory.openSession();
        return null;
    }
}
