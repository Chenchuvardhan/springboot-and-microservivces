package in.peopletech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class MicroServiceAdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceAdminServerApplication.class, args);
	}

}
