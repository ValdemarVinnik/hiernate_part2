package hw.hibernate;

import hw.hibernate.db.DaoProduct;
import hw.hibernate.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShopService {

    private DaoProduct daoProduct;

    @Autowired
    public void setDaoProduct(DaoProduct daoProduct) {
        this.daoProduct = daoProduct;
    }

    public List<Product> getAllProducts(){
        return daoProduct.findAll();
    }
}
