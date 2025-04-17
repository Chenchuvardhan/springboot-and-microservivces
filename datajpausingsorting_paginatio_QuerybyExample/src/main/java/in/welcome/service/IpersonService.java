package in.welcome.service;

import java.util.List;

import in.welcome.entity.Person;

public interface IpersonService {
Person savePerson();
List<Person> findPersons();

}
