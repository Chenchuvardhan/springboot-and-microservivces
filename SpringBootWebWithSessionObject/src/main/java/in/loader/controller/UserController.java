package in.loader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import in.loader.entity.User;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {
	@Autowired
	private HttpServletRequest request;
	HttpSession session;

	@GetMapping("/")
	public String userLogIn(Model model) {
		/*
		 * Creating User Object to send for Controller to UI(Presentation Layer)
		 */
		User userObj = new User();
		model.addAttribute("user", userObj);
		return "home";
	}

	@PostMapping("/validate")
	@ResponseBody
	public String ValiadateUser(User user, Model model) {
		session=request.getSession(true);
		String email = user.getEmail();
		session.setAttribute("user", email);
		if (session.getAttribute("user").equals("chenchuvardhang@gmail.com") && user.getPassword().equals("123")) {
			return email + " logged in Successfuly";
		}
		return "please Check your credentials again";
	}

	@GetMapping("/education")
	@ResponseBody
	public String eduDetails() {
		session=request.getSession(true);
		session.invalidate();
		return "your Session Is valid";
	}
}
