package com.masai.dao;

import java.util.List;

import com.masai.Model.Course;
import com.masai.exceptions.CourseException;

public interface CourseDao {
public String addCourse()throws CourseException;
	
	public Course searchCourse() throws CourseException;
	
	public List<Course> getAllCourse() throws CourseException;
	
	public String updateCourseDetails() throws CourseException;
	
	public String deleteBatch() throws CourseException;
}
