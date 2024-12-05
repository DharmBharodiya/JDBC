package External;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;

public class ServletNew extends HttpServlet {

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("Hello world.");
		
		ServletConfig config = getServletConfig();
		
		String name = config.getInitParameter("name");
		String password = config.getInitParameter("parameter");
		
		ServletContext context = getServletContext();
		context.setAttribute("name","john");
		context.getAttribute("gender");
		
		//make a cookie
		Cookie ck1 = new Cookie("username", "dharm");
		//add it to the response
		response.addCookie(ck1);
		
		//delete the cookie
		ck1.setMaxAge(0);
		response.addCookie(ck1);
		
		//retrieving & accessing the cookies
		Cookie ck[] = request.getCookies();
		for(int i = 0; i < ck.length; i++) {
			out.println("<br" + ck[i].getName() + ":" + ck[i].getValue());
		}
		
		
		
	}
	
}
