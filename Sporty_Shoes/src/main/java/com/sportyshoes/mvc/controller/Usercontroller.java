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

import com.sportyshoes.mvc.models.Admin;
import com.sportyshoes.mvc.models.User;
import com.sportyshoes.mvc.services.Userservices;

@RestController
public class Usercontroller {

	@Autowired
	private Userservices userservices;
	
	@GetMapping("/user/login/{uname}/{pword}")
	public ResponseEntity<?> login(@PathVariable("uname") String username,
			@PathVariable("pword") String password){
		List<User> user = userservices.login(username, password);
	if (user!=null) {
		return new ResponseEntity<List<User>>(user,HttpStatus.FOUND);
	}
	return new ResponseEntity<String>("something went wrong[check username and password]",HttpStatus.NOT_FOUND);		
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getbyid(@PathVariable("id") Long id){
		User user = userservices.getbyid(id);
		if (user!=null) {
			return new ResponseEntity<User>(user,HttpStatus.FOUND);			
		}
		return new ResponseEntity<String>("No record found",HttpStatus.NOT_FOUND);
	}
	@GetMapping("/user")
	public ResponseEntity<?> getbyid(){
		List<User> allusers = userservices.getallusers();
		if (allusers.isEmpty()==false) {
			return new ResponseEntity<List<User>>(allusers,HttpStatus.FOUND);			
		}
		return new ResponseEntity<String>("No record found",HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> addadmin(@RequestBody User user) {
		User adduser = userservices.adduser(user);
		if(adduser!=null) {
			return new ResponseEntity<User>(adduser,HttpStatus.CREATED);			
		}
		return new ResponseEntity<String>("something went wrong[All fields are mandatory and username not to be same]"
										  ,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/user/{id}")
	public ResponseEntity<String> updatebyid(@PathVariable("id") Long id,
											 @RequestBody User user){
		return new ResponseEntity<String>(userservices.updatebyid(user, id),HttpStatus.OK);
	}
	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> updatebyid(@PathVariable("id") Long id){
		return new ResponseEntity<String>(userservices.deletebyid(id),HttpStatus.OK);
	}
	
}
