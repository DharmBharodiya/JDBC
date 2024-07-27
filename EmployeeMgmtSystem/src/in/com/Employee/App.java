package in.com.Employee;

import java.util.ArrayList;
import java.util.List;

public class App {
	
	public static void main(String args[]) {
		
		Employee employee1 = new Employee("Dharm","dharm@labs.com","IT","9106868415");
		Employee employee2 = new Employee("Diya","diya@jain.com","CP","878698345");
		Employee employee3 = new Employee("Anant","anant@ambani.com","RIL","787887234");
		Employee employee4 = new Employee("Elon","elon@tesla.com","X","234876823");
		
		EmployeeDAOImplementation edi = new EmployeeDAOImplementation();
		
//		edi.createEmployee(employee3);
		
//		edi.getEmployee(2);
		
		List<Employee> NewList = edi.getEmployees();

		for(Employee employee : NewList) {
			System.out.println("--------------------");
			System.out.println("Name: " + employee.getName());
			System.out.println("Department: " + employee.getDepartment());
			System.out.println("Email: " + employee.getEmail());
			System.out.println("Mobile: " + employee.getMobile());
		}
		
	}

}
