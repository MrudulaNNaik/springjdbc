package basic.dao;
import java.util.List;

import basic.model.Student;

public interface StudentDao {
	 void insert(Student student);
	 void delRecordById(int id);
	 int delRecordByNameandSem(String name, int sem);
	 void insert(List<Student> students);
	 public List<Student> getAllStudents();
	

}