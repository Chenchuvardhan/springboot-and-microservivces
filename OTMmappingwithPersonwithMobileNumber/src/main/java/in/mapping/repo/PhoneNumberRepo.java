package in.mapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mapping.entity.PhoneNumber;

public interface PhoneNumberRepo extends JpaRepository<PhoneNumber, Integer> {

}
