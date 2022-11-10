package com.masai.Model;

public class Faculty {
	private int Facultyid;
	private String Facultyname ;
	private String Facultyaddress;
	private String Mobile;
	private String email;
	private String Username;
	private String Password;
	
	public Faculty() {
		
	}


	public Faculty(int facultyid, String facultyname, String facultyaddress, String mobile, String email,
			String username, String password) {
		
		this.Facultyid = facultyid;
		Facultyname = facultyname;
		Facultyaddress = facultyaddress;
		Mobile = mobile;
		this.email = email;
		Username = username;
		Password = password;
	}


	public int getFacultyid() {
		return Facultyid;
	}

	public void setFacultyid(int facultyid) {
		Facultyid = facultyid;
	}

	public String getFacultyname() {
		return Facultyname;
	}

	public void setFacultyname(String facultyname) {
		Facultyname = facultyname;
	}

	public String getFacultyaddress() {
		return Facultyaddress;
	}

	public void setFacultyaddress(String id) {
		Facultyaddress = id;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	@Override
	public String toString() {
		return "Faculty [Facultyid=" + Facultyid + ", Facultyname=" + Facultyname + ", Facultyaddress=" + Facultyaddress
				+ ", Mobile=" + Mobile + ", email=" + email + ", Username=" + Username + ", Password=" + Password + "]";
	}
	

}
