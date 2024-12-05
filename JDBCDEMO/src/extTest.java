import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class extTest {

	public final static String url = "jdbc:mysql://localhost:3306/dbName";
	public final static String username = "root";
	public final static String password = "";
	
	public static void main(String args[]) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(url, username, password);
			
			Statement stmt = connection.createStatement();
			
			ResultSet rs = stmt.executeQuery("SELECT * FROM student_tbl");
			while(rs.next()) {
				//code
			}

			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
