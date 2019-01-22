package com.springdemo.tutorial.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.springdemo.tutorial.FactoryDemo;
import com.springdemo.tutorial.Student;
import com.springdemo.tutorial.controller.JDBCTemplateDao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;


@Controller
public class StudentController {
	
	@RequestMapping(value = "/getStudent",method=RequestMethod.GET,produces="application/json")
	@ResponseBody
	public Student getStudent(){
		/*TEST COMMAND*/
		 Student student = new Student();
		 student.setStudentId("15");
		 student.setStudentName("Accolite");
		 ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		 FactoryDemo demo = (FactoryDemo) applicationContext.getBean("FactoryDemo");
		 // factory method is displaying !
		 return student;
	}
	
	@RequestMapping(value="/getStudents",method=RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public List<Student> getStudents(){
		/*SEE ALL STUDENTS*/
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	    JDBCTemplateDao jdbcTemplateDao = (JDBCTemplateDao) applicationContext.getBean(JDBCTemplateDao.class);
		List<Student> list = jdbcTemplateDao.getTopStudents();
	    return list;
	}
	
	@RequestMapping(value = "/displayAll", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<String> showStudentsMVC(Model model) {
		
		/*TO SHOW ON THE WEBPAGE*/
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	    JDBCTemplateDao jdbcTemplateDao = (JDBCTemplateDao) applicationContext.getBean(JDBCTemplateDao.class);
		List<Student> list = jdbcTemplateDao.getTopStudents();
//		
//		model.addAttribute("studentList", studentList);
//		System.out.println("Model: " + model);
		
		HttpHeaders httpHeader = new HttpHeaders();
		httpHeader.add("Content-Type", "text/plain;charset=UTF-8");
		
//		return studentList;
		String resp = "";
		for(Student s: list) {
			resp += s + "\n";
		}
		
		return new ResponseEntity<String>(resp, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getStudent/{id}",method=RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public Student getStudent(@PathVariable("id")String id){
		/*GET STUDENT BY ID*/
		Student student = new Student();
	    student.setStudentId(id);	
	    student.setStudentName("XYZ");
	    return student;
	}
	
	 @RequestMapping(value = "/student", method = RequestMethod.GET)
	   public ModelAndView student() {
		 /* SHOW FORM METHOD */
	      return new ModelAndView("student", "command", new Student());
	   }
	 
	 @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	      public ModelAndView addStudent(@ModelAttribute("student") Student student, ModelAndView model) {
	     /*ADDING STUDENT USING SPRING-MVC and SPRING JDBC */ 
		 
		 System.out.println("**********************Inside Add Student****************");
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	      JDBCTemplateDao jdbcTemplateDao = (JDBCTemplateDao) applicationContext.getBean(JDBCTemplateDao.class);
	      
	      System.out.println(jdbcTemplateDao.saveStudent(student));
		//System.out.println(jdbcTemplateDao.saveStudentUsingPreparedStatement(student));
		  List<Student> list = jdbcTemplateDao.getTopStudents();
		  model.setViewName("result");
	      System.out.println(student);
	      System.out.print("List is "+list);
	      return model;
	   }
	  
	
	
	

}
