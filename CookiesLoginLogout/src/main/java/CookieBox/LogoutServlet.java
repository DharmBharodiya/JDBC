package CookieBox;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;
/**
 * Servlet implementation class LogoutServlet
 */
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    	
    	response.setContentType("text/html");
    	
    	PrintWriter out = response.getWriter();
    	
    	request.getRequestDispatcher("link.html").include(request, response);
    	
    	Cookie ck = new Cookie("name",""); // here we removed the cookie basically, and as the cookie will be removed the user will logout on its own
    	ck.setMaxAge(0);//cookie won't live it for a moment also
    	response.addCookie(ck);
    	
    	out.print("Logged Out SuccessFully.");
    }
}
