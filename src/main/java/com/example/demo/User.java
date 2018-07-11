package com.example.demo;

import java.io.Serializable;

public class User implements Serializable{
	
	String id;
	String fname;
	String lname;
	
	
	public User(String id, String fname, String lname) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	

}
