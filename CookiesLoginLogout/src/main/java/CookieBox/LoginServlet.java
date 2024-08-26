package CookieBox;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getRequestDispatcher("link.html").include(request, response);
		
		String name = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(password.equals("dharm123")) {
			out.println("Logged in successfully.");
			out.println("<br> Welcome, " + name);
			
			Cookie ck = new Cookie("AUTHUSER", name);
			response.addCookie(ck);
		}else {
			out.println("Invalid username/password.");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		
		out.close();
		
		
	}

}
