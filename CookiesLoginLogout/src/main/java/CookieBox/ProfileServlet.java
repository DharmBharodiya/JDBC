package CookieBox;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.http.Cookie;

public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
    	
    	response.setContentType("text/html");
    	PrintWriter out = response.getWriter();
    	out.println("Profile Page");
    	
    	
    	request.getRequestDispatcher("link.html").include(request, response);
    	
    	
    	Cookie ck[] = request.getCookies();
    	if(ck!=null) {
    		String name = ck[0].getValue();
    		
    		if(!name.equals("")||name!=null) {
    			out.println("Welcome to your profile.<br>");
    			out.println("Welcome, " + name);
    		}
    	}else {
    		out.println("Please login first.");
    		request.getRequestDispatcher("login.html").include(request, response);
    	}
    	
    	out.close();
    }

}
