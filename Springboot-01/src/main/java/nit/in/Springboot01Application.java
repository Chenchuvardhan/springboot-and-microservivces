package nit.in;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

@SpringBootApplication
@RestController
public class Springboot01Application {
	@GetMapping("/welcome")
    public String getMsg() {
    	return "Welcome to Facebook";
    }
	public static void main(String[] args) {
		SpringApplication.run(Springboot01Application.class, args);
	}

}
