package com.isp.model;

import java.io.Serializable;

	public class Plans implements Serializable{
		private int planId;
	    private String planName;
	    private double price;
	    private int speed;
	    private String dataLimit;
	    private String category;
	   
		public int getPlanId() {
			return planId;
		}
	    public void setPlanId(int planId) {
			this.planId = planId;
		}
	    public String getPlanName() {
			return planName;
		}
	    public void setPlanName(String planName) {
			this.planName = planName;
		}
	    public double getPrice() {
			return price;
		}
	    public void setPrice(double price) {
			this.price = price;
		}
	    public int getSpeed() {
			return speed;
		}
	    public void setSpeed(int speed) {
			this.speed = speed;
		}
	    public String getDataLimit() {
			return dataLimit;
		}
	    public void setDataLimit(String dataLimit) {
			this.dataLimit = dataLimit;
		}
	    public String getCategory() {
			return category;
		}
	    public void setCategory(String category) {
			this.category = category;
		}

	}

