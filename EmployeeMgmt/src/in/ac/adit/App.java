package in.ac.adit;

public class App {
	public static void main(String args[]) {
		
		Employee employee1 = new Employee("Dharm", "IT", "dharm@icloud.com", "878454");
		Employee employee2 = new Employee("Kim", "CP", "kim@icloud.com", "868764");
		EmployeeDAOImplementation empDI = new EmployeeDAOImplementation();
		
		String names[] = {"Tanya","Ayushi","Dev"};
		String emails[] = {"tanya@gmail.com","ayushi@cutemail.com","dev@hotmail.com"};
		String department[] = {"IT","CP","MECH"};
		String mobile[] = {"879834","345432","454234"};
		
		Employee employee = null;
		
//		for(int i = 0; i < names.length; i++) {
//			employee = new Employee(names[i],department[i],emails[i],mobile[i]);
//
//			empDI.createEmployee(employee);		}
		
//		empDI.getEmployee(4);
//		
//		empDI.removeEmoloyee(2);
		
//		empDI.updateEmployee(1);
		
		empDI.createEmployee(employee1);
		
		
	}
}
