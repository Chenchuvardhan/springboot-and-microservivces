package in.springprofiles.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.springprofiles.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
