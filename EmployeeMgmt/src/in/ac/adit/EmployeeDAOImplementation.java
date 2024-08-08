package in.ac.adit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class EmployeeDAOImplementation implements EmployeeDAO {
	
	private static final String url = "jdbc:mysql://localhost:3306/employee_db";
	private static final String username = "root";
	private static final String password = "";
	private String theQuery;
	private PreparedStatement pstm;
	private Connection connection;
	Scanner sc = new Scanner(System.in);
	
	
	public EmployeeDAOImplementation() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			connection = DriverManager.getConnection(url, username, password);
			
			
			
		}catch(Exception e){ 
			e.printStackTrace();
		}
	}

	@Override
	public void createEmployee(Employee employee) {
		theQuery = "INSERT INTO employee_tbl (name, department, email, mobile) VALUES (?,?,?,?)";
		
		try {
			pstm = connection.prepareStatement(theQuery);
			pstm.setString(1, employee.getName());
			pstm.setString(2, employee.getDepartment());
			pstm.setString(3, employee.getEmail());
			pstm.setString(4, employee.getMobile());
			
			pstm.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void getEmployee(int id) {
		theQuery = "SELECT * FROM employee_tbl WHERE id = " + id;
		
		try {
			
			pstm = connection.prepareStatement(theQuery);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()){
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void updateEmployee(int id) {
		// TODO Auto-generated method stub
		
		System.out.println("Enter new name: ");
		String newName = sc.nextLine();
		
		System.out.println("Enter new department: ");
		String newDepartment = sc.nextLine();
		
		System.out.println("Enter new email: ");
		String newEmail = sc.nextLine();
		
		System.out.println("Enter new mobile: ");
		String newMobile = sc.nextLine();
		
		theQuery = "UPDATE employee_tbl SET name = ?, department = ?, email = ?, mobile = ? WHERE id = " + id;		
		try {
			
			pstm = connection.prepareStatement(theQuery);
			
			pstm.setString(1, newName);
			pstm.setString(2, newDepartment);
			pstm.setString(3, newEmail);
			pstm.setString(4, newMobile);
			
			pstm.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void removeEmoloyee(int id) {
		theQuery = "DELETE FROM employee_tbl WHERE id = " + id;
		
		try {
			
			pstm = connection.prepareStatement(theQuery);
			pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Employee> getEmployees() {
		
		return null;
	}

		
		
	
}
