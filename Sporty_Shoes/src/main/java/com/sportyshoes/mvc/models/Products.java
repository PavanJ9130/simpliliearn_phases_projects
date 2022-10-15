package com.sportyshoes.mvc.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_id")
	private Long id;

	@Column(name = "product_name", nullable = false)
	private String name;

	@Column(name = "product_price", nullable = false)
	private Double price;

	@Column(name = "product_desc", nullable = false)
	private String desc;

	@ManyToMany(mappedBy = "products", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Order> order;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Categories.class)
	@JoinColumn(name = "cat_id")
	@JsonBackReference
	private Categories categories;

	public Products() {
	}

	public Products(String name, Double price, String desc, Categories categories) {
		super();
		this.name = name;
		this.price = price;
		this.desc = desc;
		this.categories = categories;
	}

	public Products(String name, Double price, String desc, List<Order> order, Categories categories) {
		super();
		this.name = name;
		this.price = price;
		this.desc = desc;
		this.order = order;
		this.categories = categories;
	}

	public Products(String name, Double price, String desc) {
		super();
		this.name = name;
		this.price = price;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Categories getCategories() {
		return categories;
	}

	public void setCategories(Categories categories) {

		this.categories = categories;
	}

	public List<Order> getOrder() {
		return order;
	}

	public void setOrder(List<Order> order) {
		this.order = order;
	}

}
