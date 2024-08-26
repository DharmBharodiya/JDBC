package TheDemo;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
/**
 * Servlet implementation class ServletDemo1
 */
public class ServletDemo1 extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
			
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals(password)) {
			out.println("Logged In Successfully.");
		}else {
			out.println("Invalid username/password. Retry again by pressing F5.");
		}
		
		out.println("Hello World.");
		
	}
	
}