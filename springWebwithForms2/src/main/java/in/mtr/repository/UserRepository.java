package in.mtr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mtr.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
