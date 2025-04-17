package in.mapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class SpringTransactions1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringTransactions1Application.class,args);
	}

}
