package ReqDispatcher;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class DispatcherTest extends HttpServlet{
	
	RequestDispatcher rd = null;
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();	
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		out.println("Username: " + username);
		out.println("Password: " + password);
		
//		if(password.equals("dharm")) {
//			response.sendRedirect("welcomme.html");
//		}else {
//			response.sendRedirect("home.html");
//		}
//		
		
		if(password.equals("dharm")) {
			rd = request.getRequestDispatcher("TestServlet");
			rd.forward(request, response);
		}else {
			response.sendRedirect("error.html");
		}
		
	}
	
}