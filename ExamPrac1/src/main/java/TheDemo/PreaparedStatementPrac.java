package TheDemo;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;


//Prepare Statememt is an interface
//here we can pass parameters into the queries using the setter methods of the PreparedStatement
// compilation will be faster because it is only compiled once, and only the values are changed when and however needed, so it makes everything a bit faster


// prepareStatement() method of the interface is used to get the instance of the same
// methods of the interface are as followed:
// 											- setInt()
//											- setString()
//											- setDouble()
//											- setFloat()
//											- executeUpdate() => to create, drop, insert, update, delete
//											- ResultSet executeQuery() => returns the instance of the ResultSet
											
											
public class PreaparedStatementPrac {
		
	private static String url = "jdbc:mysql://localhost:3306/examprac";
	private static String username = "root";
	private static String password = "";
	public static String query;
	
	public static void main(String args[]) {
		
		query = "INSERT INTO exam_db (name, email, mobile) VALUES(?,?,?)";
		
		String names[] = {"Elon","Shreya","Diya"};
		String emails[] = {"Elon@x.com","shreya@good.com","diya@z.com"};
		String mobiles[] = {"6754565","4564564","2345477"};
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//registration of the Driver
			Connection connection =  DriverManager.getConnection(url, username, password);
			
			PreparedStatement pstm = connection.prepareStatement(query);
		
			
			for(int i = 0; i < names.length; i++) {
					
				pstm.setString(1, names[i]);
				pstm.setString(2, emails[i]);
				pstm.setString(3, emails[i]);
				pstm.addBatch();
			}
			pstm.executeBatch();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
