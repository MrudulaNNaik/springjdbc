package basic.model;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.StudentDaoHelper;
import basic.dao.StudentDao;
import basic.dao.StudentDaoImpl;
import basic.model.Student;

public class PlayJdbc {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		StudentDaoImpl studentDao = (StudentDaoImpl) context.getBean("studentDao");
		List<Student> students = studentDao.getAllStudents();
		printStudents(students);
		
	
		
		
		
		
		
		
		
		//StudentDaoHelper helper = context.getBean("studentDaoHelper",StudentDaoHelper.class);
		//helper.insertStudents();
		
		
	}

	private static void printStudents(List<Student> students) {
		for(Student s : students) {
			System.out.println(s);
		}
		
	}
}

