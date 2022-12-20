import hw_hibernate.ShopService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("hw_hibernate");
        ShopService service = context.getBean("shopService",ShopService.class);

        System.out.println(service.getAllProducts());
        System.out.println(service.getAllCustomers());
        System.out.println("**************************************");
        System.out.println(service.getProductsByCustomerId(1l));
        System.out.println("**************************************");
        System.out.println(service.getCustomersByProductId(1l));
        System.out.println("**************************************");
    }

}
