package TheDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class Test {

	private static final String url = "jdbc:mysql://localhost:3306/examprac";
	private static final String username = "root";
	private static final String password = "";
	public static String query;
	
	public static void main(String args[]) {
		
		try{
			query = "SELECT * FROM exam_db";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(url, username, password);
			
			Statement st = connection.createStatement();
			
//			st.executeUpdate("INSERT INTO exam_db (name, email, mobile) VALUES('dharm','dharm@gmail.com','34523432')");
//			st.executeUpdate("INSERT INTO exam_db (name, email, mobile) VALUES('john','johnKapoor@gmail.com','78997324')");
//			st.executeUpdate("INSERT INTO exam_db (name, email, mobile) VALUES('ananya','ananyaPandey@gmail.com','46543545')");
//			
			System.out.println("Executed Successfully.");
			
					
			ResultSet rs = st.executeQuery(query);
	
			while(rs.next()) {
				System.out.println("Name: " + rs.getString("name"));
				System.out.println("E-mail: " + rs.getString("email"));
				System.out.println("Mobile: " + rs.getString("mobile"));
			}
			
			st.close();
			connection.close();

		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
