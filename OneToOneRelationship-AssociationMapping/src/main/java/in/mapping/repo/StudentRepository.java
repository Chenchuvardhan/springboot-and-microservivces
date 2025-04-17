package in.mapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.mapping.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
