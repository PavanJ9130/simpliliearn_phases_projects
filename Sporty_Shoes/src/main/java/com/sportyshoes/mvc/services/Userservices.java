package com.sportyshoes.mvc.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.mvc.dao.Userdao;
import com.sportyshoes.mvc.models.User;

@Service
public class Userservices {

	@Autowired
	private Userdao dao;
	
	public User adduser(User user) {
		return dao.adduser(user);
	}
	
	public List<User> getallusers(){
		return dao.getalluser();
	}
	public User getbyid(Long id) {
		return dao.getbyid(id);
	}
	public String updatebyid(User user,Long id) {
		return dao.updatebyid(id, user);
	}
	public String deletebyid(Long id){
		return dao.deletebyid(id);
	}
	public List<User> login(String username,String password) {
		return dao.Login(username, password);
	}
}
