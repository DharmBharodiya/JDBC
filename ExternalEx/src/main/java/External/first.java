package External;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class first {
	
	private static final String url = "jdbc:mysql://localhost:3306/DBName";
	private static final String username = "root";
	private static final String password = "";
	
	public static void main(String args[]) {
		
		String query = "INSERT INTO STUDENT_TBL (id, name, number) VALUES (?,?,?)";
		
		try {
			
			Class.forName("com.mysql.jdbc.cj.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			
			connection.setAutoCommit(false);//it won't commit the changes automatically to the database
			
			Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			PreparedStatement ps = connection.prepareStatement(query);
			
			ps.setInt(1, 12);
			ps.setString(2, "dharm");
			ps.setString(3, "89786876");
			int prs = ps.executeUpdate();
			
			
			
			ResultSet rs = stmt.executeQuery(query);
			
//			ResultSetMetaData rsmd = rs.getMetaData();
//			int columnCount = rsmd.getColumnCount();
//			String columnName = rsmd.getColumnName(2);
//			System.out.println("There are " + columnCount + " number of columns.");
//			System.out.println("2nd column is " + columnName);
			
			while(rs.next()) {
//				System.out.println("Name: " + rs.getString("name"));
//				System.out.println("ID: " + rs.getInt("id"));
//				System.out.println("Mobile: " + rs.getString("mobile"));
				rs.updateString("name", "john");
				rs.updateString("mobile", "789245");
				rs.updateRow();
				
				rs.moveToInsertRow();//creates a temporary buffer row
				rs.updateString("name", "harry");//sets the new row's name column value to harry
				rs.updateString("mobile", "7898234");//sets the new row's mobile column value to 7898234
				rs.insertRow();//inserts the new row with new values to the database
				rs.moveToCurrentRow();//moves to the previous row back
			
			}

			
			connection.commit();//commit the changes to DB if transaction successfull
			connection.rollback();//rollback to previvous state of the DB if transaction is not successfull
			ps.close();
//			stmt.close();
			connection.close();
			
		}catch(Exception e) {
			e.printStackTrace();		}
	}
}
