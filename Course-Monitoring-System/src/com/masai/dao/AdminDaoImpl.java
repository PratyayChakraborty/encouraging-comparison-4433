package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.masai.Extra.ConsoleColors;
import com.masai.Utility.DBUtil;
import com.masai.dao.AdminDao;
import com.masai.exceptions.AdminException;
import com.mysql.cj.protocol.Resultset;

public class AdminDaoImpl implements AdminDao{

	@Override
	public boolean LoginAdmim(String username, String password) throws AdminException {
		// TODO Auto-generated method stub
		boolean flag=false;

		try(Connection conn=DBUtil.provConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select * from admin where username=?");
			
			ps.setString(1, username);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				PreparedStatement ps1=conn.prepareStatement("Select * from admin where username=? and password=?");
				
				ps1.setString(1,username);
				ps1.setString(2, password);
				
				ResultSet rs2=ps1.executeQuery();
				if(rs2.next()) {
					flag=true;
				}else {
				
					System.out.println(ConsoleColors.RED+"Wrong Password"+ConsoleColors.RESET);
				}
			}else {
				System.out.println(ConsoleColors.RED+"No Such Admin Present With this Username"+ConsoleColors.RESET);
			}
			
		} catch (SQLException e) {
			System.out.println(ConsoleColors.RED+e.getMessage()+ConsoleColors.RESET);
		}
		
		return flag;
	}

}
