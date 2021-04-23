package basic.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import basic.dao.StudentDao;
import basic.dao.StudentDaoImpl;
import basic.model.Student;

public class PlayJdbc {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		StudentDao studentDao = (StudentDao) context.getBean("studentDao");
		//studentDao.delRecordById(8);
		studentDao.delRecordByNameandSem("anu",6);
		
		
		
		
		//Student myStudent = new Student(7,"anu",6,78);
		//Student anotherStudent = new Student(8,"yash",6,95);
		//StudentDao studentDao = new StudentDaoImpl();
		
		//studentDao.insert(myStudent);
		//studentDao.insert(anotherStudent);
		
	}
}

