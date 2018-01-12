package beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Emptableyoyo")
public class Employee {
@Id	
private int employeeId;
private String employeeName;
private double employeeSalary;
private int employeeAge;



public int getEmployeeAge() {
	return employeeAge;
}


public void setEmployeeAge(int employeeAge) {
	this.employeeAge = employeeAge;
}
public int getEmployeeId() {
	return employeeId;
}
public void setEmployeeId(int employeeId) {
	this.employeeId = employeeId;
}


@Override
public String toString() {
	return "Employee [employeeId=" + employeeId + ", employeeName="
			+ employeeName + ", employeeSalary=" + employeeSalary
			+ ", employeeAge=" + employeeAge + "]";
}


public String getEmployeeName() {
	return employeeName;
}
public void setEmployeeName(String employeeName) {
	this.employeeName = employeeName;
}
public double getEmployeeSalary() {
	return employeeSalary;
}
public void setEmployeeSalary(double employeeSalary) {
	this.employeeSalary = employeeSalary;
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}

}
