package com.sportyshoes.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.sportyshoes.mvc.models.Categories;
import com.sportyshoes.mvc.models.Order;
import com.sportyshoes.mvc.models.Products;
import com.sportyshoes.mvc.models.User;
import com.sportyshoes.mvc.repository.Categoriesrepo;
import com.sportyshoes.mvc.repository.Orderrepo;
import com.sportyshoes.mvc.repository.Productrepo;
import com.sportyshoes.mvc.repository.Userrepo;

@SpringBootApplication
public class SportyShoesApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SportyShoesApplication.class, args);
	}

}
