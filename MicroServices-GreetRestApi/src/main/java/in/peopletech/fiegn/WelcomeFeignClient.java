package in.peopletech.fiegn;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "MicroServices-WelcomeRestApi")
public interface WelcomeFeignClient {
	@GetMapping("/welcome")
	public abstract String getWelcomeMsg();
}
