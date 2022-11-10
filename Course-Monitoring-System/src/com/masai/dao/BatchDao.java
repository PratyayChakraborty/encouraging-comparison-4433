package com.masai.dao;

import java.util.List;

import com.masai.Model.Batch;
import com.masai.Model.Report;
import com.masai.exceptions.BatchException;

public interface BatchDao {

	public String addBatch() throws BatchException;
	
	public Batch searchBatchById() throws BatchException;
	
	public List<Batch> allBatch() throws BatchException;
	
	public String updateBatch () throws BatchException;
	
	public String deleteBatch() throws BatchException;
	
	public String allocateFaculty() throws BatchException;
	
	public List<Report> generateReport() throws BatchException;
}
