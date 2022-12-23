package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.security.sasl.SaslClient;

import com.masai.Extra.ConsoleColors;
import com.masai.Model.Faculty;
import com.masai.Utility.DBUtil;
import com.masai.exceptions.FacultyException;

public class FacultyDaoImpl implements FacultyDao {

	@Override
	public String addFaculty() throws FacultyException {
		String msg=ConsoleColors.RED+"Faculty not added"+ConsoleColors.RESET;
		Scanner sc=new Scanner(System.in);
//		System.out.println("enter facultyId ");
//		int facultyId =sc.nextInt();
		System.out.println("enter facultyname ");
		String facultyname =sc.next();
		System.out.println("enter facultyaddress ");
		String facultyaddress =sc.next();
		System.out.println("enter mobile ");
		String mobile =sc.next();
		System.out.println("enter email ");
		String email =sc.next();
		System.out.println("enter username ");
		String username =sc.next();
		System.out.println("enter password ");
		String password  =sc.next();
		
		try(Connection conn=DBUtil.provConnection()){
			
			PreparedStatement ps=conn.prepareStatement("insert into faculty(facultyname,facultyaddress,mobile,email,username,password) values(?,?,?,?,?,?)");
			
			ps.setString(1,facultyname);
			ps.setString(2,facultyaddress);
			ps.setString(3,mobile);
			ps.setString(4,email);
			ps.setString(5,username);
			ps.setString(6,password);
			
			int rs=ps.executeUpdate();
			
			if(rs>0) {
				msg=ConsoleColors.GREEN+"Faculty added"+ConsoleColors.RESET;
				
			}
			
			
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public List<Faculty> getAllFacultyDetails() throws FacultyException {
		
		List<Faculty> FacultyList=new ArrayList<>();
		
		try(Connection conn=DBUtil.provConnection()){
			
			PreparedStatement ps=conn.prepareStatement("Select * from faculty");
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("facultyId");
				String name = rs.getString("facultyName");
				String address = rs.getString("facultyAddress");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String username = rs.getString("username");
				String password = "********";
				
				Faculty f=new Faculty(id, name, address, mobile, email, username, password);
				
				FacultyList.add(f);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return FacultyList;
	}

	@Override
	public List<Faculty> searchFacultyByName() throws FacultyException {
		Scanner sc=new Scanner(System.in);
		System.out.println("give faculty name");
		String fname=sc.next();
		List<Faculty> FacultyList=new ArrayList<>();
		
		try(Connection conn=DBUtil.provConnection()){
			
			PreparedStatement ps=conn.prepareStatement("Select * from faculty where facultyName=?");
			
			ps.setString(1, fname);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				int id = rs.getInt("facultyId");
				String name = rs.getString("facultyName");
				String address = rs.getString("facultyAddress");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String username = rs.getString("username");
				String password = "********";
				
				Faculty f=new Faculty(id, name, address, mobile, email, username, password);
				
				FacultyList.add(f);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return FacultyList;
	}

	@Override
	public Faculty searchFacultyById() throws FacultyException {
		Scanner sc=new Scanner(System.in);
		System.out.println("give faculty id");
		int fname=sc.nextInt();
		
		Faculty faculty=new Faculty();
		try(Connection conn=DBUtil.provConnection()){
			
			PreparedStatement ps=conn.prepareStatement("Select * from faculty where facultyName=?");
			
			ps.setInt(1, fname);
			
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt("facultyId");
				String name = rs.getString("facultyName");
				String address = rs.getString("facultyAddress");
				String mobile = rs.getString("mobile");
				String email = rs.getString("email");
				String username = rs.getString("username");
				String password = "********";
				
				faculty.setFacultyid(id);
				faculty.setFacultyname(name);
				faculty.setFacultyaddress(address);
				faculty.setMobile(mobile);
				faculty.setEmail(email);
				faculty.setUsername(username);
				faculty.setPassword(password);
					
				
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return faculty;
	}

	@Override
	public String updateFacultyDetails() throws FacultyException {

		String msg=ConsoleColors.RED+"Not updated"+ConsoleColors.RESET;
		String str="";
		System.out.println(ConsoleColors.PURPLE+"What do you want to update?"+ConsoleColors.RESET);
		
		System.out.println("1. facultyname");
		System.out.println("2. facultyaddress");
		System.out.println("3. mobile");
		System.out.println("4. email");
		System.out.println("5. username");
		System.out.println("6. password");
		Scanner sc=new Scanner(System.in);
		int ip=sc.nextInt();
		switch(ip) {
		case 1:str="facultyname";
				break;
		case 2:str="facultyaddress";
		break;
		case 3:str="mobile";
		break;
		case 4:str="email";
		break;
		case 5:str="username";
		break;
		case 6:str="password";
		break;
		}
		System.out.println("enter facultyid");
		int id=sc.nextInt();
		System.out.println("enter new"+str);
		String set=sc.next();
		try(Connection conn=DBUtil.provConnection()){
			
			PreparedStatement ps=conn.prepareStatement("update faculty set "+str+" = ? where facultyid=?");
			
//			ps.setString(1, str);
			ps.setString(1, set);
			ps.setInt(2, id);
			
			int rs=ps.executeUpdate();
			
			if (rs>0) {
				msg=ConsoleColors.GREEN+"faculty update";
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public String deleteFaculty() throws FacultyException {
		
		String msg=ConsoleColors.RED+" Faculty Not deleted "+ConsoleColors.RESET;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter facultyId ");
		int facultyId =sc.nextInt();
		
		try(Connection conn=DBUtil.provConnection()){
			
			PreparedStatement ps=conn.prepareStatement("delete from faculty where facultyId=?");
			
			ps.setInt(1, facultyId);
			int rs=ps.executeUpdate();
			if(rs>0) {
				msg=ConsoleColors.GREEN+"Faculty deleted "+ConsoleColors.RESET;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return msg;
	}

	@Override
	public Boolean FacultyLogin() throws FacultyException {
		
		boolean flag=false;
		Scanner sc=new Scanner(System.in);
		System.out.println("give username");
		String username=sc.next();
		System.out.println("give pasword");
		String password=sc.next();
		try(Connection conn=DBUtil.provConnection()){
			
			PreparedStatement ps=conn.prepareStatement("select * from faculty where username=?");
			
			ps.setString(1, username);
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				PreparedStatement ps1=conn.prepareStatement("Select * from faculty where username=? and password=?");
				
				ps1.setString(1,username);
				ps1.setString(2, password);
				
				ResultSet rs2=ps1.executeQuery();
				if(rs2.next()) {
					flag=true;
				}else {
				
					System.out.println(ConsoleColors.RED+"Wrong Password"+ConsoleColors.RESET);
				}
			}else {
				System.out.println(ConsoleColors.RED+"No Such faculty Present With this Username"+ConsoleColors.RESET);
			}
			
		} catch (SQLException e) {
			System.out.println(ConsoleColors.RED+e.getMessage()+ConsoleColors.RESET);
		}
		
		return flag;
		
	}

	@Override
	public String updateppssword() throws FacultyException {
		
		String msg=ConsoleColors.RED+"Not updated"+ConsoleColors.RESET;
		String str="";
	
		Scanner sc=new Scanner(System.in);
		
		str="password";
		
		
		System.out.println("enter facultyid");
		int id=sc.nextInt();
		System.out.println("enter new"+str);
		String set=sc.next();
		try(Connection conn=DBUtil.provConnection()){
			
			PreparedStatement ps=conn.prepareStatement("update faculty set "+str+" = ? where facultyid=?");
			

			ps.setString(1, set);
			ps.setInt(2, id);
			
			int rs=ps.executeUpdate();
			
			if (rs>0) {
				msg=ConsoleColors.GREEN+"faculty update";
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return msg;
	}

}
