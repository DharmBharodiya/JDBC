<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.*,javax.servlet.http.*" %>
<%

	String username = request.getParameter("username");
	String password = request.getParameter("password");
	
	
	RequestDispatcher rd;
	
	if(username.equals(password)){
		rd = request.getRequestDispatcher("welcome.jsp");
		rd.forward(request, response);
	}else{
		out.println("Invalid Credentials.");
		rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

%>