package com.masai.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection provConnection() {
		Connection conn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/projectsb101";
		
		try {
			conn=DriverManager.getConnection(url,"root","8520");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
//			System.out.println(e.getMessage());
		}
		return conn;
	}
}
