package in.nirma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.nirma.mappings.EmployeeDto;
import in.nirma.service.IEmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private IEmployeeService empService;

	@PostMapping(value = "/register", consumes = { "application/json", "application/xml" }, produces ="text/plain")
	public ResponseEntity<String> registerEmployee(@RequestBody EmployeeDto dto) {
		System.out.println(dto);
		EmployeeDto saveEmployee = empService.saveEmployee(dto);
		return new ResponseEntity<String>(saveEmployee.getName() + " registered with " + saveEmployee.getId(),
				HttpStatus.CREATED);
	}

	@PutMapping(value = "/updateemp", consumes = { "application/json", "application/xml" }, produces =
			"plain/text")
	public ResponseEntity<String> updateEmployee(@RequestBody EmployeeDto dto) {
		EmployeeDto saveEmployee = empService.updateEmployee(dto);
		return new ResponseEntity<String>(saveEmployee.getName() + " updated with " + saveEmployee.getId(),
				HttpStatus.CREATED);
	}

	@GetMapping(value = "/getemps", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<List<EmployeeDto>> retrieveAllEmployees() {
		List<EmployeeDto> allEMployees = empService.getAllEMployees();
		return new ResponseEntity<List<EmployeeDto>>(allEMployees, HttpStatus.OK);
	}

	@GetMapping(value = "/getemp", consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<EmployeeDto> fetchEmployeeById(@RequestParam("id") int id) {
		EmployeeDto employee = empService.getEmployee(id);
		if (employee != null) {
			return new ResponseEntity<EmployeeDto>(employee, HttpStatus.OK);
		}
		return new ResponseEntity<EmployeeDto>(employee, HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete", consumes = { "application/json", "application/xml" }, produces = "text/plain")
	public ResponseEntity<String> deleteEmployee(@RequestParam int id) {
		EmployeeDto deleteEmployee = empService.deleteEmployee(id);
		if (deleteEmployee != null) {
			return new ResponseEntity<String>(deleteEmployee.getName() + " deleted", HttpStatus.OK);
		}
		return new ResponseEntity<String>(id + " with record not available", HttpStatus.OK);
	}
}
