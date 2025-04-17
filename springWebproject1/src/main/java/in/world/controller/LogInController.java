package in.world.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/good")
public class LogInController {
@GetMapping("/welcome")
 public String welcome(Model model) {
	model.addAttribute("msg","Welcome to Naresh It");
	return "welcome"; 
 }
@GetMapping("/greetings")
public String  greet(Model model) {
	model.addAttribute("msg","Greetings to Naresh It");
	return "welcome"; 
}
}
