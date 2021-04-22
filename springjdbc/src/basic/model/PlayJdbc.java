package basic.model;

import basic.dao.StudentDao;
import basic.dao.StudentDaoImpl;
import basic.model.Student;

public class PlayJdbc {
	public static void main(String[] args) {
		Student myStudent = new Student(3, "apoorva", 5, 66);
		Student anotherStudent = new Student(4,"soundarya",6,88);
		Student anotherStudent2 = new Student(5,"sound",6,77);
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.insert(myStudent);
		
	}
}

