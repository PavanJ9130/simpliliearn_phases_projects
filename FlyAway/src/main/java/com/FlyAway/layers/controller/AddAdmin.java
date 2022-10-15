package com.FlyAway.layers.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FlyAway.layers.dto.Admin;
import com.FlyAway.layers.service.FlyAwayServiceImpl;

public class AddAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		Long phoneno = Long.parseLong(request.getParameter("phoneno"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Admin admin = new Admin(name, address, phoneno, username, password);

		FlyAwayServiceImpl service = new FlyAwayServiceImpl();
		int i = service.addadmin(admin);

		if (i > 0) {
			String msg = "Registration successfully Completed! ";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
			dispatcher.forward(request, response);
		} else {
			String msg = "Some thing went wrong!! Please try again";
			request.setAttribute("msg", msg);
			response.sendRedirect("AdminRegister.jsp");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
