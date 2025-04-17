package in.gmail.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import in.gmail.entity.City;

public interface CityRepository extends JpaRepository<City,Integer> {

}
