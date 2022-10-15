package com.FlyAway.layers.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



public class Bookflight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer flightid = Integer.parseInt(request.getParameter("flightid"));
		String airlinename = (String) request.getParameter("airlinename");
		String source = (String) request.getParameter("source");
		String dest = (String) request.getParameter("dest");
		String date = (String) request.getParameter("date");
		String time = (String) request.getParameter("time");
		Double price = Double.parseDouble(request.getParameter("price"));
		Integer sits = Integer.parseInt(request.getParameter("sits"));

		System.out.println(sits);
		HttpSession s = request.getSession();
		s.setAttribute("flightid", flightid);
		s.setAttribute("airlinename", airlinename);
		s.setAttribute("source", source);
		s.setAttribute("dest", dest);
		s.setAttribute("date", date);
		s.setAttribute("time", time);
		s.setAttribute("price", price);
		s.setAttribute("sits", sits);

		RequestDispatcher dispatcher = request.getRequestDispatcher("Userdetails.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
