package com.model;

public class Student {
	
	private int sid;
	private String sname,instituteName,email,password;
	
	
	
	public Student(int sid, String sname, String instituteName, String email, String password) {
		super();
		this.sid = sid;
		this.sname = sname;
		this.instituteName = instituteName;
		this.email = email;
		this.password = password;
	}



	public Student() {
		super();
	}



	public int getSid() {
		return sid;
	}



	public void setSid(int sid) {
		this.sid = sid;
	}



	public String getSname() {
		return sname;
	}



	public void setSname(String sname) {
		this.sname = sname;
	}



	public String getInstituteName() {
		return instituteName;
	}



	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	


	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", instituteName=" + instituteName + ", email=" + email
				+ ", password=" + password + "]";
	}



	@Override
	public boolean equals(Object ob)
	{
		try
		{
			Student student=(Student) ob;
			if(this.sid==student.sid)
				return true;
			return false;
		}
		catch(Exception ex)
		{
			return super.equals(ob);
		}
		
	}

}
