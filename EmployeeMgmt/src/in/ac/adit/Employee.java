package in.ac.adit;


public class Employee {

	private int id;
	private String name;
	private String email;
	private String department;
	private String mobile;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public Employee(String name, String department, String email, String mobile) {
//		super();
		this.name = name;
		this.department = department;
		this.email = email;
		this.mobile = mobile;
	
	
	}
	
	
}

