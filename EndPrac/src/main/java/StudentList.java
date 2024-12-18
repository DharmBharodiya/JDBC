

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class StudentList extends HttpServlet {
	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		List<Student> studentsList = new ArrayList<>();
		studentsList.add(new Student(102));
		studentsList.add(new Student(103));
		studentsList.add(new Student(104));
		
		getServletContext().setAttribute("students", studentsList);
		
		out.println("<a href='DisplayServlet'>Tap to Display</a>");
		
	}
	
}
