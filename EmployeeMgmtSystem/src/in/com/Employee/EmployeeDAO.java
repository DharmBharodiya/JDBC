package in.com.Employee;

import java.util.List;

public interface EmployeeDAO {

	public void createEmployee(Employee employee);
	public void getEmployee(long id);
	public void updateEmployee(long id);
	public void removeEmployee(long id);
	public List<Employee> getEmployees();
	
}
