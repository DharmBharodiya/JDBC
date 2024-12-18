import java.sql.*;

public class JDBCConnect {
	
	private static final String username = "root";
	private static final String password = "";
	private static final String url = "jdbc:mysql://localhost:3306/DBName";
	
	public static void main(String args[]) {
		
		try {
			
			String query = "INSERT INTO TABLE (id, name, email) VALUES (12,'dharm','dhar@fa.c')";
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection connection = DriverManager.getConnection(url, username, password);
			
			Statement st = connection.createStatement();
			PreparedStatement pstm = connection.prepareStatement("INSERT INTO studenttbl (name, email, mobile) VALUES (?,?,?)");
			
			pstm.setString(1, "Dharm");
			pstm.setString(2,"Dharm@adf.co");
			pstm.setString(3, "8791231");
			
			ResultSet rs = pstm.executeQuery(query);
			
			while(rs.next()) {
				
				System.out.println("Name: " + rs.getString(1));
				System.out.println("Email: " + rs.getString(2));
				System.out.println("Mobile: " + rs.getString(3));
				
				st.addBatch(query);
				
			}

			st.executeBatch();
			st.execute(query);
			
			//executeQuery() this method is used to execute SQL Queries which would return a ResultSet object for the particular select query ran over it
			//executeUpdate() this method is used to execute SQL queries for updates like insert, delete, update etc and returns int with the number of rows affected
			//execute() method can do the task of the both above listed methods, as it will return true for select queries and false for the update queries
			
			
			st.close();
			connection.close();
			
			
			
		}catch(Exception e) {
			
		}
	}
	
}
