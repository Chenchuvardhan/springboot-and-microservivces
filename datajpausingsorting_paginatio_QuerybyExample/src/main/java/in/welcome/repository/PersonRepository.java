package in.welcome.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.welcome.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
