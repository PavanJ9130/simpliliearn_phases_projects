package com.sportyshoes.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sportyshoes.mvc.models.User;

public interface Userrepo extends JpaRepository<User, Long>{


	public List<User> findByUsernameAndPassword(String username,String password);
}
