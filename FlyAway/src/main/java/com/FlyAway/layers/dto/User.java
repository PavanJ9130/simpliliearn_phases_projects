package com.FlyAway.layers.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_details")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;

	@Column(name = "first_name")
	private String fname;

	@Column(name = "last_name")
	private String lname;

	@Column(name = "user_gender")
	private String gender;

	@Column(name = "user_adderess")
	private String address;

	@Column(name = "user_email")
	private String email;

	@Column(name = "user_PhoneNO", length = 50)
	private Long number;

	public User() {
	}

	public User(String fname, String lname, String gender, String address, String email, Long number) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.number = number;
	}

	public User(int id, String fname, String lname, String gender, String address, String email, Long number) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.gender = gender;
		this.address = address;
		this.email = email;
		this.number = number;
	}

	public String getGender() {
		return gender;
	}

	public String getEmail() {
		return email;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getAddress() {
		return address;
	}

	public Long getNumber() {
		return number;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

}
