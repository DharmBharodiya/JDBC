import javax.servlet.*;
import javax.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

class ServletNew extends HttpServlet{
	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		RequestDispatcher rd = req.getRequestDispatcher("index.html");
		
		String name = req.getParameter("name");
		String password = req.getParameter("password");
		
		if(name == password) {
			out.println("You're Welcome/");
		}else {
			out.println("Invalid. Try again.");
			rd.forward(req, resp);
		}
	
	
	}
	
}