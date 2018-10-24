package com.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Main.DBConnection;
import com.model.Student;

public class StudentDaoImpl implements StudentDao{

	private static List<Student> allStudentList=new ArrayList<Student>();

	@Override
	public Student getStudent(int sid) {
		
		try {
			Student dummy=new Student();
			dummy.setSid(sid);
			if(allStudentList.contains(dummy))
			{
				int index=allStudentList.indexOf(dummy);
				return allStudentList.get(index);
			} 
			
			Connection connection=DBConnection.getConnection();
			String sqlQuery="select * from "+TABLEStudent+" where "+COLSid+"="+"?";
			
			PreparedStatement pst=connection.prepareStatement(sqlQuery);
			pst.setInt(1, sid);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();
			if(rs.next()==false)
			{
				return null;
			}
			String name=rs.getString(COLSname);
			String instituteName=rs.getString(COLInstituteName);
			String email=rs.getString(COLEmail);
			String password=rs.getString(COLPassword);
			Student  student =new Student(sid,name,instituteName, email, password);
			allStudentList.add(student);
			return student;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
			allStudentList=new ArrayList<Student>();
		
		try {
			
			//if not found in the list get one from db and add it to the list
			Connection connection=DBConnection.getConnection();
			String sqlQuery="select * from "+TABLEStudent;
			
			PreparedStatement pst=connection.prepareStatement(sqlQuery);
			pst.executeQuery();
			ResultSet rs=pst.getResultSet();
			//if not even a single line is returned there is no student with this id
			while(rs.next())
			{
				int sid=rs.getInt(COLSid);
				String name=rs.getString(COLSname);
				String instituteName=rs.getString(COLInstituteName);
				String email=rs.getString(COLEmail);
				String password=rs.getString(COLPassword);
				Student  student =new Student(sid,name,instituteName, email, password);
				
				allStudentList.add(student);
				
			}
			
			
			return allStudentList;
			
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			System.out.println(ex);
		}
		return allStudentList;
		
	}

	@Override
	public void addStudent(Student s) throws StudentExistsException {
		// TODO Auto-generated method stub
		
		try
		{
		Connection connection=DBConnection.getConnection();
		String sqlQuery="insert into "+TABLEStudent+" values (?,?,?,?,?)";
		
		PreparedStatement pst = connection.prepareStatement(sqlQuery);
		
		pst.setInt(1, s.getSid());
		pst.setString(2, s.getSname());
		pst.setString(3, s.getInstituteName());
		pst.setString(4, s.getEmail());
		pst.setString(5, s.getPassword());
		
		pst.executeUpdate();
		allStudentList.add(s);
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
	}

	@Override
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		//
		int sid1 = s.getSid();
		try
		{
		Connection connection=DBConnection.getConnection();
		String sqlQuery="update "+TABLEStudent+" set "+COLSname+" = ? ,"+COLInstituteName+" = ? ,"+COLEmail+" = ? , "+ COLPassword + " = ? where "+COLSid+" ="+sid1;
		
		PreparedStatement pst = connection.prepareStatement(sqlQuery);
		
		pst.setString(1, s.getSname());
		pst.setString(2, s.getInstituteName());
		pst.setString(3, s.getEmail());
		pst.setString(4, s.getPassword());
		
		pst.executeUpdate();
		
		for(Student st:allStudentList)
		{
			if(st.getSid()==s.getSid())
			{
				st.setSname(s.getSname());
				st.setInstituteName(s.getInstituteName());
				st.setEmail(s.getEmail());
				st.setPassword(s.getPassword());
			}
		}
		
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}



	@Override
	public void deleteStudent(Student s) {
		// TODO Auto-generated method stub
		
		try
		{
			int sid2 = s.getSid();
		Connection connection=DBConnection.getConnection();
		String sqlQuery="delete "+TABLEStudent+" where "+COLSid+" = "+sid2;
		
		PreparedStatement pst = connection.prepareStatement(sqlQuery);
		pst.executeUpdate();
		
		Student dummy=new Student();
		dummy.setSid(s.getSid());
		if(allStudentList.contains(dummy))
		{
			allStudentList.remove(dummy);
		}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}

}
