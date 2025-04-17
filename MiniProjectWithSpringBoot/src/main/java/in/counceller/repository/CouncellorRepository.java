package in.counceller.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.counceller.entity.Councellor;

public interface CouncellorRepository extends JpaRepository<Councellor,Integer> {
public Optional<Councellor> findByEmailAndPassword(String email,String password);
}
