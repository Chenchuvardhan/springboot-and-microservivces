package in.gmail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import in.gmail.entity.Country;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
