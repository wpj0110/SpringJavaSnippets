import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.plurasight.service.CustomerService;

public class Application {
	public static void main(String[] args) {
		
		ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
		
		//CustomerService service = new CustomerServiceImpl(); //there is no need for this anymore since an instance of the bean is already created thanks to Spring
		
		CustomerService service = appContext.getBean("customerService",CustomerService.class);
		
		System.out.println(service);
		
		CustomerService service2 = appContext.getBean("customerService",CustomerService.class);
		
		System.out.println(service2);
		
		System.out.println(service.findAll().get(0).getFirstname());
		//System.out.println(service.findAll().get(0).getLastname());
	}
}
