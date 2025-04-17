package in.disney.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.disney.entity.City;

public interface CityRepository extends JpaRepository<City, Integer> {
public abstract List<City> findByStateSid(Integer sid);
}
