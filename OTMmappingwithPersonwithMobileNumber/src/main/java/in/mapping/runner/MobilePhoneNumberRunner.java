package in.mapping.runner;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.mapping.entity.MobilePhoneUser;
import in.mapping.entity.PhoneNumber;
import in.mapping.service.IMobilePhoneUsersService;
@Component
public class MobilePhoneNumberRunner implements CommandLineRunner {
    @Autowired
    private  IMobilePhoneUsersService  mobilePhoneUserService;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//mobilePhoneUserService.saveMobilePhoneUserWithPhoneNumbers();
		//mobilePhoneUserService.FindAllThePhoneNumbers();
	    //mobilePhoneUserService.findChildsOnly(10001);
		PhoneNumber phno=new PhoneNumber();
		MobilePhoneUser mobUser=new MobilePhoneUser();
		mobUser.setEmail("sharukhgurram@gmail.com");mobUser.setUsername("Chenchuvardhan");
		mobUser.setGender("male");mobUser.setMobileNumber("8247228775");
		mobUser.setPersonId(1);
		mobUser.setPhoneNumbersList(Set.of(phno));
		phno.setContactName("amma");phno.setMobilePhoneUser(mobUser);
		phno.setMobileNumber("9440458151");phno.setPhoneNumberId(10001);
		mobilePhoneUserService.deleteChilds(phno);
	}

}
