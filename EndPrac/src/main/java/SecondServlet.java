

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SecondServlet extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{
			
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		ServletConfig config = getServletConfig();
		String email = config.getInitParameter("email");
		out.println("Email with config: " + email);
		
		ServletContext context = getServletContext();
		String newEmail = context.getInitParameter("email");
		out.println("Email with context: " + newEmail);
		
		
		Cookie ck = new Cookie("AUTHUSER", "dharm");
		resp.addCookie(ck);
		
		
		Cookie ckNew[] = req.getCookies();
		for(int i=0; i < ckNew.length; i++) {
			out.println("Cookie: " + ckNew[i].getName() + " : " + ckNew[i].getValue());
		}
	
		Cookie ck2 = new Cookie("AUTHUSER", "");
		ck2.setMaxAge(0);
		resp.addCookie(ck2);
		
		HttpSession session = req.getSession(false);
		session.setAttribute("uname", "dharm");
		
	}
	
}
