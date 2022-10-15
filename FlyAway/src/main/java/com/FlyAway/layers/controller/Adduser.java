package com.FlyAway.layers.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.FlyAway.layers.dto.Airlines;
import com.FlyAway.layers.dto.Flights;
import com.FlyAway.layers.dto.User;
import com.FlyAway.layers.service.FlyAwayServiceImpl;

public class Adduser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		user details
		String fname = (String) request.getParameter("fname");
		String lname = (String) request.getParameter("lname");
		String gender = (String) request.getParameter("gender");
		String address = (String) request.getParameter("address");
		String email = (String) request.getParameter("email");
		Long phoneno = Long.parseLong(request.getParameter("phoneno"));
		int newsit = Integer.parseInt(request.getParameter("sits"));

		User user = new User(fname, lname, gender, address, email, phoneno);
		int i = new FlyAwayServiceImpl().adduser(user);

//		book flight details
		HttpSession s = request.getSession();
		Integer flightid = (Integer) (s.getAttribute("flightid"));
		String airlinename = (String) s.getAttribute("airlinename");
		String source = (String) s.getAttribute("source");
		String dest = (String) s.getAttribute("dest");
		String date = (String) s.getAttribute("date");
		String time = (String) s.getAttribute("time");
		Double price = (Double) s.getAttribute("price");

		if (i > 0) {
			String msg = "Details successfully Save! ";
			s.setAttribute("flightid", flightid);
			s.setAttribute("airlinename", airlinename);
			s.setAttribute("source", source);
			s.setAttribute("dest", dest);
			s.setAttribute("date", date);
			s.setAttribute("time", time);
			s.setAttribute("price", price);
			s.setAttribute("sits", newsit);
			request.setAttribute("msg", msg);
			RequestDispatcher dispatcher = request.getRequestDispatcher("Payment.jsp");
			dispatcher.forward(request, response);
		} else {
			String msg = "Some thing went wrong!! Please try again";
			request.setAttribute("msg", msg);
			response.sendRedirect("Userdetails.jsp");

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
