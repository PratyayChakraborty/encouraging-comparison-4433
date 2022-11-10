package com.masai.dao;

import com.masai.exceptions.AdminException;

public interface AdminDao {
	public boolean LoginAdmim(String username,String password)throws AdminException;
	
}
