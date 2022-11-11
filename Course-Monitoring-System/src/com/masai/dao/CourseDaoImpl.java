package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.masai.Extra.ConsoleColors;
import com.masai.Model.Course;
import com.masai.Utility.DBUtil;
import com.masai.exceptions.CourseException;

public class CourseDaoImpl implements CourseDao {

	@Override
	public String addCourse() throws CourseException {
		// TODO Auto-generated method stub
//		Course course
		Scanner sc=new Scanner(System.in);
//		System.out.println("enter course name");
		
		System.out.println("enter course name");
		String name=sc.next();
		System.out.println("enter course fee");
		int fee=sc.nextInt();
		System.out.println("enter course CourseDesc");
		String CourseDesc=sc.next();
		String message = ConsoleColors.RED+"Data Not Inserted..."+ConsoleColors.RESET;
		
		try(Connection conn = DBUtil.provConnection()){
			
			PreparedStatement ps = conn .prepareStatement("insert into course(courseName, Fee, courseDescription) values(?,?,?)");
			
			ps.setString(1,name);
			ps.setInt(2, fee);
			ps.setString(3, CourseDesc);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message = ConsoleColors.GREEN+"New Course Added Successfully.."+ConsoleColors.RESET;	
			}else {
				throw new CourseException(ConsoleColors.RED_BACKGROUND+"Duplicate Entry"+ConsoleColors.RESET);
			}
			
		}catch(SQLException e) {
//			e.printStackTrace();
			
			throw new CourseException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			
		}
		
		return message;
	}

	@Override
	public Course searchCourse() throws CourseException {
		// TODO Auto-generated method stub
//		String name
Course course = null;
	Scanner sc=new Scanner(System.in);


	System.out.println("enter course name");
	String name=sc.next();
		try(Connection conn = DBUtil.provConnection()){
			
			PreparedStatement ps = conn .prepareStatement("Select * from Course where courseName = ?");
			
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {		
				
				int cid = rs.getInt("courseId");
				String cname = rs.getString("courseName");
				int cfee = rs.getInt("courseFee");
				String cdesc = rs.getString("courseDesc");
				
				course = new Course(cid, cname, cfee, cdesc);
				
			}else {
				throw new CourseException(ConsoleColors.RED_BACKGROUND+"Course does not exist."+ConsoleColors.RESET);
			}
			
				
		}catch(SQLException e) {
//			e.printStackTrace();
			
			throw new CourseException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
		}
		
		return course;
	}

	@Override
	public List<Course> getAllCourse() throws CourseException {
List<Course> courses = new ArrayList<>();
		
		try(Connection conn =DBUtil.provConnection()){
			
			PreparedStatement ps = conn .prepareStatement("Select * from Course");

			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {		
				
				int cid = rs.getInt("courseId");
				String cname = rs.getString("courseName");
				int cfee = rs.getInt("Fee");
				String cdesc = rs.getString("courseDescription");
				
				Course course = new Course(cid, cname, cfee, cdesc);
				
				courses.add(course);
				
			}
			
			if(courses.size() == 0) {
				throw new CourseException(ConsoleColors.RED_BACKGROUND+"No Course found.."+ConsoleColors.RESET);
			}
			
				
		}catch(SQLException e) {
//			e.printStackTrace();
			
			throw new CourseException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
		}
		
		return courses;
	}

	@Override
	public String updateCourseDetails() throws CourseException {
		// TODO Auto-generated method stub
//		String str, String set, String name
String message = ConsoleColors.RED+"Course Data Not Updated..."+ConsoleColors.RESET;
				Scanner sc=new Scanner(System.in);
				System.out.println("give course name");
				String name=sc.next();
				System.out.println("give new fee");
				int fee=sc.nextInt();
				
		try(Connection conn = DBUtil.provConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update course set fee= ? where courseName = ?");
			
			ps.setInt(1, fee);
			ps.setString(2, name);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message = ConsoleColors.GREEN+"course Details Updated Successfully.."+ConsoleColors.RESET;	
			}else {
				throw new CourseException(ConsoleColors.RED+"Course Not Exist"+ConsoleColors.RESET);
			}
			
		} catch (SQLException e) {	
			throw new CourseException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			
		}
		
		return message;
	}

	@Override
	public String deleteBatch() throws CourseException {
		// TODO Auto-generated method stub
//		String cName
		String message = ConsoleColors.RED+"Batch Data Not Updated..."+ConsoleColors.RESET;
		Scanner sc=new Scanner(System.in);
		System.out.println("give course name");
		String name=sc.next();
		try(Connection conn = DBUtil.provConnection()){
			
			PreparedStatement ps = conn.prepareStatement("delete from course where courseName = ?");
			
			ps.setString(1, name);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message = ConsoleColors.GREEN+"Course Deleted Successfully.."+ConsoleColors.RESET;	
			}else {
				throw new CourseException(ConsoleColors.RED+"Course Not Exist"+ConsoleColors.RESET);
				
			}
		}catch (SQLException e) {
			
			throw new CourseException(ConsoleColors.RED+"Wrong Data Format"+ConsoleColors.RESET);
		}
		
		return message;
	}

}
