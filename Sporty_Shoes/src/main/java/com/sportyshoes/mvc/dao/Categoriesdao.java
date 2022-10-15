package com.sportyshoes.mvc.dao;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;


import com.sportyshoes.mvc.models.Categories;

import com.sportyshoes.mvc.repository.Categoriesrepo;

@Repository
public class Categoriesdao {

	@Autowired
	private Categoriesrepo categoriesrepo;

	public List<Categories> getallcategories(){
		try {
			return categoriesrepo.findAll();
		} catch (Exception e) {
			 e.getStackTrace();
		}
		return null;
	}
	
	public Categories getCategoriesbyid(Long id) {
		try {
			Optional<Categories> data=categoriesrepo.findById(id);
			return data.get();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return null;
	}
	
	public Categories addcategories(Categories categories) {
		List<Categories> name = (List<Categories>) categoriesrepo.findByName(categories.getName());
		for (Categories cat : name) {
			if (cat.getName().contains(categories.getName())) {		
				return null;				
			}
		}
		return categoriesrepo.save(categories);
	}
	public String updatecatbyid(Categories categories,Long id) {
		Optional<Categories> findById = categoriesrepo.findById(id);
		Categories oldcategories = findById.get();
		if (categories.getName()!=null) {
			oldcategories.setName(categories.getName());			
		}
		if (categories.getDesc()!=null) {
			oldcategories.setDesc(categories.getDesc());
		}
		try {
			if (categoriesrepo.findById(id).isPresent()) {
				categoriesrepo.updatecat(categories.getName(), categories.getDesc(), id);
				return "category updated successfully";				
			}
		} catch (Exception e) {
			return e.getMessage();
			
		}
		return "No record found...";
	}
	
	public String deletebyid(Long id) {
		try {
			categoriesrepo.deleteById(id);
			
		} catch (Exception e) {
			return e.getMessage();
		}
		return "record deleted successfully";
	}

	
}
