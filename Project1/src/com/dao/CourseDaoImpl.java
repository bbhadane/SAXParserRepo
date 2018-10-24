package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Main.DBConnection;
import com.model.Course;
import com.model.Course;
import com.model.Course;
import com.model.Course;

public class CourseDaoImpl implements CourseDao
{

	private static List<Course> allCoursesList=new ArrayList<Course>();
	
	@Override
	public Course getCourse(int cid) {
		// TODO Auto-generated method stub
		try {
			Course dummy=new Course();
			dummy.setCid(cid);
			if(allCoursesList.contains(dummy))
			{
				int index=allCoursesList.indexOf(dummy);
				return allCoursesList.get(index);
			}
			
			Connection connection=DBConnection.getConnection();
			String sqlQuery="select * from "+TABLECourse+" where "+COLcid+" = ?";
			PreparedStatement pst;
			pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1, cid);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();
			
			if(rs.next()==false)
			{
				return null;
			}
			String name=rs.getString(COLcname);
			int duration=rs.getInt(COLduration);
			int fees=rs.getInt(COLfees);
			
			Course  course =new Course(cid,name,duration,fees);
			allCoursesList.add(course);
			return course;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		
	}

	
	@Override
	public List<Course> getAllCourses() {
		
		
		allCoursesList=new ArrayList<Course>();
		
		try {
			
			//if not found in the list get one from db and add it to the list
			Connection connection=DBConnection.getConnection();
			String sqlQuery="select * from "+TABLECourse;
			
			PreparedStatement pst=connection.prepareStatement(sqlQuery);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();
			//if not even a single line is returned there is no student with this id
			while(rs.next())
			{
				int cid=rs.getInt(COLcid);
				String name=rs.getString(COLcname);
				int cduration=rs.getInt(COLduration);
				int fees=rs.getInt(COLfees);
				
				Course course =new Course(cid,name,cduration,fees);
				allCoursesList.add(course);
				
			}
			
			
			return allCoursesList;
			
		}
		catch (SQLException ex) 
		{
			// TODO Auto-generated catch block
			System.out.println(ex);
		}
		return allCoursesList;
	}
	@Override
	public void addCourse(Course c) throws CourseExistsException {
		
		try
		{
		Connection connection=DBConnection.getConnection();
		String sqlQuery="insert into "+TABLECourse+" values (?,?,?,?)";
		
		PreparedStatement pst = connection.prepareStatement(sqlQuery);
		
		pst.setInt(1, c.getCid());
		pst.setString(2, c.getCname());
		pst.setInt(3, c.getCduration());
		pst.setInt(4, c.getCfees());
		
		pst.executeUpdate();
		
		allCoursesList.add(c);
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void updateCourse(Course c) {
		// TODO Auto-generated method stub
		
		int cid1 = c.getCid();
		try
		{
		Connection connection=DBConnection.getConnection();
		String sqlQuery="update "+TABLECourse+" set "+COLcname+" = ?,  "+COLduration+" = ?, "+COLfees+"=?  where "+COLcid+" ="+cid1;
		
		PreparedStatement pst = connection.prepareStatement(sqlQuery);
		pst.setString(1, c.getCname());
		pst.setInt(2, c.getCduration());
		pst.setInt(3, c.getCfees());
		
		pst.executeUpdate();

		
		
		} catch (SQLException e) {
					
			e.printStackTrace();
		}
		
	}

	@Override
	public void deleteCourse(Course c) {
		
		try
		{
			int cid1 = c.getCid();
		Connection connection=DBConnection.getConnection();
		String sqlQuery="delete "+TABLECourse+" where "+COLcid+" = "+cid1;
		
		PreparedStatement pst = connection.prepareStatement(sqlQuery);
		
		//pst.setInt(1, s.getSid());
		//pst.setString(2, s.getName());
		//pst.setString(3, s.getInst());
		
		pst.executeUpdate();
		
		Course dummy=new Course();
		dummy.setCid(c.getCid());;
		//find student in list only
		if(allCoursesList.contains(dummy))
		{
			allCoursesList.remove(dummy);
		}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
