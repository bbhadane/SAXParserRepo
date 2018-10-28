package com.dao;

import java.util.HashMap;
import java.util.List;

import com.model.Course;
import com.model.Enrollment;
import com.model.Student;

public interface EnrollmentDao {
String TABLEEnrollment="enrollment",COLeid="eid",COLcid="cid",COLsid="sid",COLDATE="enrollmentDate",COLfees="paidFees";
List<Enrollment> getAllEnrollment();
List<Course>getCourseOfStudent(int sid);
Enrollment addEnrollment(Enrollment e);
//void addEnrollment(Student student, Course course);
List<Student> enrolledStudentInCourse(int cid);
Enrollment getEnrollment(int sid, int cid);
HashMap<Integer,Integer> getCourseOfStudentAndMarksObtained(int sid);






}
