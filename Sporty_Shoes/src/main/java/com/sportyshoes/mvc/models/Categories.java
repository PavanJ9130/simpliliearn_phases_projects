package com.sportyshoes.mvc.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "categories")
public class Categories {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="categories_id")
	private Long id;
	
	@Column(name="categories_name",nullable = false,unique = true)
	private String name;
	
	@Column(name="categories_desc",nullable = false)
	private String desc;
	
	@OneToMany(mappedBy = "categories",
			fetch = FetchType.LAZY, 
			cascade = CascadeType.ALL,targetEntity = Products.class)
	@JsonManagedReference
	private List<Products> products;
	
	public Categories() {}

	public Categories(String name, String desc, List<Products> products) {
		super();
		this.name = name;
		this.desc = desc;
		this.products = products;
	}

	public Categories(String name, String desc) {
		super();
		this.name = name;
		this.desc = desc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	
	
}
