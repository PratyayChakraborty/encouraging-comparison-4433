package com.masai.Model;

public class Course {
	private int courseid ;
	private String courseName;
	private int fee;
	private String courseDescription;
	
	public Course() {
		
	}

	public Course(int courseid, String courseName, int fee, String courseDescription) {
		super();
		this.courseid = courseid;
		this.courseName = courseName;
		this.fee = fee;
		this.courseDescription = courseDescription;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getCourseDescription() {
		return courseDescription;
	}

	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}

	@Override
	public String toString() {
		return "Course [courseid=" + courseid + ", courseName=" + courseName + ", fee=" + fee + ", courseDescription="
				+ courseDescription + "]";
	}
	

}
