package com.sportyshoes.mvc.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportyshoes.mvc.models.Products;
import com.sportyshoes.mvc.repository.Categoriesrepo;
import com.sportyshoes.mvc.repository.Productrepo;

@Repository
public class Productdao {

	@Autowired
	private Productrepo productrepo;

	@Autowired
	private Categoriesrepo categoriesrepo;

	public List<Products> getallproducts(){
		try {
			return productrepo.findAll();
		} catch (Exception e) {
			 e.getStackTrace();
		}
		return null;
	}
	
	public Products getproductbyid(Long id) {
		try {
			Optional<Products> data=productrepo.findById(id);
			return data.get();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	} 
	
	public Products addproduct(Products product) {
		List<Products> check = productrepo.findByName(product.getName(), product.getCategories().getName());
		for (Products pro : check) {
			if (pro.getName().contains(product.getName())
					|| pro.getCategories().getName().contains(product.getCategories().getName())) {
				return null;
			}
		}
		return productrepo.save(product);
	}

	public String updateproduct(Products product, Long id) {
		try {
			Optional<Products> oldproducts = productrepo.findById(id);
			Products oldproduct = oldproducts.get();
			Long oldcatid = oldproduct.getCategories().getId();
			if (product.getName() != null) {
				oldproduct.setName(product.getName());
			}
			if (product.getPrice() != null) {
				oldproduct.setPrice(product.getPrice());
			}
			if (product.getDesc() != null) {
				oldproduct.setDesc(product.getDesc());
			}
			if (product.getCategories() != null) {
				oldproduct.setCategories(product.getCategories());
			}
			productrepo.updateproductscat(oldproduct.getName(), oldproduct.getPrice(), oldproduct.getDesc(),
					oldproduct.getCategories(), id);
			categoriesrepo.deleteById(oldcatid);
		} catch (Exception e) {
			e.getMessage();
		}
		return "record update successfully;";
	}

	public String deleteproductbyid(Long id) {
		try {
			productrepo.deletebyid(id);
		} catch (Exception e) {
			return e.getMessage();
		}
		return "product delete successfully";
	}
}
