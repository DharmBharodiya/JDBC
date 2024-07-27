package in.com.Employee;

public class Employee {
	
	private long id;
	private String name;
	private String email;
	private String department;
	private String mobile;
	
	public Employee(String name, String email, String department, String mobile) {
		this.name = name;
		this.email = email;
		this.department = department;
		this.mobile = mobile;
	}
	
	public long getId() {
		return id;
	}

	// setter method for ID is not required as it is set to Auto Increment in the DB, hence as new entries will be made it will be self asigned
//	public void setId(long id) {
//		this.id = id;
//	}

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

	
	
	

}
