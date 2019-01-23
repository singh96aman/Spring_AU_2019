package com.spring.au.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring.au.model.Student;

@Repository
public class StudentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public String getName() {
		return jdbcTemplate.queryForObject("select studentName from student where studentId=4", String.class);
	}

	public int addStudent(Student student) {
		return jdbcTemplate.update("insert into student values ("+student.getStudentId()+",'"+student.getStudentName()+"')");
	}
	
}
