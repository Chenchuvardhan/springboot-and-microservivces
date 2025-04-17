package in.nirma.service;

import java.util.List;

import in.nirma.mappings.EmployeeDto;

public interface IEmployeeService {
public abstract EmployeeDto saveEmployee(EmployeeDto empDto);
public abstract EmployeeDto updateEmployee(EmployeeDto empDto);
public abstract List<EmployeeDto> getAllEMployees();
public abstract EmployeeDto getEmployee(int id);
public abstract EmployeeDto deleteEmployee(int id);
}
