import java.io.FileReader;
import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class main {
	
	private static final String url = "jdbc:mysql://localhost:3306/csv_db";
	private static final String username = "root";
	private static final String password = "";
	
	public static void main(String args[]) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, username, password);
			PreparedStatement ps = connection.prepareStatement("INSERT INTO employee_tbl (name, email, mobile) VALUES(?,?,?)");
			
			FileReader fr = new FileReader("C:/ADIT/JAVA Program/CSV FIlE/fakedata.csv");
			BufferedReader br = new BufferedReader(fr);
			
			String line = null;
			while((line = br.readLine()) != null) {
				String data[] = line.split(",");//will seperate the line with comma
				
				ps.setString(1, data[0]);
				ps.setString(2, data[1]);
				ps.setString(3, data[2]);
				
				ps.addBatch();
				
			}
			
			ps.executeBatch();			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}

}
