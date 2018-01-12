

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Emp;
import dao.Emp;

public class SaveDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SaveDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String country,name,age;
		try{
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			country=request.getParameter("country");
			name=request.getParameter("name");
			age=request.getParameter("age");
			
			Emp e = new Emp();
			e.setCountry(country);
			e.setName(name);
			e.setAge(age);
			
			int status=dao.EmpDao.register(e);
			if(status>0){
				out.print("Data successfully inserted");
			}
			else{
				out.print("Failed to insert the data :( ");
			}
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}

	
	}
 
