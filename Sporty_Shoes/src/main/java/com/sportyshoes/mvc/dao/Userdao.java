package com.sportyshoes.mvc.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sportyshoes.mvc.models.Admin;
import com.sportyshoes.mvc.models.User;
import com.sportyshoes.mvc.repository.Userrepo;

@Repository
public class Userdao {

	@Autowired
	private Userrepo userrepo;
	
	public User adduser(User user) {
		try {
			return userrepo.saveAndFlush(user);
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	public User getbyid(Long id) {
		try {
			Optional<User> data = userrepo.findById(id);
			return data.get();			
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	
	public List<User> getalluser(){
		try {
			return userrepo.findAll();
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	
	public String updatebyid(Long id,User user) {
		try {
			Optional<User> data = userrepo.findById(id);
			User olduser = data.get();
			if (user.getFname()!=null) {
				olduser.setFname(user.getFname());				
			}
			if (user.getLname()!=null) {
				olduser.setLname(user.getLname());				
			}
			if (user.getAddress()!=null) {
				olduser.setAddress(user.getAddress());				
			}
			if (user.getPhoneno()!=null) {
				olduser.setPhoneno(user.getPhoneno());				
			}
			if (user.getUsername()!=null) {
				olduser.setUsername(user.getUsername());				
			}
			if (user.getPassword()!=null) {
				olduser.setPassword(user.getPassword());				
			}
			userrepo.saveAndFlush(olduser);
			return "changes save successfully";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	public String deletebyid(Long id) {
		try {
			userrepo.deleteById(id);
			return "Record deleted successfully";
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	public List<User> Login(String username,String password) {
		try {
			List<User> users = userrepo.findByUsernameAndPassword(username, password);
			if (users.isEmpty()!=true) {
				return users;					
			}
			
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	
}
