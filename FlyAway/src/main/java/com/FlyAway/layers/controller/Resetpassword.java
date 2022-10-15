package com.FlyAway.layers.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FlyAway.layers.service.FlyAwayServiceImpl;

public class Resetpassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");

		int i = new FlyAwayServiceImpl().resetpassword(username, newpassword, oldpassword);
		if (i > 0) {
			String msg = "Password changed successfully! ";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("AdminLogin.jsp");
			dispatcher.forward(request, response);
		} else {
			String msg = "Some thing went wrong!! Please try again";
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Resetpassword.jsp");
			dispatcher.forward(request, response);

		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
