import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

public class FirstApp extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		
		String name = request.getParameter("firstname");
		String mobileno = request.getParameter("mobile");
		
		out.println("<h1>Welcome, " + name + "</h1>");
		out.println("<p>Mobile no.: " + mobileno + "</p>");
		
		
	} 
	
	
}