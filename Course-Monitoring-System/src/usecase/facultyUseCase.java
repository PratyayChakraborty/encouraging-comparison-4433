package usecase;

import java.util.List;
import java.util.Scanner;

import com.masai.Extra.ConsoleColors;
import com.masai.Model.CoursePlan;
import com.masai.dao.CoursePlanDao;
import com.masai.dao.CoursePlanDaoImpl;
import com.masai.dao.FacultyDao;
import com.masai.dao.FacultyDaoImpl;
import com.masai.exceptions.CoursePlanException;
import com.masai.exceptions.FacultyException;

import Main.Main;

public class facultyUseCase {
	
	public static void facultyOptions() {
		FacultyDao f=new FacultyDaoImpl();
		CoursePlanDao cp=new CoursePlanDaoImpl();
		System.out.println(ConsoleColors.CYAN+"chose your option");
		System.out.println("1. View the Course Plan");
		System.out.println("2.Fill up the day wise planner");
		System.out.println("3. Update Password");
		System.out.println("4. Log Out"+ConsoleColors.RESET);
		Scanner sc=new Scanner(System.in);
		System.out.println();
		
		String ip=sc.next();
		
		switch (ip) {
		case "1": {
		
			try {
			List<CoursePlan>cl=	cp.viewAllCoursePlanDateWise();
			for (CoursePlan coursePlan : cl) {
				System.out.println(coursePlan);
				facultyOptions();
			}
			} catch (CoursePlanException e) {
				// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			facultyOptions();
			
			}
		break;		
		}
		case "2": {
			try {
				System.out.println(cp.updateTopic());
				facultyOptions();
			} catch (CoursePlanException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				facultyOptions();
			}
			break;		
			}
		case "3": {
			try {
				System.out.println(f.updateppssword());
				facultyOptions();
			} catch (FacultyException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				facultyOptions();
			}
			
			break;		
			}
		case "4":{
			Main.main(null);
			break;
		}
		
		default:
			System.out.println("Unexpected value: " +ip);
//			("Unexpected value: " +ip);
			
		}
		
	}
	

}
