package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import dao.Emp;

public class EmpDao {
	static Connection con=null;

	public static int register(Emp e) {
		int status=0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
			PreparedStatement ps=con.prepareStatement("insert into places2 values(?,?,?)");
			ps.setString(1, e.country);
			ps.setString(2, e.name);
			ps.setString(3, e.age);
	status=ps.executeUpdate();
			
			
		}
		catch(Exception a){
			
		}
		
		
		return status;
	}
	
	

}
