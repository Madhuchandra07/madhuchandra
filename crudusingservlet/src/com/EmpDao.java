package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class EmpDao {
	
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","root");
		
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return con;
		}
	
	public static int Save(Emp e){
	int	status=0;
	try{
		Connection con=EmpDao.getConnection();
		PreparedStatement ps=con.prepareStatement("insert into reg values(?,?,?,?,?)");
		ps.setInt(1, e.getId());
		ps.setString(2, e.getName());
		ps.setString(3, e.getPassword());
		ps.setString(4, e.getEmail());
		ps.setString(5, e.getCountry());
		
	status=	ps.executeUpdate();
	con.close();	
	}
	catch(Exception s){
		System.out.println(s);
	}
		return status;
		
	}

	public static List getAllEmployees() {
	
		List list= new ArrayList();
		
		try{
			Connection con=EmpDao.getConnection();
			PreparedStatement ps= con.prepareStatement("select*from reg");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				Emp e= new Emp();
			  e.setId(rs.getInt(1));
			  e.setName(rs.getString(2));
			  e.setPassword(rs.getString(3));
			  e.setEmail(rs.getString(4));
			  e.setCountry(rs.getString(5));
			  list.add(e);
			}
			con.close();	
		}
		catch(Exception ex){
			System.out.println(ex);
		}
		return list;
	}

	public static int delete(int id) {
		 int status=0;  
	        try{  
	            Connection con=EmpDao.getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from reg where id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }
	        catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
		
	}
	
	
	
	
	
	
	
}

