package hw_hibernate.bd;

import hw_hibernate.Customer;
import hw_hibernate.Product;
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
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("select product from Product product").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    public void updatePrice(Product product, long newPrice) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            session.createQuery("update Product set price = :price where id = :id")
                    .setParameter("id", product.getId())
                    .setParameter("price", newPrice)
                    .executeUpdate();
            session.getTransaction().commit();
        }

    }

    public Product findById(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    public List<Customer> getCustomersByProductId(long productId) {

        try (Session session = factory.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, productId);
            List<Customer> list = product.getCustomers();
            //System.out.println(list.toString());
            session.getTransaction().commit();
            return list;
        }

    }
}
