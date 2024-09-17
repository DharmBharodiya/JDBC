package ExamPaper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ProductAdd {

	
	public static String url = "jdbc:mysql://localhost:3306/exampaper_db";
	public static String username = "root";
	public static String password = "";
	
	public static void main(String args[]) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement st = connection.createStatement();
			
			String query = "INSERT INTO product_tb (pid, name, category, quantity, price) VALUES (1023, 'Book','Education',100,20) ";
			
			st.executeUpdate(query);
			
			st.close();
			connection.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
