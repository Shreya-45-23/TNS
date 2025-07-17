package singleinheritance;

public class student {
	
	private int rollNo;
	private String collegeName;
	
	//non para constructor
	public student() {
		super();
	}

	//para constructor 
	public student(String name, String adharNo, String address, long phone,int rollNo, String collegeName) {
		super( name,  adharNo,  address,  phone);
		this.rollNo = rollNo;
		this.collegeName = collegeName;
	}

	//getter and setter
	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", collegeName=" + collegeName + ", getName()=" + getName()
				+ ", getAdharNo()=" + getAdharNo() + ", getAddress()=" + getAddress() + ", getPhone()=" + getPhone()
				+ "]";
	}
	

}
