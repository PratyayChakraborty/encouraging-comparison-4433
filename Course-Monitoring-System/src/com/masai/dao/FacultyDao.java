package com.masai.dao;

import java.util.List;

import com.masai.Model.Faculty;
import com.masai.exceptions.FacultyException;

public interface FacultyDao {

public String addFaculty() throws FacultyException;
	public Boolean FacultyLogin() throws FacultyException;
	public List<Faculty> getAllFacultyDetails()throws FacultyException;
	
	public List<Faculty> searchFacultyByName() throws FacultyException;
	
	public Faculty searchFacultyById() throws FacultyException;
	
	public String updateFacultyDetails() throws FacultyException;
	
	public String deleteFaculty() throws FacultyException;
	public String updateppssword()throws FacultyException;

}
