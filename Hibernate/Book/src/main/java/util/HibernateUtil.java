package util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import Model.Book;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    private HibernateUtil() {
        sessionFactory = new Configuration()
            .configure("hibernet.xml")
            .addAnnotatedClass(Book.class)
            .buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            new HibernateUtil();
        }
        return sessionFactory;
    }
}
