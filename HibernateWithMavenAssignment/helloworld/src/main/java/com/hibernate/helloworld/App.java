package com.hibernate.helloworld;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import com.hibernate.pojo.Company;
import com.hibernate.pojo.Employee;

/**
 * Hello world!
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        
        Session session = factory.openSession();
        session.beginTransaction();
        
        /***********
         * Please run Init only once
         ***********/
        
        /*
        Employee emp = new Employee();
        emp.setemployeeAge(15);
        emp.setemployeeName("aman");
        emp.setCompanyID(1);
        session.save(emp);
        
        
        Employee emp2 = new Employee();
        emp2.setemployeeAge(32);
        emp2.setemployeeName("singh");
        emp2.setCompanyID(1);
        session.save(emp2);
        
        Employee emp3= new Employee();

        emp3.setemployeeAge(33);
        emp3.setemployeeName("thakur");
        emp3.setCompanyID(2);
        session.save(emp3);
        
        Employee emp4= new Employee();
        emp4.setemployeeAge(78);
        emp4.setemployeeName("lala");
        emp4.setCompanyID(3);
        session.save(emp4);
        
        Company cmp = new Company();
        cmp.setCompanyName("Accolite");
        cmp.setCompanyID(1);
        session.save(cmp);
        
        Company cmp2 = new Company();
        cmp2.setCompanyID(2);
        cmp2.setCompanyName("Micrsoft");
        session.save(cmp2);
        
        Company cmp3 = new Company();
        cmp3.setCompanyID(3);
        cmp3.setCompanyName("Cisco");
        session.save(cmp3);
        
        session.getTransaction().commit();
        */
        
        ArrayList<Company> cmpList= new ArrayList<Company>();
        Criteria cr = session.createCriteria(Company.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);	
        cmpList= (ArrayList<Company>) cr.list();
		System.out.println(cmpList); //shows 1
		System.out.println("***********SHOWING UNIQUE ENTRIES******************");
		for(Company c : cmpList) {
	  		  System.out.println( 
	  				  c.getCompanyName()+"|"+
	  				  c.getCompanyID()+"|"+
	  				  (c.getEmployees()!=null?c.getEmployees().get(0):"No Employee Found"));
	  				  }
		System.out.println("***********SHOWING ALL EMPLOYEES WITH AGE ABOVE 20******************");
		   ArrayList<Employee> cmpList2= new ArrayList<Employee>();
	        Criteria cr2 = session.createCriteria(Employee.class);	
	        cr2.add(Restrictions.gt("employeeAge", 20));
	        cmpList2 = (ArrayList<Employee>) cr2.list();
			System.out.println(cmpList2); //sho	ws 1
    }
}
