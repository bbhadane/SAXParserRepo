package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.Main.DBConnection;
import com.model.Course;
import com.model.Student;
import com.model.preReq;

public class PreReqDaoImpl implements PreReqDao {

	@Override
	public HashMap<Integer,Integer> getPreReqCourses(int cid) {
		List<Course> preReqCourseList=new ArrayList<Course>();
		HashMap<Integer,Integer> reqCoursesAndReqMks=new HashMap<Integer,Integer>();
		// TODO Auto-generated method stub
		try{
			Connection connection=DBConnection.getConnection();
			String sqlquery=" select * from preReq where cid=?";
			
			
			PreparedStatement pst=connection.prepareStatement(sqlquery);
			pst.setInt(1,cid);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();
			while(rs.next())
			{
				int reqCourses=rs.getInt("preReqCid");
				int reqMarks=rs.getInt("minMarksRequired");
				reqCoursesAndReqMks.put(reqCourses, reqMarks);
				}
			return reqCoursesAndReqMks;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
		return reqCoursesAndReqMks;
		
	}

}
