package com.masai.dao;

import java.util.List;

import com.masai.Model.CoursePlan;
import com.masai.Model.Report;
import com.masai.exceptions.CoursePlanException;

public interface CoursePlanDao {
public String addCoursePlan() throws CoursePlanException;
	
	public String updateStatus() throws CoursePlanException;
	
	public String updateStatusAdmin() throws CoursePlanException;
	
	public String updateTopic() throws CoursePlanException;
	
//	public String updateDate() throws CoursePlanException;
//	
//	public String deleteStatus() throws CoursePlanException;
//	
	public List<CoursePlan> viewAllCoursePlanDateWise() throws CoursePlanException;
//	
//	public List<CoursePlan> viewFacultyCoursePlan() throws CoursePlanException;
	
//	public List<CoursePlan> viewCourseplan() throws CoursePlanException;
}
