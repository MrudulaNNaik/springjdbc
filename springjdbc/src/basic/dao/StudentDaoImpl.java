package basic.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import basic.model.Student;


@Repository("studentDao")
public class StudentDaoImpl  implements StudentDao{
	
	@Autowired 
	private JdbcTemplate jdbcTemplate ;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Override
	public void insert(Student student) {
		
		String sql = "INSERT INTO  student VALUES (?,?,?,?)";
		Object[] objects =	{student.getId(),student.getName(),student.getSem(),student.getAverage()};

		int no_rows_inserted =	jdbcTemplate.update(sql,objects);
		System.out.println("no of rows inserted  is "+ no_rows_inserted);
	
	}


	@Override
	public void delRecordById(int id) {
		String delSql = "DELETE FROM STUDENT WHERE id = ?";
		int noRecordsDeleted = jdbcTemplate.update(delSql,id);
		System.out.println("no of records deleted = "+ noRecordsDeleted);
	}


	@Override
	public int delRecordByNameandSem(String name, int sem) {
		String sql = "DELETE FROM STUDENT WHERE name = ? OR sem = ?";
		Object[] objects = {name,sem};
		int noRecordsDeleted = jdbcTemplate.update(sql,name,sem);
		System.out.println("no of records deleted ="+ noRecordsDeleted);
		return noRecordsDeleted;
	}
	
	public void cleanUp() {
		String sql = "TRUNCATE TABLE STUDENT";
		jdbcTemplate.update(sql);
		System.out.println("table cleaned");
	}
	
	public void insert(List<Student> students) {
		String sql = "INSERT INTO student VALUES (?,?,?,?)";
		ArrayList<Object[]> sqlArgs = new ArrayList<>();
		for(Student student : students) {
			Object[] studentData = {student.getId(),student.getName(),student.getSem(),student.getAverage()};
			sqlArgs.add(studentData);
		}

		jdbcTemplate.batchUpdate(sql, sqlArgs);	
	}
	
	@Override
	public List<Student> getAllStudents(){
		String sql = "SELECT * FROM STUDENT";
		List<Student> students = jdbcTemplate.query(sql,new StudentResultSetExtractor());
		//List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper());
		return students;
		
	}
	
	
	


	@Override
	public Student findStudentById(int id) {
		String sql = "SELECT * FROM STUDENT WHERE id = ?";
		Student student =	jdbcTemplate.queryForObject(sql, 
				new BeanPropertyRowMapper<Student>(Student.class),id);
		return student;
	}
	
}

