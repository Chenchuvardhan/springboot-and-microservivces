package in.disney.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import in.disney.dto.Quote;
import in.disney.dto.ResetPasswordDto;
import in.disney.dto.UserDto;
import in.disney.service.IUserService;

@Controller
public class UserController {
	@Autowired
	private IUserService userService;
    @GetMapping(value="/login")
	public String getLoginPage(Model model) {
    	UserDto userDto=new UserDto();
    	model.addAttribute("userdto",userDto);
		return "loginpage";
	}
    @PostMapping(value="/validateuser")
    public String  validateUserLogin(UserDto userDto,Model model) {
    	String email = userDto.getEmail();
    	String password=userDto.getPassword();
    	System.out.println(email);
    	System.out.println(password);
    	UserDto checkLogIn = userService.checkLogIn(email, password);
    	if(checkLogIn!=null) {
    	if(checkLogIn.getPasswordStatus().equals("not updated")){
    		ResetPasswordDto resetPasswordDto = new ResetPasswordDto();
    		resetPasswordDto.setEmail(email);
    		model.addAttribute("resetdto",resetPasswordDto);
    		return "resetpasswordpage";
    	}
    	else {
    		Quote quote = userService.getQuote();
    		model.addAttribute("quote", quote);
    		return "dashboardpage";
    	}
    	}
    	model.addAttribute("status","please check your credentials once");
    	model.addAttribute("userdto",new UserDto());
    	return "loginpage";
    }
    @GetMapping(value="/register here")
    public String getRegisterPage(Model model) {
    	UserDto userDto = new UserDto();
    	model.addAttribute("userdto", userDto);
    	Map<Integer,String> countries = userService.getCountries();
    	System.out.println(countries);
    	model.addAttribute("map",countries);
    	return "registerpage";
    }
    @PostMapping(value="/register")
    public String registerUser(UserDto userDto,Model model) {
		boolean isUserRegistered= userService.registerUser(userDto);
		if(isUserRegistered) {
			model.addAttribute("msg","please login");
			model.addAttribute("status","you registered successfully...");
			Map<Integer,String> countries = userService.getCountries();
	    	model.addAttribute("map",countries);
			model.addAttribute("userdto",new UserDto());
	    	return "registerpage";
		}
		Map<Integer,String> countries = userService.getCountries();
    	model.addAttribute("map",countries);
		model.addAttribute("userdto",new UserDto());
		model.addAttribute("emsg","please enter unique email");
    	return "registerpage";
    }
    @PostMapping(value="/resetpassword")
    public String resetPassword(ResetPasswordDto resetPassword,Model model) {
    	UserDto checkLogIn = userService.checkLogIn(resetPassword.getEmail(),resetPassword.getOldPassword());
        if(checkLogIn==null) {
        model.addAttribute("msg","Password Incorrect");
        ResetPasswordDto resetPasswordDto = new ResetPasswordDto();
		resetPasswordDto.setEmail(resetPassword.getEmail());
		model.addAttribute("resetdto",resetPasswordDto);
    	return "resetpasswordpage";
        }
        System.out.println(resetPassword.getNewPassword()+"---"+resetPassword.getConfirmPassword());
        System.out.println(resetPassword.getNewPassword().equals(resetPassword.getConfirmPassword()));
        if(resetPassword.getNewPassword().equals(resetPassword.getConfirmPassword())){
        	model.addAttribute("smsg","Password Changed");
        	ResetPasswordDto resetPasswordDto = new ResetPasswordDto();
    		resetPasswordDto.setEmail(resetPassword.getEmail());
    		model.addAttribute("resetdto",resetPasswordDto);
            userService.resetPassword(resetPassword);
        	return "resetpasswordpage";
        }
        else {
        	ResetPasswordDto resetPasswordDto = new ResetPasswordDto();
    		resetPasswordDto.setEmail(resetPassword.getEmail());
    		model.addAttribute("resetdto",resetPasswordDto);
        	model.addAttribute("msg","New Password is not matching with Confirm password");
        	return "resetpasswordpage";
        }
    } 
    @GetMapping(value="/states/{cid}")
    @ResponseBody
    public Map<Integer,String> getStates(@PathVariable Integer cid) {
    	Map<Integer,String> states = userService.getStates(cid);
    	return states;
    }
    @GetMapping(value="/cities/{sid}")
    @ResponseBody
    public Map<Integer,String> getCities(@PathVariable Integer sid) {
    	Map<Integer,String> cities = userService.getCities(sid);
    	return cities;
    }
    @GetMapping(value="/dashboard")
    public String getDashboardPage(Model model) {
    	Quote quote = userService.getQuote();
		model.addAttribute("quote", quote);
    	return "dashboardpage";
    }
}