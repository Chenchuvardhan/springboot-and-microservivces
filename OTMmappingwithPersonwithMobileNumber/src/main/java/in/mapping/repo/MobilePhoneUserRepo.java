package in.mapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mapping.entity.MobilePhoneUser;

public interface MobilePhoneUserRepo extends JpaRepository<MobilePhoneUser, Integer> {

}
