import hw.hibernate.ShopService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("hw/hibernate");
        ShopService service = context.getBean("service",ShopService.class);

        System.out.println(service.getAllProducts());
    }

}
