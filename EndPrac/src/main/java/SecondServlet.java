

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
	}
	
}
