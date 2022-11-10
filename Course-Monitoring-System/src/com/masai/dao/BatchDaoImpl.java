package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.masai.Extra.ConsoleColors;
import com.masai.Model.Batch;
import com.masai.Model.Report;
import com.masai.Utility.DBUtil;
import com.masai.exceptions.BatchException;

public class BatchDaoImpl implements BatchDao{
	
	@Override
	public String addBatch() throws BatchException {
		// TODO Auto-generated method stub
		
		
		return null;
	}

	@Override
	public Batch searchBatchById() throws BatchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Batch> allBatch() throws BatchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateBatch() throws BatchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteBatch() throws BatchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String allocateFaculty() throws BatchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Report> generateReport() throws BatchException {
		// TODO Auto-generated method stub
		return null;
	}

}