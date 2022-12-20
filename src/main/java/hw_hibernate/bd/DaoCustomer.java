package hw_hibernate.bd;

import hw_hibernate.Customer;
import hw_hibernate.Product;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoCustomer {
    private SessionFactoryUtil factory;

    @Autowired
    public void setFactory(SessionFactoryUtil factory) {
        this.factory = factory;
    }

    public List<Customer> findAll() {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Customer> customers = session.createQuery("select c from Customer c").getResultList();
            session.getTransaction().commit();
            return customers;
        }
    }

    public Customer findById(long id){
        try (Session session = factory.getSession()){
            session.beginTransaction();
            Customer customer = session.get(Customer.class,id);
            session.getTransaction().commit();
            return  customer;
        }
    }

    public List<Product> getProductsByCustomerId(long customerId) {
        try(Session session = factory.getSession()){
            session.beginTransaction();
            Customer customer = session.get(Customer.class,customerId);
            List <Product> list = customer.getProducts();
            //System.out.println(list.toString());
            session.getTransaction().commit();
            return list;
        }
    }
}
