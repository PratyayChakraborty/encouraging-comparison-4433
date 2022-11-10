package com.masai.Model;

public class CoursePlan {
	private int planId;
	private int batchId;
	private int Daynumber;
	private String Topic;
	private boolean status;
	
	public CoursePlan() {
		// TODO Auto-generated constructor stub
	}

	public CoursePlan(int planId, int batchId, int daynumber, String topic, boolean status) {
		super();
		this.planId = planId;
		this.batchId = batchId;
		Daynumber = daynumber;
		Topic = topic;
		this.status = status;
	}

	public int getPlanId() {
		return planId;
	}

	public void setPlanId(int planId) {
		this.planId = planId;
	}

	public int getBatchId() {
		return batchId;
	}

	public void setBatchId(int batchId) {
		this.batchId = batchId;
	}

	public int getDaynumber() {
		return Daynumber;
	}

	public void setDaynumber(int daynumber) {
		Daynumber = daynumber;
	}

	public String getTopic() {
		return Topic;
	}

	public void setTopic(String topic) {
		Topic = topic;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CoursePlane [planId=" + planId + ", batchId=" + batchId + ", Daynumber=" + Daynumber + ", Topic="
				+ Topic + ", status=" + status + "]";
	}
	

}
