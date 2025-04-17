package in.springprofiles.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.springprofiles.Student;
import in.springprofiles.repository.StudentRepository;
@Service
public class IStudentServiceImpl implements IStudentService {
	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<Student> SaveAllStudents(List<Student> students) {
		List<Student> saveAll = studentRepo.saveAll(students);
		return saveAll;
		
	}
	
}
