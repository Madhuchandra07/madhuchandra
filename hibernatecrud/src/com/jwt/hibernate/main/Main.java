package com.jwt.hibernate.main;
 
import java.util.Iterator;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 
import com.jwt.hibernate.Student;
import com.jwt.hibernate.util.HibernateUtil;
 
public class Main {
    public static void main(String[] args) {
    	System.out.println("This is main method");
        Main main = new Main();
        main.saveEmployee("Madhu", "CEO", 100000, 893965);
        main.saveEmployee("Ravi", "Manager", 50000, 996654);
        main.saveEmployee("Amit", "PM", 45000, 93445);
       /* main.retriveEmployee();
        main.deleteEmployee();
        main.updateEmployee();*/
    }
 
    public void saveEmployee(String name, String city, int sal, int phone) {
    	System.out.println("This is saveemployee method");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
 
        try {
            transaction = session.beginTransaction();
            Student employee = new  Student();
            employee.setName(name);
            employee.setSal(sal);
            employee.setCity(city);
            employee.setPhone(phone);
            session.save(employee);
            transaction.commit();
            System.out.println("Records inserted sucessessfully");
        } catch (HibernateException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
 
    }
 
   /* public void retriveEmployee()
 
    {
 
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            List employee = session.createQuery("from Student").list();
 
            for (Iterator iterator = employee.iterator(); iterator.hasNext();) {
                Student employee1 = (Student) iterator.next();
                System.out.println(employee1.getName() + "  "
                        + employee1.getCity() + "  " + employee1.getSal()
                        + "   " + employee1.getPhone());
            }
            transaction.commit();
 
        } catch (HibernateException e) {
 
            transaction.rollback();
 
            e.printStackTrace();
 
        } finally {
 
            session.close();
 
        }
    }
 
    public void deleteEmployee() {
 
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String queryString = "from Student where phone = :phone";
            Query query = session.createQuery(queryString);
            query.setInteger("phone", 893965);
            Student employee = (Student) query.uniqueResult();
            session.delete(employee);
            System.out.println("Employee records deleted!");
 
        } catch (HibernateException e) {
 
            transaction.rollback();
 
            e.printStackTrace();
 
        } finally {
 
            session.close();
 
        }
    }
 
    public void updateEmployee() {
 
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            String queryString = "from Student where sal = :sal";
            Query query = session.createQuery(queryString);
            query.setInteger("sal", 50000);
            Student employee = (Student) query.uniqueResult();
            employee.setSal(60000);
            session.update(employee);
            System.out.println("Student records updated!");
        } catch (HibernateException e) {
 
            transaction.rollback();
 
            e.printStackTrace();
 
        } finally {
 
            session.close();
 
        }
    }*/
}