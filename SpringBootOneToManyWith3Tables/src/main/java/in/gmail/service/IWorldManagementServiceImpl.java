package in.gmail.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.gmail.entity.Country;
import in.gmail.entity.States;
import in.gmail.repository.CountryRepository;
import in.gmail.repository.StatesRepository;
@Service
public class IWorldManagementServiceImpl implements IWorldManagementService {
	@Autowired
	private CountryRepository countryRepo;
	@Autowired
	private StatesRepository stateRepo;
	@Override
	public String CountryandStateAndCitySave(Country country) {
		Country save = countryRepo.save(country);
		//List<States> saveAll = stateRepo.saveAll(list);
		System.out.println(save);
		return "Country Saved";
	}
}
