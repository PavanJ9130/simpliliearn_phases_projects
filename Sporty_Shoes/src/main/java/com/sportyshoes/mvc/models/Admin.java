package com.sportyshoes.mvc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "admin_id")
	private Long id;
	
	@Column(name = "admin_fname",nullable = false)
	private String fname;
	
	@Column(name = "admin_lname",nullable = false)
	private String lname;
	
	@Column(name = "admin_phoneno",length = 10,nullable = false)
	private Long phoneno;
	
	@Column(name = "admin_address",nullable = false)
	private String address;
	
	@Column(name = "admin_username",unique = true,nullable = false)
	private String username;
	
	@Column(name = "admin_password",nullable = false)
	private String password;
	
	
	public Admin() {}


	public Admin(String fname, String lname, Long phoneno, String address, String username, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.phoneno = phoneno;
		this.address = address;
		this.username = username;
		this.password = password;
	}


	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
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


	public Long getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(Long phoneno) {
		this.phoneno = phoneno;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
