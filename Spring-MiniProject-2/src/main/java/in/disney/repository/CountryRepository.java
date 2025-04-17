package in.disney.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.disney.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
