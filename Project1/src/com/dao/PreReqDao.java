package com.dao;

import java.util.HashMap;
import java.util.List;

import com.model.Course;

public interface PreReqDao {
	String TABLEpreReq="preReq",COLcid="cid",COLpreReqCid="preReqCid",COLminMarksRequired="minMarksRequired";
	
	HashMap<Integer,Integer> getPreReqCourses(int cid);

}
