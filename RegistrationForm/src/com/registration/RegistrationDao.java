package com.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistrationDao {
@SuppressWarnings("rawtypes")
public static List l=null;
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List dupliacteUser() throws SQLException{
		l=new ArrayList();
		Connection con=ConnectionProvider.getCon();
		PreparedStatement ps=con.prepareStatement("SELECT Name from  REGISTRATION");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			l.add(rs.getString(1));
		}
		System.out.println(l);
		return l;
	}
	@SuppressWarnings("rawtypes")
	public static int register(User u) throws SQLException{
		List l=RegistrationDao.dupliacteUser();
		if(l.contains(u.name)){
			return 0;
		}
		else{
			 int status=0;
				try{
				Connection con=ConnectionProvider.getCon();
				PreparedStatement ps=con.prepareStatement("INSERT INTO registration(Name,Email,Password,image)values(?,?,?,?)");
				ps.setString(1, u.name);
				ps.setString(2, u.email);
				ps.setString(3, u.pass);
				ps.setString(4, u.img);
		 status=ps.executeUpdate();
				}
				catch(Exception e){
					System.out.println(e);
				}
				
				return status;
		}
	
	}
	public static User find(int id) throws SQLException{
	User u1=null;
		
		try{
			Connection con=ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("select * from registration where id=?");
			ps.setInt(1, id);
			ResultSet rst=ps.executeQuery();
			while(rst.next()){
				 u1=new User();
				 u1.setId(rst.getInt(1));
				 u1.setName(rst.getString(2));
				 u1.setEmail(rst.getString(3));
				 u1.setPass(rst.getString(4));
				 u1.setImg(rst.getString(5));
				
				
			}
			
			/*rst.absolute(id);  
			l.add(rst.getInt(1)+" "+rst.getString(2)+" "+rst.getString(3)+" "+rst.getString(4)+""+rst.getString(5));*/  
			}
			catch(Exception e){
				System.out.println(e);
			}
		
		
		
		return u1;
		
	}
	public static List fetchTable() {
	
		List<User> l= new ArrayList<User>(); 
		try{
			Connection con=ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("Select * from record");
	      ResultSet rs=ps.executeQuery();
	      while(rs.next()){
	    	  User u= new User(); 
	    	 u.setId(rs.getString(1));
	    	  u.setImg(rs.getString(2));
	    	  u.setPass(rs.getString(3));
	    	  u.setName(rs.getString(4));
	    	 u.setEmail(rs.getString(5)); 
	    	 l.add(u);
	      }
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		
		
		return l;
	}
	
}
//AES_ENCRYPT(?,UNHEX('F3229A0B371ED2D9441B830D21A390C3'))
