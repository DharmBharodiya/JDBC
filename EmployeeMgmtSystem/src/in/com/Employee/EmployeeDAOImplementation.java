package in.com.Employee;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeDAOImplementation implements EmployeeDAO{

	//actual implementation of all the methods of the EmployeeDAO class will be done over here
		
	private final static String url = "jdbc:mysql://localhost:3306/employeemgmt_db";
	private final static String username = "root";
	private final static String password = "";
	private PreparedStatement pstm;
	private Connection connection;
	private String query;
	Scanner sc = new Scanner(System.in);
	
	
	//whenever the object of this particular class will be made, it will be instantiated with the help of this constrcutor and hence new connection will be formed
	public EmployeeDAOImplementation() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, username, password);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void createEmployee(Employee employee) {
		
		query = "INSERT INTO employeemgmt_tbl (name, email, department, mobile) VALUES (?,?,?,?)";
		
		try {
			
			pstm = connection.prepareStatement(query);
			
			//here getter methods will be used to get the specific values of the particular employee
			pstm.setString(1,employee.getName());//will help to get the name of the employee 
			pstm.setString(2,employee.getEmail());
			pstm.setString(3,employee.getDepartment());
			pstm.setString(4,employee.getMobile());
			
			//once the query is set with all the values for the new employee, it needs to be executed
			pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void getEmployee(long id) {
		
		query = "SELECT * FROM employeemgmt_tbl WHERE id = " + id;
		
		try {
			pstm = connection.prepareStatement(query);
			ResultSet rs = pstm.executeQuery();
			
			//as the result is stored inside the ResultSet, we will iterate over it to get each value of it one by one
			while(rs.next()) {
				System.out.println("ID: " + rs.getInt(1));
				System.out.println("Name: " + rs.getString(2));
				System.out.println("Email: " + rs.getString(3));
				System.out.println("Department: " + rs.getString(4));
				System.out.println("Mobile: " + rs.getString(5));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void updateEmployee(long id) {
		
		System.out.println("Enter new name: ");
		String name = sc.nextLine();
		
		System.out.println("Enter new department: ");
		String department = sc.nextLine();
		
		System.out.println("Enter new email: ");
		String email = sc.nextLine();
		
		System.out.println("Enter new mobile: ");
		String mobile = sc.nextLine();
		
		query = "UPDATE employeemgmt_tbl SET name=?, email=?, department=?, mobile=? WHERE id = " + id;
		
		try {
			
			pstm = connection.prepareStatement(query);
			pstm.setString(1, name);
			pstm.setString(2, email);
			pstm.setString(3, department);
			pstm.setString(4, mobile);
			
			pstm.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void removeEmployee(long id) {
		
		query = "DELETE FROM employeemgmt_tbl WHERE id = " + id;
		
		try {
			
			pstm = connection.prepareStatement(query);
			
			pstm.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Employee> getEmployees(){
		
		List<Employee> employees = new ArrayList();
		
		query = "SELECT * FROM employeemgmt_tbl";
		try {
			
			pstm = connection.prepareStatement(query);
			
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				long id = rs.getLong("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String department = rs.getString("department");
				String mobile = rs.getString("mobile");
				
				Employee employee = new Employee(name, email, department, mobile);
				
				employees.add(employee);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return employees;
	}
	
	
}
