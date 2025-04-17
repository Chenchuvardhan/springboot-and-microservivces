package in.welcome.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import in.welcome.entity.Person;
import in.welcome.repository.PersonRepository;

@Service
public class IServiceImpl implements IpersonService {
	@Autowired
	private PersonRepository personRepo;

	@Override
	public Person savePerson() {
		
		return personRepo.save(new Person("Latha","China",27,"Fe-Male"));
	}

	@Override
	public List<Person> findPersons() {
		//int pagenumber=4;
		//int pageSize=3;
		//Pageable page= PageRequest.of(pagenumber-1,pageSize);
		 //Page<Person> all = personRepo.findAll(page);
		 //all.forEach(System.out::println);
		Person p=new Person();
		p.setGender("Male");
		Example<Person> of = Example.of(p);
		 return personRepo.findAll(of);
	}
}
