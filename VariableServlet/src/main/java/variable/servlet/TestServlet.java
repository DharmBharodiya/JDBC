package variable.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet{
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		ServletContext contSer = getServletContext();
		
		String name = contSer.getInitParameter("Name");
		
		out.println("Context Variable: " + name);
		
		ServletConfig confServ = getServletConfig();
		String confName = confServ.getInitParameter("TheName");
		out.println("Config variable: " + confName);
	}
	
}