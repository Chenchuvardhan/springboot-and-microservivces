package in.gmail.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.gmail.entity.City;
import in.gmail.entity.Country;
import in.gmail.entity.States;
import in.gmail.service.IWorldManagementService;

@Component
public class WorldMapRunner implements CommandLineRunner {
	@Autowired
	private IWorldManagementService worldService;

	@Override
	public void run(String... args) throws Exception {
		// Create Parent Country class Object
		Country country1 = new Country();
		country1.setCountryName("India");
		// Create State Class Objects and set to Country
		States state1 = new States();
		States state2 = new States();
		state1.setStateName("Andhrapradesh");
		state1.setCountry(country1);
		state2.setStateName("MadhyaPradesh");
		state2.setCountry(country1);
		// Create City Objects
		City city1 = new City();
		city1.setCityName("Vizag");
		city1.setState(state1);
		City city2 = new City();
		city2.setCityName("Vijayawada");
		city2.setState(state1);
		City city3 = new City();
		city3.setCityName("Tirupathi");
		city3.setState(state1);
		// set Cities to States
		state1.setClist(List.of(city1, city2, city3));
		City city11 = new City();
		city11.setCityName("Indore");
		city11.setState(state2);
		City city22 = new City();
		city22.setCityName("Gwalior");
		city22.setState(state2);
		City city33 = new City();
		city33.setCityName("Bhopal");
		city33.setState(state2);
		state2.setClist(List.of(city11, city22, city33));
		// set States to Country
		country1.setSlist(List.of(state1, state2));
		// Calling Service Class Methods
		String countryandStateAndCitySave = worldService.CountryandStateAndCitySave(country1);
		System.out.println(countryandStateAndCitySave);
	}

}
