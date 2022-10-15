package com.sportyshoes.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.mvc.dao.Productdao;
import com.sportyshoes.mvc.models.Products;

@Service
public class Productservices {

	@Autowired
	private Productdao dao;
	
	public List<Products> getallproducts(){
		return dao.getallproducts();
	}
	
	public Products getproductsbyid(Long id) {
		return dao.getproductbyid(id);
	}
	
	public Products addproduct(Products product) {
		return dao.addproduct(product);
	}
	
	public String updateproduct(Products product,Long id) {
		return dao.updateproduct(product, id);
	}
	public String deleteproduct(Long id) {
		return dao.deleteproductbyid(id);
	}
}
