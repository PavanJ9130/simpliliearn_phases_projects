package com.FlyAway.layers.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FlyAway.layers.dto.Admin;
import com.FlyAway.layers.service.FlyAwayServiceImpl;

public class Validadmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");

		Admin admin = new Admin();
		admin.setUsername(username);
		admin.setPassword(password);

		boolean flag = new FlyAwayServiceImpl().validadmin(admin);
		if (flag) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Adminpage.jsp");
			dispatcher.forward(request, response);
		} else {
			String msg = "User not found! Please Signup...";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
