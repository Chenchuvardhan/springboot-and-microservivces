package in.movierulz;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.annotation.Resource;

@Controller
public class ResponseController {
	@GetMapping("/")
	@ResponseBody
	public String getMSg(@RequestParam String name) {
		return name+" in ayyappa mala";
	}
	@GetMapping("/{name}")
	@ResponseBody
	public String getPath(@PathVariable("name") String raj) {
		return "hai "+raj;
	}
}
