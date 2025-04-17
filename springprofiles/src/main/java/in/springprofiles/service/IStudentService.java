package in.springprofiles.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.springprofiles.Student;

@Service
public interface IStudentService {
	List<Student> SaveAllStudents(List<Student> studnets);

}
