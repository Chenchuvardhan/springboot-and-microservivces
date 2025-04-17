package in.peopletech.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.peopletech.fiegn.WelcomeFeignClient;

@RestController
public class GreetController {
	@Autowired
	private WelcomeFeignClient welcomeFiegnClient;

	@GetMapping("/greet")
	public String greetMsg() {
		String greet = "<< Good After Noon..... >>";
		// String welcomeApiUrl="http://localhost:8081/greet";
		String welcomeMsg = welcomeFiegnClient.getWelcomeMsg();
		return greet + " " + welcomeMsg;
	}
}
