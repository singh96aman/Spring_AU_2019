package com.springdemo.tutorial;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {

	public static void main(String[] args) {
		
		ApplicationContext applicationContext  = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloWorld helloWorld =	(HelloWorld) applicationContext.getBean("helloWorld");
		helloWorld.printHello();
		
		/*HelloWorld helloWorld1 =	(HelloWorld) applicationContext.getBean("helloWorld1");
		helloWorld1.printHello();*/
		
/*		A a =  (A)applicationContext.getBean("a");
		B b =	a.getB();
		System.out.println("B values : "+b.getP() + " "+b.getQ()+" "+b.getR());*/
		
		
		/*B b = (B) applicationContext.getBean("b");
		System.out.println("B values for b: "+b.getP() + " "+b.getQ()+" "+b.getR());
		
		b.setP(4);
		B b1 = (B) applicationContext.getBean("b");
		System.out.println("B values for b1: "+b1.getP() + " "+b1.getQ()+" "+b1.getR());*/
		
		/*Question question = (Question)	applicationContext.getBean("question");		
		
		for(String str : question.list){
			System.out.println(str);
		}*/
		
		
/*		JDBCTemplateDao jdbcTemplateDao = (JDBCTemplateDao) applicationContext.getBean(JDBCTemplateDao.class);
		Student student = new Student();
		student.setStudentId(16);
		student.setStudentName("IBM");
		//jdbcTemplateDao.saveStudent(student);
		jdbcTemplateDao.saveStudentUsingPreparedStatement(student);*/
		
		
		
		
	}
	
}
