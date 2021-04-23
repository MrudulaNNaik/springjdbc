package basic;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import basic.dao.StudentDao;
import basic.model.Student;

@Service("studentDaoHelper")
public class StudentDaoHelper {
	@Autowired
	StudentDao studentDaoImpl;
	
	 public void insertStudents() {
		Student s1 = new Student(1, "Naik", 8, 43);
		Student s2 = new Student(2, "Madhu", 7, 39);
		Student s3 = new Student(3, "Apoo", 6, 80);
		Student s4 = new Student(4, "Soundarya", 5, 82);
		
		ArrayList<Student> students = new ArrayList<>();
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		studentDaoImpl.insert(students);
		System.out.println("batch updated");
	}
	

}
