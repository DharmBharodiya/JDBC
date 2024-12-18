

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayServlet
 */
public class DisplayServlet extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		List<Student> studentsList = (List<Student>) getServletContext().getAttribute("students"); 
		
		if(studentsList != null) {
			out.println("<ul>");
			for(Student student : studentsList) {
				out.println("<li>" + "Roll No. " + student.getRollNo() + "</li>");
			}
			out.println("</ul>");
		}else {
			out.println("No students found.");
		}
		
	}
	
}
