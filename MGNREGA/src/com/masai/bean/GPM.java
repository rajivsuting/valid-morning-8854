package com.masai.bean;

import java.util.Formatter;

public class GPM {
	
	private int id;
	private String name;
	private String location;
	private String email;
	private String password;
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public GPM() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GPM(int id, String name, String location, String email, String password) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.email = email;
		this.password = password;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	public Formatter forString() {
		Formatter f = new Formatter();
		f.format("%15s %15s %15s %15s %15s\n", id , name , location , email , password);
		return f;
		
	}
	
}
