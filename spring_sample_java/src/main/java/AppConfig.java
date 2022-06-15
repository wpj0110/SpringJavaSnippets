import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan({"com.plurasight"})
@PropertySource("app.properties")
public class AppConfig {
	
	//This class takes all the properties that were loaded in from the property's source location,
	//and puts them in this class and makes them available in the context for our application to use.
	@Bean
	public static PropertySourcesPlaceholderConfigurer getPropertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}
	
//	@Bean(name = "customerService")
//	public CustomerService getCustomerService() {
//		//CustomerServiceImpl service = new CustomerServiceImpl(getCustomerRepository());
//		CustomerServiceImpl service = new CustomerServiceImpl();
//		//service.setCustomerRepository(getCustomerRepository());
//		return service;
//	}
	
//	@Bean(name = "customerRepository")
//	public CustomerRepository getCustomerRepository() {
//		return new HibernateCustomerRepositoryImpl();
//	}
	
	
}
