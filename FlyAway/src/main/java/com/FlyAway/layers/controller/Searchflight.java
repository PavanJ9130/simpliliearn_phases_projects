package com.FlyAway.layers.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FlyAway.layers.dto.Airlines;
import com.FlyAway.layers.dto.Flights;
import com.FlyAway.layers.service.FlyAwayServiceImpl;

public class Searchflight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String date = request.getParameter("date");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");

		Flights flights = new Flights();
		flights.setDate(date);
		flights.setSource(source);
		flights.setDestination(destination);

		String flag = "fail";

		ArrayList<Airlines> searchflight = new FlyAwayServiceImpl().Searchflight(flights);

		if (searchflight.size() == 0) {
			flag = "pass";
		}

		request.setAttribute("flag", flag);
		request.setAttribute("searchflight", searchflight);

		RequestDispatcher dispatcher = request.getRequestDispatcher("Searchflight.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
