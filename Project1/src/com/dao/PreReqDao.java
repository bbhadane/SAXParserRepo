package com.dao;

import java.util.List;

import com.model.Course;

public interface PreReqDao {
	String TABLEpreReq="preReq",COLcid="cid",COLpreReqCid="preReqCid";
	
	List<Course> getPreReqCourses(int cid);

}
