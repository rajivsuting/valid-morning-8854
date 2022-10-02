package com.masai.bean;

import java.util.Formatter;

public class Project {
	
	private int id;
	private String name;
	private String location;
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Project(int id, String name, String location) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
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
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Formatter forString() {
		Formatter fmt = new Formatter();
		return  fmt.format("%15s %29s %26s\n" ,id, name,location)  ;
	}
	
	

}
