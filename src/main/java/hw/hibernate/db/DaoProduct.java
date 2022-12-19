package hw.hibernate.db;

import hw.hibernate.entities.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoProduct {

    private SessionFactoryUtil factory;

    @Autowired
    public void setFactory(SessionFactoryUtil factory) {
        this.factory = factory;
    }

    public List<Product> findAll() {
        Session session = factory.getSession();//openSession
        session.beginTransaction();
        List <Product> products = session.createQuery("select product from Product product").getResultList();
        session.getTransaction().commit();
        return products;
    }

}
