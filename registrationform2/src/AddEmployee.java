import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.Iterator;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
 
/**
 * @author Vishal.Gilbile
 */
@SuppressWarnings("serial")
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class AddEmployee extends HttpServlet {
 
    String name, add;
    float salary;
    FileItem flItem = null;
 
    
    @SuppressWarnings("rawtypes")
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Connection con = null;
        CallableStatement stat = null;
        try {
            long maxFileSize = (2 * 1024 * 1024);
            int maxMemSize = (2 * 1024 * 1024);
//         final String path = "/tmp";
            boolean isMultiPart = ServletFileUpload.isMultipartContent(request);
            if (isMultiPart) {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                List items = upload.parseRequest(request);
                Iterator<FileItem> iter = items.iterator();
                while (iter.hasNext()) {
                    FileItem fileItem = iter.next();
                    if (fileItem.isFormField()) {
                        processFormField(fileItem);
                    } else {
                        flItem = fileItem;
                    }
                }
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection(  
                		"jdbc:mysql://localhost:3306/raj","root","root");  
                PreparedStatement ps=con.prepareStatement(  
                        "insert into add(name,add,salary,photo) values (?,?,?,?)");  
                
               /* stat = con.prepareCall("{call prc_AddEmployee(?,?,?,?)}");*/
                ps.setString(1, name);
               ps.setString(2, add);
                ps.setFloat(3, salary);
                ps.setBinaryStream(4, flItem.getInputStream(), (int) flItem.getSize());
                // stat.setBinaryStream(4, (InputStream) itemPhoto.getInputStream(), (int) itemPhoto.getSize());
                int rows = ps.executeUpdate();
                if (rows > 0) {
                    response.sendRedirect("index.jsp");
                } else {
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Error Adding Employee</title>");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h2>Error Adding Employee Data</h2>");
                    out.println("</body>");
                    out.println("</html>");
                }
            }
        } catch (Exception ex) {
            out.println(ex.getMessage());
        } finally {
            try {
                con.close();
                stat.close();
                out.close();
            } catch (Exception ex) {
                out.println(ex.getMessage());
            }
        }
    } 
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    } 
    private void processFormField(FileItem item) {
        //String na = item.getFieldName();
        if (item.getFieldName().equals("txtName")) {
            name = item.getString();
        } else if (item.getFieldName().equals("txtAddress")) {
            add = item.getString();
        } else if (item.getFieldName().equals("txtSalary")) {
            String sal = item.getString();
            salary = Float.parseFloat(sal);
        }
    }
 
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    } 
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
} 
