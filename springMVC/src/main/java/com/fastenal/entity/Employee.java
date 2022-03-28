package com.fastenal.entity;

public class Employee {
	private Integer id;
	private String fullname;
	private String email;
	private String gender;
	private String hobbies;
	private String country;
	private String address;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Employee() {
		super();
	}
	public Employee(Integer id, String fullname, String email, String gender, String hobbies, String country,
			String address) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.gender = gender;
		this.hobbies = hobbies;
		this.country = country;
		this.address = address;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getHobbies() {
		return hobbies;
	}
	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
}
