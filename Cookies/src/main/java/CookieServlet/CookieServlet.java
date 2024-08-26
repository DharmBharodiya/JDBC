package CookieServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class CookieServlet extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		out.println("Hello, " + username);
		
		Cookie ck = new Cookie("AUTHUSER", username);
		response.addCookie(ck);
		
		out.println("<form action='servlet2' method='get'>");
		out.println("<label>Move to second servlet: </label>");
		out.println("<input type='submit' value='go'>");
		out.println("</form>");
		
		out.close();
		
	}
	
}