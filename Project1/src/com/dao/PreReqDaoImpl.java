package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.Main.DBConnection;
import com.model.Course;
import com.model.Student;

public class PreReqDaoImpl implements PreReqDao {

	@Override
	public List<Course> getPreReqCourses(int cid) {
		List<Course> preReqCourseList=new ArrayList<Course>();
		
		// TODO Auto-generated method stub
		try{
			Connection connection=DBConnection.getConnection();
			String sqlquery="select * from course where cid in(select preReqCid from preReq where cid=?);";
			
			
			PreparedStatement pst=connection.prepareStatement(sqlquery);
			pst.setInt(1,cid);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();
			while(rs.next())
			{
				int cid1=rs.getInt("cid");
				Course c=new CourseDaoImpl().getCourse(cid1);
				preReqCourseList.add(c);
				
				
			}
			return preReqCourseList;
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
			
		return preReqCourseList;
		
	}

}
