package autofillingfieldsusingajax;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UserDao {
	
	public static int Register(User u){
		int status=0;
		try{
		Connection con=UserDao.getCon();
		PreparedStatement ps=con.prepareStatement("insert into person values(?,?,?,?,?)");
		ps.setString(1, u.getEmail());
		ps.setString(2, u.getFirstname());
		ps.setString(3, u.getLastname());
		ps.setString(4, u.getNo());
		ps.setString(5,u.getCl());
	status=ps.executeUpdate();
		
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		
		
		
		return status;
		
		
		
	}

	private static Connection getCon() {
		Connection con=null;
		try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
		}
		catch(Exception e){
			System.out.println(e);
		}
		return con;
	}

}
