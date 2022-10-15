package com.sportyshoes.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.sportyshoes.mvc.models.Products;
import com.sportyshoes.mvc.services.Productservices;

@RestController
public class Productcontroller {

	@Autowired
	private Productservices services;
	
	@GetMapping("/admin/product/{id}")
	public ResponseEntity<?> getproductbyid(@PathVariable("id")Long id){
		Products products = services.getproductsbyid(id);
		if (products!=null) {
			return new ResponseEntity<Products>(products,HttpStatus.FOUND);			
		}
		return new ResponseEntity<String>("No records Avaliable",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/admin/product")
	public ResponseEntity<?> getallproducts(){		
		List<Products> allproducts = services.getallproducts();
		if (allproducts.isEmpty()!=true) {
			return new ResponseEntity<List<Products>>((List<Products>) allproducts,HttpStatus.FOUND);			
		}
		return new ResponseEntity<String>("No records Avaliable",HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/admin/product")
	public ResponseEntity<?> addproduct(@RequestBody Products product){
		Products addproduct = services.addproduct(product);
		if (addproduct==null) {
			return new ResponseEntity<String>("This product or category is already exists",HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Products>(addproduct,HttpStatus.CREATED);
	}
	
	@PutMapping("/admin/product/{id}")
	public ResponseEntity<String> addproduct(@PathVariable("id") Long id, @RequestBody Products product){
		return new ResponseEntity<String>(services.updateproduct(product,id),
										  HttpStatus.CREATED);
	}
	@DeleteMapping("/admin/product/{id}")
	public ResponseEntity<String> deleteproduct(@PathVariable("id") Long id){
		return new ResponseEntity<String>(services.deleteproduct(id),
											HttpStatus.OK);
	}
}
