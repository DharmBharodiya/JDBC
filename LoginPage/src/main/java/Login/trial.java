package Login;
import java.io.FileReader;
import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class trial {
	
	private static final String url = "jdbc:mysql://localhost:3306/servletdemo_db";
	private static final String username = "root";
	private static final String password = "";
	
	public static void main(String args[]) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			
			String query = "INSERT INTO user_tbl (name, department, email, mobile, password) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pstm = connection.prepareStatement(query);
	            
	        pstm.setString(1, "Dharm");
	        pstm.setString(2, "IT");
	        pstm.setString(3, "dharm@gmail.com");
	        pstm.setString(4, "343234");
	        pstm.setString(5, "adfajT");
	        
	        pstm.executeUpdate();
				
			
					
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
