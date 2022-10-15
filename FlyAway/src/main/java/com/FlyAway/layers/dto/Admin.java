package com.FlyAway.layers.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Admin_details")
public class Admin {
	@Id
	@Column(name = "Admin_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "Admin_Name")
	private String name;

	@Column(name = "Admin_Address")
	private String address;

	@Column(name = "Admin_PhoneNO", length = 50)
	private Long phoneno;

	@Column(name = "Admin_Username")
	private String username;

	@Column(name = "Admin_Password")
	private String password;

	public Admin() {
	}

	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Admin(Integer id, String name, String address, Long phoneno, String username, String password) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.phoneno = phoneno;
		this.username = username;
		this.password = password;
	}

	public Admin(String name, String address, Long phoneno, String username, String password) {
		super();
		this.name = name;
		this.address = address;
		this.phoneno = phoneno;
		this.username = username;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public Long getPhoneno() {
		return phoneno;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneno(Long phoneno) {
		this.phoneno = phoneno;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
