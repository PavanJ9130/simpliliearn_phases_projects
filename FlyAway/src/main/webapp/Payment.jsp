<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.FlyAway.layers.dto.Flights"%>
<%@page import="com.FlyAway.layers.dto.Airlines"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="Boosttrapfiles.jsp"%>

<style type="text/css">
<%@
includefile="CSS/payment.css"%>
</style>
<title>FlyAway :Payment</title>
</head>
<body>
	<%
	HttpSession s=request.getSession();
	Integer sits = (Integer)(s.getAttribute("sits")); 
	Integer flightid = (Integer)(s.getAttribute("flightid"));
	String airlinename = (String) s.getAttribute("airlinename");
	String source = (String)s.getAttribute("source");
	String dest = (String) s.getAttribute("dest");
	String date = (String) s.getAttribute("date");
	String time = (String) s.getAttribute("time");
	Double price = (Double)(s.getAttribute("price"));
	%>
	<div class="container">
		<div class="row m-0 justify-content-center">
			<div class="col-lg-5 p-0 ps-lg-4 justify-content-center">
				<div class="row m-0">
					<div class="col-12 px-4">
						<div class="d-flex align-items-end mt-4 mb-2">
							<p class="h4 m-0">
								<span class="pe-1"><%=airlinename%></span>
							</p>

						</div>
						<div class="d-flex justify-content-between mb-2">
							<p class="textmuted">Date & Time</p>
							<p class="fs-14 fw-bold">
							<input type="datetime" value="<%=date + time%>"
								style="border-style: none;" disabled="disabled" /></p>
						</div>
						<div class="d-flex justify-content-between mb-2">
							<p class="textmuted">Flight ID</p>
							<p class="fs-14 fw-bold"><%=flightid%></p>
						</div>
						
						<div class="d-flex justify-content-between mb-2">
							<p class="textmuted">Source</p>
							<p class="fs-14 fw-bold">
								<span class="fas fa-dollar-sign pe-1"></span><%=source%></p>
						</div>
						<div class="d-flex justify-content-between mb-2">
							<p class="textmuted">Destination</p>
							<p class="fs-14 fw-bold">
								<span class="fas fa-dollar-sign pe-1"></span><%=dest%></p>
						</div>
						<div class="d-flex justify-content-between mb-2">
							<p class="textmuted">Tickets</p>
							<p class="fs-14 fw-bold"><%=sits%></p>
						</div>
						<div class="d-flex justify-content-between mb-2">
							<p class="textmuted">Ticket Price</p>
							<p class="fs-14 fw-bold">
								<span class="fas fa-dollar-sign px-1"></span><%=price%></p>
						</div>
						<div class="d-flex justify-content-between mb-3">
							<p class="textmuted fw-bold">Total</p>
							<div class="d-flex align-text-top ">
								<span class="fas fa-dollar-sign mt-1 pe-1 fs-14 "></span><span
									class="h4"><%= price * sits%></span>
							</div>
						</div>
					</div>
					<form action="Flightbook.jsp">
					<div class="col-12 px-0">
						<div class="row bg-light m-0">
							<div class="col-12 px-4 my-4">
								<p class="fw-bold">Payment detail</p>
							</div>
							<div class="col-12 px-4">
								<div class="d-flex  mb-4">
									<span class="">
										<p class="text-muted">Card number</p> <input
										class="form-control" type="number" value=""
										placeholder="1234 5678 9012 3456" required="required"> 
										
									</span>
									<div class=" w-100 d-flex flex-column align-items-end">
										<p class="text-muted">Expires</p>
										<input class="form-control2" type="text" value=""
											placeholder="MM/YYYY" required="required">
									</div>
								</div>
								<div class="d-flex mb-5">
									<span class="me-5">
										<p class="text-muted">Cardholder name</p> <input
										class="form-control" type="text" value=""
										placeholder="Name" required="required">
									</span>
									<div class="w-100 d-flex flex-column align-items-end">
										<p class="text-muted">CVC</p>
										<input class="form-control3" type="text" value=""
											placeholder="XXX" required="required">
									</div>
								</div>
							</div>
						</div>
						<div class="row m-0">
							<div class="col-12  mb-4 p-0">
							      <input type="submit" class="fas fa-arrow-right ps-2 btn btn-primary" value="Pay Now">														
							</div>
							<div class="col-12  mb-4 p-0">
							      <a href="homepage.jsp" class="fas fa-arrow-right ps-2 btn btn-primary" style="background-color: #0e6fff"> Cancel</a>														
							</div>
						</div>
					</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>