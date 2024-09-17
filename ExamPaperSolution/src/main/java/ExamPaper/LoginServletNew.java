package ExamPaper;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class LoginServletNew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(username.equals("admin") && password.equals("password123")) {
			RequestDispatcher rd = request.getRequestDispatcher("WelcomeServlet");
			rd.forward(request, response);
		}else {
			out.println("Invalid credentials. TRY AGAIN.");
		}
	}

}
