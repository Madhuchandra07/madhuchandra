package com.registration;

import java.sql.Connection;
import java.sql.DriverManager;
import com.registration.Provider;
public class ConnectionProvider implements Provider {
	private static Connection con=null;  
	static{  
	try{  
	Class.forName(DRIVER);  
	con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);  
	}catch(Exception e){}  
	}  
	  
	public static Connection getCon(){  
	    return con;  
	}  
/*static Connection con=null;
	static Connection getCon(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Dhilip","root","root");
			
			
		}
		catch(Exception e){
			System.out.println(e);
		}
		return con;
	}*/
}
