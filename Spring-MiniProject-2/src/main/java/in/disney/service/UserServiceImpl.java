package in.disney.service;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import in.disney.dto.Quote;
import in.disney.dto.ResetPasswordDto;
import in.disney.dto.UserDto;
import in.disney.entity.City;
import in.disney.entity.Country;
import in.disney.entity.State;
import in.disney.entity.User;
import in.disney.password.GeneratePassword;
import in.disney.repository.CityRepository;
import in.disney.repository.CountryRepository;
import in.disney.repository.StateReposiotry;
import in.disney.repository.UserRepository;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CountryRepository countryRepo;
	@Autowired
	private StateReposiotry stateRepo;
	@Autowired
	private CityRepository cityRepo;
	@Autowired
	private IEmailService emailService;

	@Override
	public UserDto checkLogIn(String email, String password) {
		System.out.println(email);
		System.out.println(password);
		// TODO Auto-generated method stub
		User user = userRepo.findByEmailAndPassword(email, password);
		UserDto userDto = new UserDto();
		if(user!=null) {
		BeanUtils.copyProperties(user, userDto);
		return userDto;
		}
		return null;
	}

	@Override
	public boolean isEmailUnique(String email) {
		// TODO Auto-generated method stub
		Optional<User> user = userRepo.findByEmail(email);
		System.out.println("present or not"+user.isPresent());
		if (user.isPresent()) {
			return true;
		}
		else {
		return false;
		}
	}

	@Override
	public Map<Integer, String> getCountries() {
		// TODO Auto-generated method stub
		List<Country> all = countryRepo.findAll();
		Map<Integer, String> countryData = new HashMap<>();
		all.stream().forEach(country -> {
			Integer countryId;
			String countryName;
			countryId = country.getCid();
			countryName = country.getCountryName();
			countryData.put(countryId,countryName);
		});
		return countryData;
	}

	@Override
	public boolean registerUser(UserDto userDto) {
		System.out.println(isEmailUnique(userDto.getEmail()));
		if (isEmailUnique(userDto.getEmail())) {
			return false;
		} else {
			// TODO Auto-generated method stub
			User user = new User();
			String passwordForUser = GeneratePassword.generatePasswordForUser();
		    emailService.sendPasswordThroughEmail(userDto.getEmail(),
					"Thank you for Registration", passwordForUser);
				BeanUtils.copyProperties(userDto, user);
				user.setPassword(passwordForUser);
				user.setPasswordStatus("not updated");
				Country country = countryRepo.findById(userDto.getCid()).get();
				State state = stateRepo.findById(userDto.getSid()).get();
				City city = cityRepo.findById(userDto.getCityId()).get();
				user.setCountry(country);user.setState(state);user.setCity(city);
		   userRepo.save(user);
				return true;
		}
	}

	@Override
	public Quote getQuote() {
		// TODO Auto-generated method stub
		String apiUrl = "https://dummyjson.com/quotes/random";
		WebClient webClient = WebClient.create();
		Mono<Quote> bodyToMono = webClient.get().uri(apiUrl).retrieve().bodyToMono(Quote.class);
		Quote quote = bodyToMono.block();
		return quote;
	}

	@Override
	public boolean resetPassword(ResetPasswordDto reset) {
		User byEmailAndPassword = userRepo.findByEmailAndPassword(reset.getEmail(),reset.getOldPassword());
		// TODO Auto-generated method stub
			byEmailAndPassword.setPassword(reset.getNewPassword());
			byEmailAndPassword.setPasswordStatus("updated");
			userRepo.save(byEmailAndPassword);
		return true;
	}

	@Override
	public Map<Integer,String> getStates(Integer countryId) {
		// TODO Auto-generated method stub
		List<State> byCountryCid = stateRepo.findByCountryCid(countryId);
		Map<Integer,String> stateMap = new HashMap<>();
		byCountryCid.stream().forEach(state -> {
			stateMap.put(state.getSid(),state.getStateName());
		});
		return stateMap;
	}
	@Override
	public Map<Integer,String> getCities(Integer cityId) {
		// TODO Auto-generated method stub
		List<City> byStateSid = cityRepo.findByStateSid(cityId);
		Map<Integer,String> cityMap = new HashMap<>();
		byStateSid.stream().forEach(city -> {
			cityMap.put(city.getCityId(), city.getCityName());
		});
		return cityMap;
	}

}
