import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class main {
	
	private static final String url = "jdbc:mysql://localhost:3306/demo_db";
	private static final String username = "root";
	private static final String password = "";

	public static void main(String args[]) {
			
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(url, username, password);
			
			Statement st = connection.createStatement();
			
//			st.execute("INSERT INTO student_tbl (name, department, mobile) VALUES('Dhaval','CP','991991991')");
//			st.execute("INSERT INTO student_tbl (name, department, mobile) VALUES('Kirtan','IT','635234869')");
//			st.execute("INSERT INTO student_tbl (name, department, mobile) VALUES('Dhruv','IT','6578692876')");
			
//			st.execute("DELETE FROM student_tbl WHERE name = 'kirtan'");
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
