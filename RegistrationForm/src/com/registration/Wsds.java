package com.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class Wsds {
	


	public static List l=null;
		public static List dupliacteUser() throws SQLException{
			l=new ArrayList();
			Connection con=ConnectionProvider.getCon();
			PreparedStatement ps=con.prepareStatement("SELECT Name from  REGISTRATION1");
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				l.add(rs.getString(1));
			}

			return l;
		
		}
	public static void main(String[] args) throws SQLException {
		List l=Wsds.dupliacteUser();
		System.out.println(l);
	}

}
