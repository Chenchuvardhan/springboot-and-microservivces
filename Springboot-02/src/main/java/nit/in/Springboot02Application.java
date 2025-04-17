package nit.in;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Springboot02Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(Springboot02Application.class, args);
		System.out.println(run.getClass().getName());
		System.out.println("Bean Definition count ::"+run.getBeanDefinitionCount());
	}
}
