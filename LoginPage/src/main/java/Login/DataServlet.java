package Login;

import java.io.IOException;
import javax.servlet.http.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataServlet extends HttpServlet {

    private static final String url = "jdbc:mysql://localhost:3306/servletdemo_db";
    private static final String username = "root";
    private static final String thePassword = "";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("firstname");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");

        

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, thePassword);
            
            String query = "INSERT INTO user_tbl (name, department, email, mobile, password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstm = connection.prepareStatement(query);
            
	            
	        pstm.setString(1, name);
	        pstm.setString(2, department);
	        pstm.setString(3, email);
	        pstm.setString(4, mobile);
	        pstm.setString(5, password);
	        
	        pstm.executeUpdate();
            
            int rowInserted = pstm.executeUpdate();
            if (rowInserted > 0) {
                out.println("Inserted Successfully.");
            } else {
                out.println("Insertion failed.");
            }
            
            
            pstm.close();
            connection.close();
            } catch (ClassNotFoundException e) {
            out.println("MySQL JDBC Driver not found.");
            e.printStackTrace(out);
        } catch (SQLException e) {
            out.println("Database error: " + e.getMessage());
            e.printStackTrace(out);
        } 

        out.println("<br>Name: " + name + "<br>Department: " + department + "<br>Email: " + email + "<br>Mobile: " + mobile + "<br>Password: " + password);
    }
}
