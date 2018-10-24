package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import com.Main.DBConnection;
import com.model.Course;
import com.model.Enrollment;
import com.model.Student;

public class EnrollmentDaoImpl implements EnrollmentDao{
	
	private static List<Enrollment> allEnrollmentList=new ArrayList<Enrollment>();
	@Override
	public List<Enrollment> getAllEnrollment() {
		try{
			Connection connection=DBConnection.getConnection();
			String sqlquery="select * from "+TABLEEnrollment+";";
			
			PreparedStatement pst=connection.prepareStatement(sqlquery);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();
		
			while(rs.next())
			{
				int eid=rs.getInt(COLeid);
				int sid=rs.getInt(COLsid);
				int cid=rs.getInt(COLcid);
				Date date=rs.getDate(COLDATE);
				int fees=rs.getInt(COLfees);
				
				Enrollment enroll=new Enrollment(new StudentDaoImpl().getStudent(sid),new CourseDaoImpl().getCourse(cid),date,fees,eid);
				
				
				allEnrollmentList.add(enroll);
				
				
			}
			return allEnrollmentList;
		}
			catch (SQLException e) {
				// TODO: handle exception
				System.out.println(e);
			}

		return allEnrollmentList;
		
	}
	
	
	@Override	
	public List<Course> getCourseOfStudent(int sid)
{
		List<Course>CourseList=new ArrayList<Course>();
		try{
			Connection connection=DBConnection.getConnection();
			String sqlQuery="select * from "+TABLEEnrollment+" where "+COLsid+"="+"?";
			PreparedStatement pst = connection.prepareStatement(sqlQuery);
			pst.setInt(1, sid);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();
			while(rs.next())
			{
				//int sid=rs.getInt(COLsid);
				int cid=rs.getInt(COLcid);
				//new CourseDaoImpl.getC(cid);
				CourseList.add(new CourseDaoImpl().getCourse(cid));
			}
				return  CourseList;
		}catch (SQLException ex) {
					
					ex.printStackTrace();
				}
		return CourseList;
		}
	
			
			@Override
			public Enrollment addEnrollment(Enrollment e){
				
				
			
				try
				{
				Connection connection=DBConnection.getConnection();
				String sqlQuery="insert into "+TABLEEnrollment+" values (?,?,?,?,?)";
				
				PreparedStatement pst = connection.prepareStatement(sqlQuery);
				
				pst.setInt(1, e.getEid());
				pst.setInt(2,e.getStudent().getSid());
				pst.setInt(3,e.getCourse().getCid());
				pst.setDate(4, e.getEnrollmentDate());
				pst.setInt(5,e.getPaidFees());
				
				pst.executeQuery();
				//allEnrollmentList.add(e);
				
				} catch (SQLException ex) {
					
					ex.printStackTrace();
				}
				return e;
			}
			
			
				@Override
				public List<Student> enrolledStudentInCourse(int cid11) {
					List<Student> studentInCourse=new ArrayList<Student>();
					
					// TODO Auto-generated method stub
					try{
						Connection connection=DBConnection.getConnection();
						String sqlquery="select * from student where sid in(select sid from enrollment where cid=?);";
						
						
						PreparedStatement pst=connection.prepareStatement(sqlquery);
						pst.setInt(1, cid11);
						pst.executeQuery();
						ResultSet rs=pst.getResultSet();
						while(rs.next())
						{
							int sid=rs.getInt("sid");
							Student s=new StudentDaoImpl().getStudent(sid);
							studentInCourse.add(s);
							
							
						}
						return studentInCourse;
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
						
					return studentInCourse;
					
				}
				
				
				@Override
				public Enrollment getEnrollment(int sid, int cid) {
					// TODO Auto-generated method stub
					return null;
				}

	}


