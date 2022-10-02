package com.masai.bean;

public class Employee {
	
	private int id;
	private String name;
	private String address;
	private int wages;
	private int duty;
	private int projectAssignend;
	private int GPOAssigned;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getWages() {
		return wages;
	}

	public void setWages(int wages) {
		this.wages = wages;
	}

	public int getProjectAssignend() {
		return projectAssignend;
	}

	public void setProjectAssignend(int projectAssignend) {
		this.projectAssignend = projectAssignend;
	}

	public int getGPOAssigned() {
		return GPOAssigned;
	}

	public void setGPOAssigned(int gPOAssigned) {
		GPOAssigned = gPOAssigned;
	}

	public Employee(int id, String name, String address, int wages,int duty, int projectAssignend, int gPOAssigned) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.wages = wages;
		this.duty = duty;
		this.projectAssignend = projectAssignend;
		GPOAssigned = gPOAssigned;
	}

	public int getDuty() {
		return duty;
	}

	public void setDuty(int duty) {
		this.duty = duty;
	}
	
	
	
	
	
	
	

}
