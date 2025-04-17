package in.disney.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.disney.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
public abstract User findByEmailAndPassword(String email,String password);
public abstract Optional<User> findByEmail(String email);
}
