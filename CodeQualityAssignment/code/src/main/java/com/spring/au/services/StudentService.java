package com.spring.au.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.au.dao.StudentDao;
import com.spring.au.model.Student;

@Service
public class StudentService {
	
	@Autowired
	StudentDao studentDao;

	public String getName() {
		return studentDao.getName();
	}

	public String addStudent(Student student) {
		if(studentDao.addStudent(student)==1)
			return "Successfully Added";
		else
			return "Not successful";
	}
	
}
