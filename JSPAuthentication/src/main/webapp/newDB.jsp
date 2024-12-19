<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.*, javax.servlet.http.*, java.sql.*" %>

<%
String url = "jdbc:mysql://localhost:3306/jspauthenticate_db";
String username = "root";
String password = "";

try {
    // Log the database connection details
    System.out.println("Attempting to connect to MySQL database at: " + url);

    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection connection = DriverManager.getConnection(url, username, password);
    
    // Log successful database connection
    System.out.println("Successfully connected to MySQL database");

    String name = request.getParameter("username");
    String email = request.getParameter("email");
    String pass = request.getParameter("password");

    if (name == null || name.isEmpty() ||
        email == null || email.isEmpty() ||
        pass == null || pass.isEmpty()) {
        out.println("<p>Error: All fields are required!</p>");
        return;
    }

    PreparedStatement st = connection.prepareStatement("INSERT INTO user_tbl (username, email, password) VALUES (?, ?, ?)");
    st.setString(1, name);
    st.setString(2, email);
    st.setString(3, pass);

    int rowsAffected = st.executeUpdate();
    
    if (rowsAffected > 0) {
        out.println("<p>Data inserted successfully!</p>");
    } else {
        out.println("<p>Error: No rows affected during insertion.</p>");
    }

} catch (SQLException e) {
    out.println("<p>Error: Unable to connect to database. Details: " + e.getMessage() + "</p>");
    e.printStackTrace();
} catch (Exception e) {
    out.println("<p>Error: Unexpected exception occurred. Details: " + e.getMessage() + "</p>");
    e.printStackTrace();
}
%>