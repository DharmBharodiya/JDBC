package TheDemo;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class DeleteQuery {

	private static String url = "jdbc:mysql://localhost:3306/examprac";
	private static String username = "root";
	private static String password = "";
	
	public static void main(String args[]) {
		String deleteQuery = "DELETE FROM exam_db WHERE name = 'Ayush'";
		String updateQuery = "UPDATE exam_db SET name='Mitchell', email='mitchell@hotmail.com', mobile='4511211' WHERE name='elon'";
		String truncateQuery = "TRUNCATE TABLE exam_db";//only the data of the table will be deleted and the structure will remain as it is
		String dropQuery = "DROP TABLE exam_db";//deletes the database object, i.e., the whole table along with structure and all data will be deleted
		// the table will no longer exist after dropping it 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
//			PreparedStatement pstm = connection.prepareStatement(deleteQuery);
				
//			PreparedStatement pstm = connection.prepareStatement(updateQuery);
//			PreparedStatement pstm = connection.prepareStatement(truncateQuery);
			
//			PreparedStatement pstm = connection.prepareStatement(dropQuery);
			
//			pstm.execute();
			
			System.out.println("Success.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
		
	
}
