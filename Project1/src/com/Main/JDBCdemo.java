package com.Main;

import java.util.List;
import java.util.Scanner;

import com.dao.CourseDao;
import com.dao.CourseDaoImpl;
import com.dao.CourseExistsException;
import com.dao.EnrollmentDao;
import com.dao.EnrollmentDaoImpl;
import com.dao.StudentDao;
import com.dao.StudentDaoImpl;
import com.dao.StudentExistsException;
import com.model.Course;
import com.model.Enrollment;
import com.model.Student;

public class JDBCdemo {

	public static void main(String args[])
	{
		StudentDao studentDao=new StudentDaoImpl();
		CourseDao courseDao=new CourseDaoImpl();
		EnrollmentDao enrollmentdao1=new EnrollmentDaoImpl();
		Scanner sc=new Scanner(System.in);
		int choice;
		int ch=1;
		do
		{
		System.out.println("1] Student table operations");
		System.out.println("2] Course table operations");
		System.out.println("3] Enrollment table Operations");
		System.out.println("Enter your choice");
		choice=sc.nextInt();
		
		switch(choice)
		{
		case 1:
			do
			{
				System.out.println("1] Get student information");
				System.out.println("2] Get All students Information");
				System.out.println("3] Add student");
				System.out.println("4] Update student");
				System.out.println("5] Delete Student");
				System.out.println("Enter your choice");
				int choice1=sc.nextInt();
				
				
				
				switch (choice1) {
				case 1:System.out.println("Printing Information of student");
						System.out.println("Enter sid : ");
						int sid=sc.nextInt();
						
						Student student=studentDao.getStudent(sid);
						System.out.println(student);
						break;

				case 2:
						System.out.println("************Printing all students************");
						
						List<Student> allStudents=studentDao.getAllStudents();
						for(Student st: allStudents)
						{
							System.out.println(st);
						}
						
						System.out.println("*************** Printed all students ***************");
						
						break; 
				case 3:
						System.out.println("*************** Adding Student ***************");
						
						
						
						System.out.println("Enter sid of student : ");
						int sid1=sc.nextInt();
						System.out.println("Enter name of student : ");
						String name=sc.next();
						System.out.println("Enter institute of student : ");
						String inst=sc.next();
						System.out.println("Enter email of student : ");
						String email=sc.next();
						System.out.println("Enter password : ");
						String pass=sc.next();
						
						Student student1=new Student(sid1,name,inst,email,pass);
						try {
							studentDao.addStudent(student1);
						} catch (StudentExistsException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						System.out.println(student1);
						System.out.println("*************** Student Added ***************");
						
						
				case 4:
						System.out.println("*************** updating Student ***************");
						System.out.println("Enter Sid to update");
						int sid2=sc.nextInt();
						System.out.println("Enter name of student : ");
						String name1=sc.next();
						System.out.println("Enter institute of student : ");
						String inst1=sc.next();
						System.out.println("Enter email of student : ");
						String email1=sc.next();
						System.out.println("Enter password : ");
						String pass1=sc.next();
						
						Student student2=new Student(sid2,name1,inst1,email1,pass1);
						studentDao.updateStudent(student2);
						
						Student updateStudent= studentDao.getStudent(sid2);
						System.out.println(updateStudent);
						System.out.println("*************** Student updated ***************");
						break;
				case 5:

						System.out.println("*************** Deleting Student ***************");
						System.out.println("Enter Sid to delete");
						int sid3=sc.nextInt();
						Student student5=studentDao.getStudent(sid3);
						studentDao.deleteStudent(student5);
						
						Student deleteStudent= studentDao.getStudent(sid3);
						System.out.println(deleteStudent);
						System.out.println("*************** Student deleted ***************");
						break;
					
				default:
					break;
				}
				System.out.println("Do you want to continue ?????????\n Yes = 1 \n No = 0");
				ch=sc.nextInt();
				
			}while(ch!=0);
			break;
		case 2:
			do{
				System.out.println("1] show course details");
				System.out.println("2] Show all the courses");
				System.out.println("3] add course");
				System.out.println("4] update course");
				System.out.println("5] delete course");
				System.out.println("enter your choice");
				ch=sc.nextInt();
				switch(ch)
				{
				case 1:	System.out.println("Printing Information of course");
						System.out.println("Enter sid : ");
						int cid=sc.nextInt();
						Course course=courseDao.getCourse(cid);
						System.out.println(course);
						break;
				case 2:
						System.out.println("************Printing all courses************");
						List<Course> allCourses=courseDao.getAllCourses();
						for(Course c: allCourses)
						{
							System.out.println(c);
						}
						break;
					
				case 3:
						System.out.println("*************** Adding Course ***************");
						System.out.println("Enter cid of course");
						int cid1=sc.nextInt();
						System.out.println("Enter name of course");
						String cname=sc.next();
						System.out.println("Enter duration of course");
						int duration=sc.nextInt();
						System.out.println("Enter course fees");
						int cfees=sc.nextInt();
						
						
						
						Course course1 =new Course(cid1,cname,duration,cfees);
						try 
						{
							courseDao.addCourse(course1);
							
						} catch (CourseExistsException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
						}
						System.out.println("*************** Course Added ***************");
						break;
						
				case 4:
						System.out.println("*************** Updating Course ***************");
						System.out.println("Enter Cid to update Course");
						int cid2=sc.nextInt();
						System.out.println("enter Name");
						String name=sc.next();
						System.out.println("enter cduration");
						int cduration=sc.nextInt();
						System.out.println("Enter Fees");
						int fees=sc.nextInt();
						Course c1 = new Course(cid2,name,cduration,fees);
						courseDao.updateCourse(c1);
						System.out.println("*************** Course Updated ***************");
						break;
					
				case 5:
						System.out.println("*************** Deleting Course ***************");
						System.out.println("Enter Cid to delete");
						int cid3=sc.nextInt();
						Course course3=courseDao.getCourse(cid3);
						courseDao.deleteCourse(course3);
						
						Course deleteCourse= courseDao.getCourse(cid3);
						System.out.println(deleteCourse);
						System.out.println("*************** Course Deleted ***************");
						break;
				default:
							System.out.println("Wrong choice");
						
				}
				System.out.println("Do you want to continue ?????????\n Yes = 1 \n No = 0");
				ch=sc.nextInt();
			}while(ch!=0);
			
			break;
		case 3:
			do{
				System.out.println("1] Get all courses of student");
				System.out.println("2] Get all enrollment");
				System.out.println("3] Get all students enrolled in course");
				System.out.println("4] add Enrollment");
		
				System.out.println("enter your choice");
				ch=sc.nextInt();
				switch(ch)
				{
				case 1:
					//getcoursesallocatedforstudent
					
					System.out.println(" Courses allocated for student: ");
					System.out.println("enter sid");
					int sid=sc.nextInt();
//					System.out.println("Enter cid ");
//					int cid=sc.nextInt();
					List<Course>getCourseOfStudent = enrollmentdao1.getCourseOfStudent(sid);
					for(Course courselist:getCourseOfStudent)
					{
						System.out.println(courselist);
					}
					break;
				case 2:
					System.out.println("********** Printing all the Enrollment **********");
					List<Enrollment> allEnrollment=enrollmentdao1.getAllEnrollment();
					for(Enrollment enroll:allEnrollment)
						System.out.println(enroll);
					System.out.println("********** Printed all the Enrollment *********");
					break;
				case 3:
					System.out.println("********** Printing list of students enrolled for course *********");
					System.out.println("Enter cid to find list of students : ");
					int cid11=sc.nextInt();
					List<Student> studentEnrolledInCourse=enrollmentdao1.enrolledStudentInCourse(cid11);
					for(Student s:studentEnrolledInCourse)
						System.out.println(s);
					System.out.println("********* List Printed *********");
					break;
				case 4:
					//addstudent
					EnrollmentDao enrollment1 =new EnrollmentDaoImpl();
					StudentDao student=new StudentDaoImpl();
					CourseDao course=new CourseDaoImpl();
					System.out.println("Enter cid of course");
					int cid1=sc.nextInt();
					System.out.println("Enter sid");
					int sid1=sc.nextInt();
					//System.out.println("Enter date");
					//int fees = sc.nextInt();
					//enrollment1.addEnrollment(student.getStudent(sid1),course.getCourse(cid1));
					//enrollment1.add(student.);
					System.out.println(enrollment1);
					break;
				default:
					System.out.println("WRONG choice");
				}
				System.out.println("Do you want to continue ?????????\n Yes = 1 \n No = 0");
				ch=sc.nextInt();
			}while(ch!=0);
			break;
		}
		
//		System.out.println("Do you want to continue ?????????\n Yes = 1 \n No = 0");
//		ch=sc.nextInt();
		}while(choice!=3);	
	}
}
