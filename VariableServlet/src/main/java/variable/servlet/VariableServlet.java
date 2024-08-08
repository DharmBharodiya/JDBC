package variable.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class VariableServlet extends HttpServlet {
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		ServletConfig conf = getServletConfig();
		String driver = conf.getInitParameter("driver");
		
		out.println("The driver is: " + driver + "<br>");
		
		ServletContext cont = getServletContext();
		String name = cont.getInitParameter("Name");
		
		out.println("Name: " + name+ "<br>");
		
		
	}

}
