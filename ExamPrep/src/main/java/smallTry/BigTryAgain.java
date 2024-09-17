package smallTry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;

public class BigTryAgain {
	private static String url = "jdbc:mysql://localhost:3306/examprac";
	private static String username = "root";
	private static String password = "";
	
	public static void main(String args[]) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//registering the Driver
		
			Connection connection = DriverManager.getConnection(url, username, password);//getting the connection
			Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);//creating the statement
			
			connection.setAutoCommit(false);
			
			ResultSet rs;
			String query = "INSERT INTO prep_tb (firstname, lastname, mobile) VALUES (?,?,?)";
//			PreparedStatement pstm = connection.prepareStatement(query);
			PreparedStatement pstm = connection.prepareStatement("SELECT * FROM prep_tb");
			
			String[] names = {"John", "Jane", "Michael", "Emily"};
			String[] lastNames = {"Doe", "Smith", "Johnson", "Brown"};
			String[] mobileNumbers = {"1234567890", "0987654321", "1122334455", "5566778899"};

//			for(int i = 0; i < names.length; i++) {
//				pstm.setString(1, names[i]);
//				pstm.setString(2, lastNames[i]);
//				pstm.setString(3, mobileNumbers[i]);
//				pstm.addBatch();
//			}
//			
//			pstm.executeBatch();
			
			rs = st.executeQuery("SELECT * FROM prep_tb");
			while(rs.next()) {
				System.out.print(rs.getString("firstname") + " | ");
				System.out.print(rs.getString("lastname") + " | ");
				System.out.print(rs.getString("mobile") + " | ");
				System.out.println();
			}
			
			ResultSetMetaData rsmd = rs.getMetaData();
			
			String columnname = rsmd.getColumnName(1);
			int columncount = rsmd.getColumnCount();	
			String columntypename = rsmd.getColumnTypeName(1);
			String tablename = rsmd.getTableName(1);
			
			System.out.println("Comlumnname: " + columnname + " ColumnCount: " + columncount + " ColumTypeName: " + columntypename + " TableName: " + tablename);
			
			rs.moveToInsertRow();
			rs.moveToCurrentRow();
			rs.updateString("firstname", "Yahoo");
			rs.updateString("lastname", "GOOGLE");
			rs.updateString("mobile","86987324");
			rs.insertRow();
			
			System.out.println("The Updated ResultSet: ");
			while(rs.next()) {
				System.out.print(rs.getString("firstname") + " | ");
				System.out.print(rs.getString("lastname") + " | ");
				System.out.print(rs.getString("mobile") + " | ");
				System.out.println();
			}
			
			
			connection.commit();
			st.close();
			connection.close();
				
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
