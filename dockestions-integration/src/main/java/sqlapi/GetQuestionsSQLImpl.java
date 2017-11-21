package sqlapi;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;

import com.dtos.objects.YimbobQuestionsObject;

import object.SimpleQuestionSqlTransformer;
import api.GetQuestions;
import object.SqlQuestion;

/**
 * @author Matyas_Perneky
 */
public class GetQuestionsSQLImpl implements GetQuestions {
    private SessionFactory factory;
    private static final String QUERY = "SELECT * FROM Questions;";
    private static final long ID = 42;

    @Autowired
    private SimpleQuestionSqlTransformer transformer;

    @Override
    public YimbobQuestionsObject getQuestions(String name) {
        factory = new Configuration().configure().buildSessionFactory();
        Session sess = factory.openSession();
        Query query = sess.createSQLQuery(QUERY).setResultTransformer(Transformers.aliasToBean(SqlQuestion.class));
        List results = query.list();

        return new YimbobQuestionsObject(ID, transformer.transformSqlResponse(results), name);
    }
}
