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

import com.sportyshoes.mvc.models.Categories;
import com.sportyshoes.mvc.services.Categoriesservices;

@RestController
public class Categoriescontroller {

	@Autowired
	private Categoriesservices services;
	
	@GetMapping("/admin/categories/{id}")
	public ResponseEntity<?> getcategoriesbyid(@PathVariable("id")Long id){
		Categories categories = services.getCategoriesbyid(id);
		if (categories!=null) {
			return new ResponseEntity<Categories>(categories,HttpStatus.FOUND);			
		}
		return new ResponseEntity<String>("No records Avaliable",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/admin/categories")
	public ResponseEntity<?> getallcategories(){
		List<Categories> categories = services.getallCategories();
		if (categories.isEmpty()!=true) {
			return new ResponseEntity<List<Categories>>((List<Categories>)categories,HttpStatus.FOUND);			
		}
		return new ResponseEntity<String>("No records Avaliable",HttpStatus.NOT_FOUND);
	}
			
	@PostMapping("/admin/categories")
	public ResponseEntity<?> addcategories(@RequestBody Categories categories) {
		Categories addcat = services.addCategories(categories);
		if (addcat != null) {
			return new ResponseEntity<Categories>(addcat, HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("This Category is already exists", HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/admin/categories/{id}")
	public ResponseEntity<String> updatecatbyid(@PathVariable("id") Long id, @RequestBody Categories categories) {	
		return new ResponseEntity<String>(services.updatecatbyid(categories, id), HttpStatus.OK);
	}

	@DeleteMapping("/admin/categories/{id}")
	public ResponseEntity<String> deletebyid(@PathVariable("id") Long id) {
		return new ResponseEntity<String>(services.deletebyid(id), HttpStatus.OK);
	}

}
