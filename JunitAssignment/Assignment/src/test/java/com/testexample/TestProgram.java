package com.testexample;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mockito;

import Dao.StudentRecord;
import demo.Demo;

public class TestProgram {
	
	StudentRecord studentRecord;
	
	@Before
	@Test
	public void checkIfDataIsComing() {
		System.out.println("Before Test");
		Demo demo = new Demo();
		ArrayList<StudentRecord> stuList = new ArrayList<StudentRecord>();
		try {
			stuList = demo.getDataFromCSV(stuList, Demo.readLocation);
			assertEquals("student-0", stuList.get(0).getName());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@After
	@Test
	public void checkTopper() {
		System.out.println("After Test");
		ArrayList<StudentRecord> stuList = new ArrayList<StudentRecord>();
		Demo demo = new Demo();
		try {
			stuList = demo.getDataFromCSV(stuList, Demo.readLocation);
			stuList = demo.sortTheList(stuList);
			assertEquals("student-775", stuList.get(0).getName());
			// assertEquals("student-775", stuList.get(0).getName()); //shows an error
			//Mockito.verify(StudentRecord, Mockito.times(1)).notifyStudent(Mockito.any(StudentRecord.class));
			demo.writeDataIntoCSV(stuList, Demo.writeLocation);
			} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void checkingMainMethodsUsingMockito() {
		Demo test = Mockito.spy(new Demo());
		ArrayList<StudentRecord> stuList = new ArrayList<StudentRecord>();
		try {
			stuList = test.getDataFromCSV2(stuList);
			stuList = test.sortTheList(stuList);
			test.writeDataIntoCSV2(stuList);
			
			//Main Methods Tested
			Mockito.verify(test, Mockito.times(1)).getDataFromCSV2(Mockito.any());
			Mockito.verify(test, Mockito.times(1)).sortTheList(Mockito.any());
			Mockito.verify(test, Mockito.times(1)).writeDataIntoCSV2(Mockito.any());
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void checkingStudentRecordMethodsUsingMocks() {
		//Internal methods Tested
		StudentRecord record = Mockito.spy(new StudentRecord());
		record.setName("Aman");
		record.setDate(new Date("24/07/1996"));
		record.setSub1(90);
		record.setSub2(99);
		record.setSub3(98);
		record.setSub4(100);
		System.out.println(record);
		Mockito.verify(record, Mockito.times(1)).getName();
		Mockito.verify(record, Mockito.times(1)).getDate();
		Mockito.verify(record, Mockito.times(1)).getSub1();
		Mockito.verify(record, Mockito.times(1)).getSub2();
		Mockito.verify(record, Mockito.times(1)).getSub3();
		Mockito.verify(record, Mockito.times(1)).getSub4();
		Mockito.verify(record, Mockito.times(1)).getSum();
		Mockito.verify(record, Mockito.times(1)).getPercentile();
		
	}

	@Test(expected=Exception.class)
	public void checkForExceptions() throws Exception {
		ArrayList<StudentRecord> stuList = new ArrayList<StudentRecord>();
		Demo demo = new Demo();
		try {
			demo.getDataFromCSV(stuList,"C://test.java");
		}catch(Exception ex) {
			System.out.println("File not found");
		}
		try {
			demo.writeDataIntoCSV(stuList,"C://test.java");
		}catch(Exception ex) {
			
		}
	}

}
