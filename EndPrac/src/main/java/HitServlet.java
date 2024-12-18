

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HitServlet
 */
public class HitServlet extends HttpServlet {
	
	int servletHitCount;
	public void init() throws ServletException {
		servletHitCount = 0;
		
		
		ServletContext context = getServletContext();
		if(context.getAttribute("appHitCount") == null) {
			context.setAttribute("appHitCount", 0);
		}
	}
	
	public void service(HttpServletRequest req, HttpServletResponse resp) throws IOException{

		resp.setContentType("text/html");
		
		servletHitCount++;
		
		ServletContext context = getServletContext();
		int appHitCount = (int) context.getAttribute("appHitCount");
		context.setAttribute("appHitCount", ++appHitCount);
		
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("<h1>The hit counts: </h1>");
		out.println("Servlet Hit Counts: " + servletHitCount);
		out.println("Application Hit Counts: " + appHitCount);
		out.println("</body></html>");
		
		
}
