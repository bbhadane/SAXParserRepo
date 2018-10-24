package com.dao;

import java.util.List;

import com.model.Student;

public interface StudentDao {
	
	String TABLEStudent="student";
	String COLSid="sid",COLSname="sname";
	String COLInstituteName="instituteName";
	String COLEmail="email",COLPassword="password";
	
	
	
	Student getStudent(int sid);
	List<Student> getAllStudents();
	
	void addStudent(Student s) throws StudentExistsException;
	void updateStudent(Student s);
	void deleteStudent(Student s);


}
