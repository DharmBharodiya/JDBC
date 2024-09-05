package smallTry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class BigTry {

	private static String url = "jdbc:mysql://localhost:3306/examprac";
	private static String username = "root";
	private static String password = "";
	
	public static void main(String args[]) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//registering the Driver
		
			Connection connection = DriverManager.getConnection(url, username, password);//getting the connection
			Statement st = connection.createStatement();//creating the statement
			ResultSet rs;
//			
//			st.executeUpdate("INSERT INTO prep_tb (firstname, lastname, mobile) VALUES ('Dharm','Bharodiya','6786723')");
//			st.executeUpdate("INSERT INTO prep_tb (firstname, lastname, mobile) VALUES ('Jhonny','Bravo','656723')");
//			st.executeUpdate("INSERT INTO prep_tb (firstname, lastname, mobile) VALUES ('elon','Musk','457723')");
//			st.executeUpdate("INSERT INTO prep_tb (firstname, lastname, mobile) VALUES ('Tony','Stark','6678456')");
			//execute update because we're updating the database with some new information
			
			
//			st.executeUpdate("DELETE FROM prep_tb WHERE firstname='dharm'");
//			st.executeUpdate("UPDATE prep_tb SET firstname='genius' WHERE firstname='dharm'");
			
			//execute() method returns the TRUE if select query is used, hence ResultSet would be there, but in case of updateQueries it'll return false
//			boolean whatDidItDo = st.execute("UPDATE prep_tb SET firstname='boy', lastname='big' WHERE firstname='genius'");
//			
//			if(whatDidItDo) {
//				rs = st.getResultSet();
//			}else {
//				int noOfRowsAffected = st.getUpdateCount();
//				System.out.println("No of affected rows: " + noOfRowsAffected);
//			}
			
			
			rs = st.executeQuery("SELECT * FROM prep_tb");
			
			while(rs.next()) {
				System.out.print(rs.getString("firstname") + " | ");
				System.out.print(rs.getString("lastname") + " | ");
				System.out.print(rs.getString("mobile") + " | ");
				System.out.println();
			}
			
			
			st.close();
			connection.close();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
