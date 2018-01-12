package client;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import beans.Employee;
import beans.Student;

public class Client {
	

	public static void main(String[] args) {
		System.out.println("Hi");
		/*Configuration cfg=new Configuration();
	   cfg.configure("hibernate.cfg.xml");
	   
	   SessionFactory sf=cfg.buildSessionFactory();
	   
	 
	 
	   Session session=sf.openSession();*/
		Session session=new AnnotationConfiguration().configure().buildSessionFactory().openSession();
	   Transaction tx=session.beginTransaction();
	   Employee emp1=new Employee();
	   
	   
	   Scanner sc=new Scanner(System.in);
	   System.out.println("Enter id of the employee");
	   emp1.setEmployeeId(sc.nextInt());
	   System.out.println("enter the name of the employee");
	   emp1.setEmployeeName(sc.next());
	   System.out.println("enter the employee salary ");
	   emp1.setEmployeeSalary(sc.nextDouble());
	   System.out.println("Enter the employee Age");
	   emp1.setEmployeeAge(sc.nextInt());
	   session.save(emp1);
	   
	  tx.commit();
	  Criteria criteria= session.createCriteria(Employee.class);
	  
	  Criterion criterion=Restrictions.gt("employeeAge", 28);
	  criteria.add(criterion);
	  
	  Order order=Order.asc("employeeName");
	  criteria.addOrder(order);
	  
	  
	  /*Projection projection=Projections.property("employeeName");
	  criteria.setProjection(projection);*/
	  List list =criteria.list();
	  Iterator iterator=list.iterator();
	  while(iterator.hasNext()){
		 Employee emp=(Employee)iterator.next();
		 
		  System.out.println("Employee ID:"+emp.getEmployeeId());
		  System.out.println("Employee Name:"+emp.getEmployeeName());
		  System.out.println("Employee Salary:"+emp.getEmployeeSalary());
		  
		 /* String EmployeeName =(String) iterator.next();
		  System.out.println(EmployeeName);*/
	  }
	 System.out.println("Success");

	 
	   session.close();
	   
	}

}
