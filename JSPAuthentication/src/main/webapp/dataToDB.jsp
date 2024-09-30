<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.*,javax.servlet.http.*, java.sql.*" %>
<% 

	String url = "jdbc:mysql://localhost:3306/jspauthenticate_db";
	String username = "root";
	String password = "";
	
	
	try{
		String name = request.getParameter("username");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, password);
		PreparedStatement st = connection.prepareStatement("INSERT INTO user_tbl (username, email, password) VALUES (?,?,?) ");
		
		st.setString(1, name);
		st.setString(2, email);
		st.setString(3, pass);
		
		st.executeUpdate();
		
	}catch(Exception e){
		e.printStackTrace();
	}
	

%>