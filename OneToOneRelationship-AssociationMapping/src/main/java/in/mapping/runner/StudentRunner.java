package in.mapping.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.mapping.service.IStudentHallTicketService;
@Component
public class StudentRunner implements CommandLineRunner {
	@Autowired
    private IStudentHallTicketService studentHallTicketService;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		studentHallTicketService.saveStudent();
		studentHallTicketService.findStudentsList();
	}

}
