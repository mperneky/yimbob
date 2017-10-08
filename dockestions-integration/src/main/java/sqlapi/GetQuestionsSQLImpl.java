package sqlapi;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.dtos.objects.YimbobQuestionsObject;

import object.SimpleQuestionSqlTransformer;
import api.GetQuestions;

/**
 * @author Matyas_Perneky
 */
public class GetQuestionsSQLImpl implements GetQuestions {
    private SessionFactory factory;
    private static final String QUERY = "from object.SqlQuestion";
    private static final long ID = 42;

    @Autowired
    private SimpleQuestionSqlTransformer transformer;

    @Override
    public YimbobQuestionsObject getQuestions(String name) {
        factory = new Configuration().configure().buildSessionFactory();
        Session sess = factory.openSession();
        Query query = sess.createQuery(QUERY);
        List results = query.list();

        return new YimbobQuestionsObject(ID, transformer.transformSqlResponse(results), name);
    }
}
