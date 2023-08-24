package Com.entity;

public class Student {

	private int id;
	private String fullName;
	private String dob;
	private String address;
	private String email;
	

	public Student() {
		super();
		
	}

	public Student(String fullName,String dob ,String address, String email) {
		super();
		this.fullName = fullName;
		this.dob =  dob;
		this.address = address;
		this.email = email;

	}

	
	
	public Student(int id, String fullName, String dob, String address, String email) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.dob = dob;
		this.address = address;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ",dob=" + dob + " ,fullName=" + fullName + ", address=" + address + ", email="
				+ email + "]";
	}

}
