package in.mapping.service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.mapping.entity.HallTicket;
import in.mapping.entity.Student;
import in.mapping.repo.HallTicketRepository;
import in.mapping.repo.StudentRepository;
import jakarta.transaction.Transactional;

@Service
public class StudentHallTicketServiceImpl implements IStudentHallTicketService {
    @Autowired
    private StudentRepository studentRepo;
    @Autowired
    private HallTicketRepository hallTicketRepository; 
	@Override
	@Transactional(rollbackOn = Exception.class)
	public Student saveStudent() {
		// TODO Auto-generated method stub
		HallTicket hallTicket = new HallTicket("Rama Naidu",LocalDate.of(2002,3, 14),170);
		hallTicketRepository.save(hallTicket);
		Student student=new Student("Rama Naidu", 23,hallTicket);
		Student student1 = studentRepo.save(student);
		//int a=1/0;
		return student1;
	}
	public void findStudentsList() {
		Optional<HallTicket> byId2 = hallTicketRepository.findById(1);
		System.out.println(byId2.get());
		Optional<Student> byId = studentRepo.findById(1);
		System.out.println(byId.get());
	}

}
