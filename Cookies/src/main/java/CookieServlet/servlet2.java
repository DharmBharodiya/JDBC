package CookieServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class servlet2 extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		for(int i = 0; i < cookies.length; i++) {
			
			out.println("Username: " + cookies[0].getValue() + " taken from the cookies of other servlet.");
		}
		
		out.close();
		
	}
	
}