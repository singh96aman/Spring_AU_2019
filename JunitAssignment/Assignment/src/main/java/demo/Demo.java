package demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeSet;

import Dao.StudentRecord;

import java.util.Date;
import java.util.Iterator;

public class Demo {
	
	public static String readLocation = "C:\\Users\\aman.singh\\Junit\\Assignment\\src\\main\\java\\demo\\data.csv";
	public static String writeLocation = "C:\\Users\\aman.singh\\Junit\\Assignment\\src\\main\\java\\demo\\result.csv";
	
	
	/*public static void main(String[] args) throws IOException {
		Demo demo = new Demo();
		ArrayList<StudentRecord> stuList = new ArrayList<StudentRecord>();
		stuList = demo.getDataFromCSV(stuList, readLocation);
		System.out.println("Getting Data from CSV "+stuList);
		stuList=demo.sortTheList(stuList);
		System.out.println("Sorted List "+stuList);
		demo.writeDataIntoCSV(stuList, writeLocation);
	}*/
	

	public ArrayList<StudentRecord> getDataFromCSV(ArrayList<StudentRecord> stuList, String location) throws NumberFormatException, IOException {
			BufferedReader reader;
			try {
				reader = new BufferedReader(new FileReader(location));
				String line = null;
				Scanner scanner = null;
				int index = 0;
				stuList = new ArrayList<StudentRecord>();

						while ((line = reader.readLine()) != null) {
							StudentRecord stu = new StudentRecord();
							scanner = new Scanner(line);
							scanner.useDelimiter(",");
							while (scanner.hasNext()) {
								String data = scanner.next();
								if (index == 0)
									stu.setName(data);
								else if (index == 1)
									stu.setSub1(Integer.parseInt(data));
								else if (index == 2)
									stu.setSub2(Integer.parseInt(data));
								else if (index == 3)
									stu.setSub3(Integer.parseInt(data));
								else if (index ==4) {
									stu.setSub4(Integer.parseInt(data));
									stu.computeSum();
								}
								else
									stu.setDate(new Date(data));
								index++;
							}
							index = 0;
							stuList.add(stu);	
						}
						reader.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return stuList;
		}
	
	public ArrayList<StudentRecord> getDataFromCSV2(ArrayList<StudentRecord> stuList) throws NumberFormatException, IOException {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(readLocation));
			String line = null;
			Scanner scanner = null;
			int index = 0;
			stuList = new ArrayList<StudentRecord>();

					while ((line = reader.readLine()) != null) {
						StudentRecord stu = new StudentRecord();
						scanner = new Scanner(line);
						scanner.useDelimiter(",");
						while (scanner.hasNext()) {
							String data = scanner.next();
							if (index == 0)
								stu.setName(data);
							else if (index == 1)
								stu.setSub1(Integer.parseInt(data));
							else if (index == 2)
								stu.setSub2(Integer.parseInt(data));
							else if (index == 3)
								stu.setSub3(Integer.parseInt(data));
							else if (index ==4) {
								stu.setSub4(Integer.parseInt(data));
								stu.computeSum();
							}
							else
								stu.setDate(new Date(data));
							index++;
						}
						index = 0;
						stuList.add(stu);	
					}
					reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stuList;
	}

	private ArrayList<StudentRecord> computePercentile(ArrayList<StudentRecord> stuList) {
		int reference = stuList.get(0).getSum();
		for(StudentRecord student : stuList) {
			float percentile = ((float)student.getSum()/(float)reference)*100;
			System.out.println(student.getSum()+" "+reference+" "+percentile);
			student.setPercentile(percentile);
		}
		return stuList;
	}

	public void writeDataIntoCSV(ArrayList<StudentRecord> stuList, String location) {
		try {
			PrintWriter pw = new PrintWriter(new File(location));
			StringBuilder sb = new StringBuilder();
			Iterator<StudentRecord> iterator = stuList.iterator();
			while(iterator.hasNext()) {
				StudentRecord student = iterator.next();
				//System.out.println(student);
				sb.append(student.getName()+",");
				sb.append(student.getSub1()+",");
				sb.append(student.getSub2()+",");
				sb.append(student.getSub3()+",");
				sb.append(student.getSub4()+",");
				sb.append(student.getPercentile()+",");
				sb.append(student.getDate().toString()+"\n");
			}
			pw.write(sb.toString());
			pw.close();
			System.out.println("Write Complete!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void writeDataIntoCSV2(ArrayList<StudentRecord> stuList) {
		try {
			PrintWriter pw = new PrintWriter(new File(Demo.writeLocation));
			StringBuilder sb = new StringBuilder();
			Iterator<StudentRecord> iterator = stuList.iterator();
			while(iterator.hasNext()) {
				StudentRecord student = iterator.next();
				//System.out.println(student);
				sb.append(student.getName()+",");
				sb.append(student.getSub1()+",");
				sb.append(student.getSub2()+",");
				sb.append(student.getSub3()+",");
				sb.append(student.getSub4()+",");
				sb.append(student.getPercentile()+",");
				sb.append(student.getDate().toString()+"\n");
			}
			pw.write(sb.toString());
			pw.close();
			System.out.println("Write Complete!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public  ArrayList<StudentRecord> sortTheList(ArrayList<StudentRecord> stuList) {
		TreeSet<StudentRecord> Students = new TreeSet<StudentRecord>((p1,p2) -> 
		(p1.sum<p2.sum ? 1 : (p1.sum==p2.sum ? (p1.date.compareTo(p2.date)) : -1))
	);
		Iterator<StudentRecord> iterator = stuList.iterator();
		while(iterator.hasNext()) {
			Students.add(iterator.next());
		}
		ArrayList<StudentRecord> arr = new ArrayList<StudentRecord>();
		iterator = Students.iterator();
		while(iterator.hasNext()) {
			arr.add(iterator.next());
		}
		arr = computePercentile(arr);
		return arr;	
	}
	
	
	
	//Please uncomment corresponding getDataFromCSV method
	/*public ArrayList<StudentRecord> getDataFromCSV(ArrayList<StudentRecord> stuList, String location) throws FileNotFoundException {
		
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(location));
		}catch(FileNotFoundException ex) {
			System.out.println("File not found");
		}
		return stuList;	
	}*/
	
}
