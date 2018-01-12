package com.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrationDao {
public static List l=null;
	public static List dupliacteUser() throws SQLException{
		l=new ArrayList();
		Connection con=ConnectionProvider.getCon();
		PreparedStatement ps=con.prepareStatement("SELECT Name from  REGISTRATION1");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			l.add(rs.getString(1));
		}
		System.out.println(l);
		return l;
	}
	public static int register(User u) throws SQLException{
	/*	Connection con=null;*/
		List l=RegistrationDao.dupliacteUser();
		if(l.contains(u.name)){
			return 0;
		}
		else{
			 int status=0;
				try{
				Connection  con=ConnectionProvider.getCon();
				PreparedStatement ps=con.prepareStatement("INSERT INTO REGISTRATION1(Name,Email,Password,image,age,city)values(?,?,?,?,?,?)");
				ps.setString(1, u.name);
				ps.setString(2, u.email);
				ps.setString(3, u.pass);
				ps.setString(4, u.img);
				ps.setInt(5, u.age);
				ps.setString(6, u.city);
		 status=ps.executeUpdate();
				}
				catch(Exception e){
					System.out.println(e);
				}
			/*	finally{
					
					con.close();
				}*/
				return status;
		}
	
	}
	
	public static boolean userLogin(User u){
		Map <String,String>userval=new HashMap<String,String>();
		String user=null;
		String pass1=null;
		
		int status=0;
		try{
			Connection con=ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("SELECT Name, Password FROM REGISTRATION1 WHERE Name=?");
			ps.setString(1, u.name);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			 user=rs.getString(1);
			 pass1=rs.getString(2);
			}
		}
		
		catch(Exception e){
			System.out.println(e);
		}
		if(u.pass.equals(pass1)){
			return true;
		}
		else {
			return false;
		}
	}
}
