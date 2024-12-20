import java.io.*;
import java.sql.*;

public class write {

	private static final String url = "jdbc:mysql://localhost:3306/csv_db";
	private static final String username = "root";
	private static final String password = "";
	
	public static void main(String args[]) {
		
		String query = "SELECT * FROM employee_tbl";
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement st = connection.createStatement();
			
			ResultSet rs = st.executeQuery(query);
			
			FileWriter fr = new FileWriter("C:/Users/dharm/eclipse-workspace/CSV_JAVA/files/dataWrite.csv", true);//true - is for the append
			
			fr.append("id,name,email,mobile,\n");
			
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				
				fr.append(id + "," + name  + "," + email  + "," + mobile  + "\n");
				
			}
		
			rs.close();
			st.close();
			connection.close();
			fr.flush();
			fr.close();
			
			System.out.println("The file was written successfully.");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
			
		
	}	
	
}
