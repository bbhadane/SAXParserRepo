package com.model;

import java.sql.Date;

public class Enrollment {
	Student studentObj;
	Course courseObj;
	Date enrollmentDate;
	int paidFees;
	int eid;
	
	
	
	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	
	
	public Enrollment(Student studentObj, Course courseObj, Date enrollmentDate, int paidFees, int eid) {
		super();
		this.studentObj = studentObj;
		this.courseObj = courseObj;
		this.enrollmentDate = enrollmentDate;
		this.paidFees = paidFees;
		this.eid = eid;
	}

	public Enrollment(Student studentObj, Course courseObj) {
		super();
		this.studentObj = studentObj;
		this.courseObj = courseObj;
	}
	
	public Enrollment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student getStudent() {
		return studentObj;
	}
	public void setStudent(Student studentObj) {
		this.studentObj = studentObj;
	}
	public Course getCourse() {
		return courseObj;
	}
	public void setCourse(Course courseObj) {
		this.courseObj = courseObj;
	}
	
	
	public int getPaidFees() {
		return paidFees;
	}
	public void setPaidFees(int paidFees) {
		this.paidFees = paidFees;
	}
	public Date getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "Enrollment [studentObj=" + studentObj + ", courseObj=" + courseObj + ", enrollmentDate="
				+ enrollmentDate + ", paidFees=" + paidFees + "]";
	}

	public boolean equals(Object ob)
	{
		try
		{
			if(studentObj.getSid()==this.studentObj.getSid())
			{
				if(courseObj.getCid()==this.courseObj.getCid())
				{
					return true;
				}
			}
				
			return false;
		}
		catch(Exception ex)
		{
			return super.equals(ob);
		}
	
}
}