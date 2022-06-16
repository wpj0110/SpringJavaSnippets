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

///////////////////////////////The two methods below COULD BE paired together////////////////////////
//	@Bean(name = "customerService") //this is a bean
//	public CustomerService getCustomerService() { //Choose either a setter injection or a constructor injection
//		//CustomerServiceImpl service = new CustomerServiceImpl(getCustomerRepository()); //constructor injection here
//	
//		//CustomerServiceImpl service = new CustomerServiceImpl(); //setter injection here.
//		//service.setCustomerRepository(getCustomerRepository()); //setter injection here.
//	
//	    //The line of code below relies on autowiring. Choose either setter or constructor injection. 
//	    //CustomerServiceImpl service = new CustomerServiceImpl(); //if you've used @Autowired, it may have been either a setter or a constructor! Refer to CustomerServiceImpl.java
//		
//	    //return service;
//	}
//	
//	@Bean(name = "customerRepository")
//	public CustomerRepository getCustomerRepository() {
//		return new HibernateCustomerRepositoryImpl();
//	}
//////////////////////////////////////////////////////////////////////////////////////////////////
	
}
