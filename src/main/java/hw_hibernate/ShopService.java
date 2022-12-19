package hw_hibernate;

//import hw.hibernate.DaoProduct;
//import hw.hibernate.Product;
import hw_hibernate.bd.DaoCustomer;
import hw_hibernate.bd.DaoProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShopService {
    @Autowired
    private DaoProduct daoProduct;
    @Autowired
    private DaoCustomer daoCustomer;


    public void setDaoProduct(DaoProduct daoProduct) {
        this.daoProduct = daoProduct;
    }


    public void setDaoCustomer(DaoCustomer daoCustomer) {
        this.daoCustomer = daoCustomer;
    }

    public List<Product> getAllProducts(){
        return daoProduct.findAll();
    }

    public List<Customer> getAllCustomers() {
        return daoCustomer.findAll();
    }

    public List<Product> getProductsByCustomerId(long customerId){
        return daoCustomer.getProductsByCustomerId(customerId);
    }

    public List<Customer> getCustomersByProductId(long productId){
        return daoProduct.getCustomersByProductId( productId);
    }
}
