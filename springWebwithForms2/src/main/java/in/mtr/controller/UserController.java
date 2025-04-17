package in.mtr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.mtr.entity.User;
import in.mtr.service.IUserService;
import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

@Controller
@RequestMapping("/register")
public class UserController {
	@Autowired
	private IUserService userService;

	@GetMapping("/userform")
	public String getUserForm(Model model) {
		model.addAttribute("user", new User());
		return "UserForm";
	}

	@PostMapping("/submit")
	public String saveUser(@Valid User user, 
			  BindingResult result,Model model) {
		if(result.hasErrors()) {
			return "UserForm";
		}
		Integer registerUser = userService.registerUser(user);
		if(registerUser!=null)
		model.addAttribute("msg","Registered Successfully");
		else
			model.addAttribute("msg","Please Provide Right Information");
		return "UserForm";
	}

	@GetMapping("/allusers")
	public String getUsers(Model model) {
		List<User> list = userService.getUsers();
		model.addAttribute("users", list);
		return "UserTable";
	}

	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable Integer id, Model model) {
		User user = userService.getUser(id);
		model.addAttribute("user", user);
		return "UserForm";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Integer id, Model model) {
		userService.deleteUser(id);
		List<User> list = userService.getUsers();
		model.addAttribute("users", list);
		return "UserTable";
	}
}
