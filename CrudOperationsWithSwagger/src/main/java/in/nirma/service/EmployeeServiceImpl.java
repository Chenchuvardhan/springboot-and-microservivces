package in.nirma.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nirma.entity.Employee;
import in.nirma.mappings.EmployeeDto;
import in.nirma.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	private EmployeeRepository empRepo;

	public EmployeeDto saveEmployee(EmployeeDto empDto) {
		// copy the data from dto object to employee Object
		Employee emp = getEmployeeObj(empDto);
		Employee save = empRepo.save(emp);
		empDto.setId(save.getId());
		return empDto;
	}

	@Override
	public EmployeeDto updateEmployee(EmployeeDto empDto) {
		Employee emp = getEmployeeObj(empDto);
		Employee save = empRepo.save(emp);
        EmployeeDto empData=getEmployeeDtoObj(save);		
		return empDto;
	}

	@Override
	public List<EmployeeDto> getAllEMployees() {
		// TODO Auto-generated method stub
		List<Employee> all = empRepo.findAll();
		List<EmployeeDto> list = new ArrayList<>();
		all.forEach(employee -> {
			EmployeeDto empDto = new EmployeeDto();
			BeanUtils.copyProperties(employee, empDto);
			list.add(empDto);
		});
		return list;
	}

	@Override
	public EmployeeDto getEmployee(int id) {
		// get the EmployeeObject based On the Id
		Optional<Employee> byId = empRepo.findById(id);
		if (byId.isPresent()) {
			Employee employee = byId.get();
			EmployeeDto empDto = getEmployeeDtoObj(employee);
			return empDto;
		}
		return null;
	}

	@Override
	public EmployeeDto deleteEmployee(int id) {
		// delete the employee based on the id
		boolean existsById = empRepo.existsById(id);
		if (existsById) {
			empRepo.deleteById(id);
		}
		return null;
	}

	private Employee getEmployeeObj(EmployeeDto employeeDto) {
		Employee employee = new Employee();
		BeanUtils.copyProperties(employeeDto, employee);
		System.out.println("emp :"+employee);
		return employee;
	}

	private EmployeeDto getEmployeeDtoObj(Employee emp) {
		EmployeeDto empDto = new EmployeeDto();
		BeanUtils.copyProperties(emp, empDto);
		return empDto;

	}
}
