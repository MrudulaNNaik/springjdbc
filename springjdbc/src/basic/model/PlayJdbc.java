package basic.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.dao.StudentDao;
import basic.dao.StudentDaoImpl;
import basic.model.Student;

public class PlayJdbc {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");		
		Student myStudent = new Student(5,"shwetha",7,98);
		Student anotherStudent = new Student(6,"yashu",8,75);
		//StudentDao studentDao = new StudentDaoImpl();
		//studentDao.insert(myStudent);
		StudentDao studentDao = (StudentDao) context.getBean("studentDao");
		//studentDao.insert(myStudent);
		studentDao.insert(anotherStudent);
		
	}
}

