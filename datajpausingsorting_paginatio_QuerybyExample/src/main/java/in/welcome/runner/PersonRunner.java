package in.welcome.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.welcome.entity.Person;
import in.welcome.service.IpersonService;
@Component
public class PersonRunner implements CommandLineRunner {
	@Autowired
	private IpersonService personService;

	@Override
	public void run(String... args) throws Exception {
		//Person savePerson = personService.savePerson();
		//System.out.println("person Registered with "+savePerson.getId());
        personService.findPersons().forEach(System.out::println);
	}

}
