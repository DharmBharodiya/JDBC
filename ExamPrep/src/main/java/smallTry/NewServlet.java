package smallTry;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;

public class NewServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("Hello world, welcome to the servlet.");
		
		ServletConfig config = getServletConfig();
		

		ServletContext context = getServletContext();
		HttpSession session = request.getSession(false);
		out.println("Welcome, " + session.getAttribute("username"));
		out.println("<br>");
		
		Cookie cookies[] = request.getCookies();
		String username = (String)cookies[0].getValue();
		
		out.println("Welcome To Your Profile: " + username);
		out.println();
		
		String name2 = context.getInitParameter("GanpatiBappa");
		
		String name = config.getInitParameter("ServletLeader");
		out.println("BOSS: " + name);
		out.println("<br>");
		out.println("Ganpati Bappa, " + name2);
		
		if(session != null) {
			session.invalidate();
		}
	}
		
	
}