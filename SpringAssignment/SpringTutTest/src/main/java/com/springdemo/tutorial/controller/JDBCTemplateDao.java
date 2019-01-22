package com.springdemo.tutorial.controller;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.stereotype.Component;

import com.springdemo.tutorial.Student;
import com.springdemo.tutorial.StudentMapper;

@Component
public class JDBCTemplateDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int saveStudent(Student student){
		String query = "insert into student(studentID,name) values "
				+ "("+student.getStudentId()+",'"+student.getStudentName()+"')";
		return jdbcTemplate.update(query);
	}
	
	public Boolean saveStudentUsingPreparedStatement(final Student student){
		String query = "insert into student(studentID,name) values (?,?)";
		return jdbcTemplate.execute(query, new PreparedStatementCallback<Boolean>() {

			public Boolean doInPreparedStatement(PreparedStatement ps)
					throws SQLException, DataAccessException {
				ps.setString(1, student.getStudentId());
				ps.setString(2, student.getStudentName());
				return ps.execute();
			}
		});
	}
	
	public List<Student> getTopStudents(){
		String query = "select * from student";
		return jdbcTemplate.query(query, new StudentMapper());
	}
	
	public List<Student> getStudentById(int id) {
		String query = "select * from student where studentID="+id;
		return jdbcTemplate.query(query, new StudentMapper());
	}
	
	
	
	
}