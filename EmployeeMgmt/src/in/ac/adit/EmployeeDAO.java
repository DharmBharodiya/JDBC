package in.ac.adit;

import java.util.List;

//Employee data access object

public interface EmployeeDAO {

	public void createEmployee(Employee employee);
	public void getEmployee(int id);
	public void updateEmployee(int id);
	public void removeEmoloyee(int id);
	public List<Employee> getEmployees();
	
}
