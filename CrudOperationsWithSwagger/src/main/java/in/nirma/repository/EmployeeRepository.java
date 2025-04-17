package in.nirma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.nirma.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
