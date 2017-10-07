package sqlapi;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 * @author Matyas_Perneky
 */
public class MegaTest {
    private static SessionFactory factory;
    private static final String QUERY = "from object.SqlQuestion";
    private static final long ID = 42;

    public static void main(String[] args) {
        test();
    }

    private static void test() {
        factory = new Configuration().configure().buildSessionFactory();
        Session sess = factory.openSession();
        Query query = sess.createQuery(QUERY);
        List results = query.list();
    }
}
