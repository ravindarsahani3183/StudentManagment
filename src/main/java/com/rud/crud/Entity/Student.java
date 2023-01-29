package com.rud.crud.Entity;

import org.hibernate.validator.constraints.NotEmpty;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;

 // Student class as an Entity   
@Entity
public class Student {
	//Defining Student id as primary key  
	@Id
	private int id;
	
	
	private String name;
	private String address;
	private String email;
	private long  mobileNumber;
	
	
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + ", email=" + email + ", mobileNumber="
				+ mobileNumber + "]";
	}
	
	
	public Student(int id, String name, String address, String email, long mobileNumber) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.email = email;
		this.mobileNumber = mobileNumber;
	}
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
