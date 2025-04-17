package in.springprofiles.runners;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import in.springprofiles.Student;
import in.springprofiles.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Component
public class StudentRunner implements CommandLineRunner {
	@Autowired
	private IStudentService studentService;

	@Override
	public void run(String... args) throws Exception {
    List<Student> asList = Arrays.asList(new Student("sai",19,"9877655252"),
    		      new Student("pradeep",21,"9877609452"),
    		      new Student("omkaram",45,"9877687652"),
    		      new Student("ankaiah",32,"9877689752"),
    		      new Student("suresh",54,"8977655252"),
    		      new Student("valeed",76,"8967655252"),
    		      new Student("subhan",43,"9877655252"),
    		      new Student("naina",32,"9443255252"),
    		      new Student("Satya",29,"9878755252"),
    		      new Student("Krishna",18,"9887655252"),
    		      new Student("Meeravali",17,"95677655252"));
    System.out.println(studentService.SaveAllStudents(asList));
    log.info("retriving students suceessfully");
	}

}
