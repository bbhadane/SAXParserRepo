package com.dao;

import java.util.List;

import com.model.Course;

public interface CourseDao {

	String TABLECourse="course",COLcid="cid",COLcname="cname";
	String COLduration="cduration";
	String COLfees="courseFees";
	
	 Course getCourse(int cid);
	   List<Course> getAllCourses();
	 
	
	void addCourse(Course c) throws CourseExistsException;
	void updateCourse(Course c);
	void deleteCourse(Course c);


}
