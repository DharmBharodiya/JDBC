import java.sql.*;
import java.io.*;

public class mainWrite {

		private static final String url = "jdbc:mysql://localhost:3306/csv_db";
		private static final String username = "root";
		private static final String password = "";
		
		public static void main(String args[]) {

			String query = "SELECT * FROM employee_tbl";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection connection = DriverManager.getConnection(url, username, password);
				Statement ps = connection.createStatement();
				ResultSet rs = ps.executeQuery(query);
				
				
				FileWriter fr = new FileWriter("C:/Users/dharm/eclipse-workspace/CSV_JAVA/files/writedata.csv", true);
				
				fr.append("id,name,email,mobile\n");
				while(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					String email = rs.getString("email");
					String mobile = rs.getString("mobile");
					
					fr.append(id + "," + name + "," + email + "," + mobile + "\n");
				}
				
				rs.close();
				ps.close();
				connection.close();
				fr.flush();
				fr.close();				
			
				System.out.println("File written succesfully.");
			
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	
}
