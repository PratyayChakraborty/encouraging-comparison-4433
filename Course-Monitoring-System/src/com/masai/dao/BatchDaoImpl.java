package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.masai.Extra.ConsoleColors;
import com.masai.Model.Batch;
import com.masai.Model.Report;
import com.masai.Utility.DBUtil;
import com.masai.exceptions.BatchException;

public class BatchDaoImpl implements BatchDao{
	
	@Override
	public String addBatch() throws BatchException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter CourseId");
		int CourseId=sc.nextInt();
		System.out.println("Enter Number of Student");
		int noofstudent=sc.nextInt();
		System.out.println("enter batchstartDate");
		String batchstartDate =sc.next();
		System.out.println("enter duration");
		String duration=sc.next();
String message = ConsoleColors.RED+"Data Not Inserted..."+ConsoleColors.RESET;
		
		try(Connection conn = DBUtil.provConnection()){
			
			PreparedStatement ps = conn .prepareStatement("select courseName from course where courseId = ?");
			
			ps.setInt(1,CourseId);
			
			ResultSet rs = ps.executeQuery();
			
			String cName = "";
			if(rs.next()) {		
				cName = rs.getString("courseName");
				
			}else {
//				throw new BatchException(ConsoleColors.RED_BACKGROUND+"Course Id does not exist."+ConsoleColors.RESET);
				System.out.println(ConsoleColors.RED_BACKGROUND+"Course Id does not exist."+ConsoleColors.RESET);
			}
			
			
			PreparedStatement ps1 = conn .prepareStatement("select count(courseId) from Batch where courseId = ?");
			
			ps1.setInt(1, CourseId);
			
			ResultSet rs1 = ps1.executeQuery();
			

			int count = 0;
			if(rs1.next()) {		
				count = rs1.getInt(1);
			}else {
				throw new BatchException(ConsoleColors.RED_BACKGROUND+"Course Id does not exist."+ConsoleColors.RESET);
			}
			
			count++;
//			String text = String.format("%03d", count);
			
			int batchId = count;
			
			PreparedStatement ps2 = conn .prepareStatement("insert into Batch( courseId, numberOfStudents, batchstartDate, duration) values(?,?,?,?)");
			
//			ps2.setInt(1, batchId);
			ps2.setInt(1,CourseId);
			ps2.setInt(2,noofstudent);
			ps2.setString(3, batchstartDate);
			ps2.setString(4, duration);
			
			int x = ps2.executeUpdate();
			
			if(x>0) {		
				message = ConsoleColors.GREEN+"New Course Added Successfully.."+ConsoleColors.RESET;	
				
			}else {
				throw new BatchException(ConsoleColors.RED_BACKGROUND+"Duplicate Entry"+ConsoleColors.RESET);
				
			}
			
		}catch(SQLException e) {
			
			throw new BatchException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			
		}
		
		return message;
	}

	@Override
	public Batch searchBatchById() throws BatchException {
		// TODO Auto-generated method stub
		Batch batch = null;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter batchid");
		int id=sc.nextInt();
		try(Connection conn = DBUtil.provConnection()){
			
			
			PreparedStatement ps = conn .prepareStatement("Select b.batchId, b.courseId, b.facultyId, f.facultyname, b.numberOfStudents, b.batchstartDate, b.duration from Batch b, Faculty f where  b.batchId = ?");
//			b.facultyID = f.facultyID and
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {		
				String bid = rs.getString("batchId");
				int cid = rs.getInt("courseId");
				int fid = rs.getInt("facultyId");
				String fName = rs.getString("facultyname");
				int nos = rs.getInt("numberOfStudents");
				Date date = rs.getDate("batchstartDate");
				String dur = rs.getString("duration");
				
				String sDate = date.toString();
				
				batch = new Batch(id, cid, fid, nos, sDate, dur);
				
			}else 
				throw new BatchException(ConsoleColors.RED_BACKGROUND+"Batch does not exist with this id "+ id + "."+ConsoleColors.RESET);
			
		}catch(SQLException e) {
			
//			e.getMessage();
			System.out.println((ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET));
			
		}
		
		
		return batch;
	}

	@Override
	public List<Batch> allBatch() throws BatchException {
		// TODO Auto-generated method stub
List<Batch> batches = new ArrayList<>();
		
		try(Connection conn = DBUtil.provConnection()){
			
			
			PreparedStatement ps = conn .prepareStatement("select * from batch");
//			"Select b.batchId, b.courseId, b.facultyId, f.facultyFname, b.noOfStudents, b.batchstartDate, b.duration from Batch b, Faculty f where b.courseId = ("
//			+ "Select courseId from course where courseName = ?) and b.facultyID = f.facultyID"
//			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {		
				int bid = rs.getInt("batchId");
				int cid = rs.getInt("courseId");
				int fid = rs.getInt("facultyId");
			
				int nos = rs.getInt("numberOfStudents");
				Date date = rs.getDate("batchstartDate");
				String dur = rs.getString("duration");
				
				String sDate = date.toString();
				
				Batch batch = new Batch(bid, cid,fid, nos, sDate, dur);

				
				batches.add(batch);
			}
			if(batches.size() == 0)
				throw new BatchException(ConsoleColors.RED_BACKGROUND+"No Batch  exist  "+ConsoleColors.RESET);
			
		}catch(SQLException e) {
			
			throw new BatchException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			
		}
		
		return batches;
	}

	@Override
	public String updateBatch() throws BatchException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteBatch() throws BatchException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("enter batchid");
		int Id=sc.nextInt();
String message = ConsoleColors.RED+"Batch Data Not Updated..."+ConsoleColors.RESET;
		
		try(Connection conn =DBUtil.provConnection()){
			
			PreparedStatement ps = conn.prepareStatement("delete from batch where batchId = ?");
			
			ps.setInt(1, Id);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message = ConsoleColors.GREEN+"Batch Deleted Successfully.."+ConsoleColors.RESET;	
			}else {
				throw new BatchException(ConsoleColors.RED+"Batch Not Exist"+ConsoleColors.RESET);
			}
			
		} catch (SQLException e) {

			throw new BatchException(ConsoleColors.RED+"Wrong Data Format"+ConsoleColors.RESET);
		}
		
		return message;
	}

	@Override
	public String allocateFaculty() throws BatchException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("give faculty id");
		int fid=sc.nextInt();
		System.out.println("give batchId");
		int batchId=sc.nextInt();
String message = ConsoleColors.RED+"Faculty not allocated to "+batchId+" batch.."+ConsoleColors.RESET;
		
		try(Connection conn = DBUtil.provConnection()){
			
			PreparedStatement ps = conn.prepareStatement("update batch set facultyId = ? where batchId = ?");
			
			ps.setInt(1,fid);
			ps.setInt(2, batchId);
			
			int x = ps.executeUpdate();
			
			if(x>0) {		
				message = ConsoleColors.GREEN+"Faculty allocated to "+batchId+" batch.."+ConsoleColors.RESET;	
			}else {
				throw new BatchException(ConsoleColors.RED+"Batch doesn't Not Exist"+ConsoleColors.RESET);
			}
			
		} catch (SQLException e) {

			throw new BatchException(ConsoleColors.RED+"Wrong Data Format"+ConsoleColors.RESET);
		}
		
		return message;
	}

	@Override
	public List<Report> generateReport() throws BatchException {
		

List<Report> reports = new ArrayList<>();
		
		try(Connection conn = DBUtil.provConnection()){
			
			
			PreparedStatement ps = conn .prepareStatement("select b.batchId, b.courseId, f.facultyname, b.numberofStudents, b.batchstartDate, b.duration, count(c.daynumber) as planned, "
														+ "(select count(c.status) where status is true) as Completed from batch b inner join faculty f inner join courseplan c "
														+ "on b.facultyID = f.facultyID and b.batchid = c.batchId group by c.batchId;");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {		
				String bid = rs.getString("batchId");
				int cid = rs.getInt("courseId");
				String fName = rs.getString("facultyname");
				int sno = rs.getInt("numberOfStudents");
				Date date = rs.getDate("batchstartDate");
				String dur = rs.getString("duration");
				int pland = rs.getInt("planned");
				int comp = rs.getInt("Completed");
				
				String sDate = date.toString();
				
				Report report = new Report(bid,cid,fName,sno,sDate,dur,pland,comp);
				
				reports.add(report);	
			} 
			if(reports.size()==0)
				throw new BatchException(ConsoleColors.RED_BACKGROUND+"No Batche is Started."+ConsoleColors.RESET);
			
		}catch(SQLException e) {
			
			throw new BatchException(ConsoleColors.RED_BACKGROUND+e.getMessage()+ConsoleColors.RESET);
			
		}
		
		
		return reports;
	}

}