package hw_hibernate.bd;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class SessionFactoryUtil {

    private static final String SRC_PATH = "hibernate.cfg.xml";
    private SessionFactory factory;

    @PostConstruct
    private void init() {
        this.factory = new Configuration()
                .configure(SRC_PATH)
                .buildSessionFactory();

    }

    public Session getSession() {
        return factory.getCurrentSession();
    }
}
