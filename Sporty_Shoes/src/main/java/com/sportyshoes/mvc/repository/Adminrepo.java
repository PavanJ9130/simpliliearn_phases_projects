package com.sportyshoes.mvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sportyshoes.mvc.models.Admin;

public interface Adminrepo extends JpaRepository<Admin, Long>{
	

	public List<Admin> findByUsername(String username);
	
	@Query("select a from Admin a where a.username=?1 and a.password=?2")
	public List<Admin> findByUsernameAndPassword(String username,String password);
}
