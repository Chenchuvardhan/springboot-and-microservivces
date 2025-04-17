package in.mapping.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mapping.entity.MobilePhoneUser;
import in.mapping.entity.PhoneNumber;
import in.mapping.repo.MobilePhoneUserRepo;
import in.mapping.repo.PhoneNumberRepo;
import jakarta.transaction.Transactional;

@Service
public class MobilePhoneUserImpl implements IMobilePhoneUsersService {
	@Autowired
	private MobilePhoneUserRepo mobilePhoneRepo;
	@Autowired
	private PhoneNumberRepo phoneNumberRepo;

	@Transactional(rollbackOn = Exception.class)
	public void saveMobilePhoneUserWithPhoneNumbers() {
		MobilePhoneUser user = new MobilePhoneUser("siva@gmail.com", "Br Siva", "8247228656", "male");
		/*PhoneNumber phoneNumber1 = new PhoneNumber("chenchu", "9456897621", user);
		PhoneNumber phoneNumber2 = new PhoneNumber("charan", "6567655862", user);
		PhoneNumber phoneNumber3 = new PhoneNumber("varaprasad", "9676362871", user);
		user.setPhoneNumbersList(Set.of(phoneNumber1, phoneNumber2, phoneNumber3));
		*/mobilePhoneRepo.save(user);
	}

	public void FindAllThePhoneNumbers() {
		List<MobilePhoneUser> all = mobilePhoneRepo.findAll();
		all.forEach(i -> {
			System.out.println(i.getUsername());
			System.out.println(i.getMobileNumber());
			System.out.println(i.getEmail());
			Set<PhoneNumber> phoneNumbersList = i.getPhoneNumbersList();
			System.out.println("Phone Numbers List start :--------");
			phoneNumbersList.forEach(k -> {
				System.out.println(k.getPhoneNumberId());
				System.out.println(k.getContactName());
				System.out.println(k.getMobileNumber());
			});
			System.out.println("Phone Numbers List end :--------");
		});

	}
	@Override
	public void findChildsOnly(Integer id) {
		Optional<PhoneNumber> byId = phoneNumberRepo.findById(id);
		if(byId.isPresent()) {
			PhoneNumber phoneNumber = byId.get();
			System.out.println(phoneNumber);
		}
		else {
			System.out.println("Invalid User Id");
		}
	}

	@Override
	public void deleteChilds(PhoneNumber phno) {
		Optional<PhoneNumber> byId = phoneNumberRepo.findById(10001);
		PhoneNumber phoneNumber = byId.get();
		phoneNumber.setMobilePhoneUser(null);
		phoneNumberRepo.delete(phoneNumber);
		System.out.println("Childs deleted successfulluy");
	}

}
