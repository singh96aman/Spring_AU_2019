package com.spring.au.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.au.model.Student;
import com.spring.au.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentContoller {

	@Autowired
	StudentService studentService;
	
	@GetMapping("/getStudent")
	public String getName() {
		return studentService.getName();
	}
	
	@PostMapping("/addStudent")
	public String addStudent(@RequestBody Student student) {
		return studentService.addStudent(student);
	}
	
}
