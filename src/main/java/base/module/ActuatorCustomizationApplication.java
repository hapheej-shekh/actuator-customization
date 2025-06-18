package base.module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**	Spring Boot 2.x Actuator support CURD model,
 * 	It supports read, writes and delete operation with the end-points
 * 
 * 	The @Endpoint annotation can be used in combination with 
 * 	@ReadOperation,@WriteOperation and @DeleteOperation to develop end-points
 *
 *	bypass/allow security for Actuator
 */
@SpringBootApplication
public class ActuatorCustomizationApplication {

	public static void main(String[] args) {
	
		SpringApplication.run(ActuatorCustomizationApplication.class, args);
	}
}
