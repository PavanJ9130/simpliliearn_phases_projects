<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="com.FlyAway.layers.util.ConnectionManagerImpl"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.FlyAway.layers.dto.Flights"%>
<%@page import="com.FlyAway.layers.dto.Airlines"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="Boosttrapfiles.jsp"%>
<style type="text/css">
<%@ include file="CSS/homepage.css" %>
<%@ include file="CSS/Adminpage.css" %>
</style>
<title>FlyAway : Flight details</title>
</head>
<body>
	<div class="container l-0px r-0px">
		<%@ include file="Navbar.jsp"%>
	</div>
	<%
	SessionFactory factory = new ConnectionManagerImpl().getConnection();
	Session s = factory.openSession();
	Transaction transaction = s.beginTransaction();

	Query query = (Query) s.createQuery("from Airlines");
	ArrayList<Airlines> list = (ArrayList<Airlines>) query.getResultList();
	%>
	<div class="tt">
		<div class="airlineslist">
			<h3>List of Airlines</h3>
			<table class="table ">
				<thead>
					<tr>
						<th scope="col">Sr no.</th>
						<th scope="col">Airlines</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Airlines airlines : list) {
					%>
					<tr>
						<th scope="row"><%=airlines.getId()%></th>
						<td><%=airlines.getName()%></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
		<div class="flightlist">
			<h3>List of Source and Destination</h3>
			<table class="table">
				<thead>
					<tr>
						<th scope="col">Sr no.</th>
						<th scope="col">Source</th>
						<th scope="col">Destination</th>
					</tr>
				</thead>
				<tbody>
					<%
					int i = 1;
					for (Airlines airlines : list) {
						for (Flights flight : airlines.getFlights()) {
					%>
					<tr>
						<th scope="row"><%=i++%></th>
						<td><%=flight.getSource()%></td>
						<td><%=flight.getDestination()%></td>
					</tr>
					<%
					}
					}
					%>
				</tbody>
			</table>
		</div>
	</div>
	<div class="airlineslist">
		<h3>All Flight Details</h3>
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Sr no.</th>
					<th scope="col">Airline</th>
					<th scope="col">Source</th>
					<th scope="col">Destination</th>
					<th scope="col">Ticket-Price</th>
				</tr>
			</thead>
			<tbody>
				<%
				int j = 1;
				for (Airlines airlines : list) {
					for (Flights flight : airlines.getFlights()) {
				%>
				<tr>
					<th scope="row"><%=j++%></th>
					<td><%=airlines.getName()%></td>
					<td><%=flight.getSource()%></td>
					<td><%=flight.getDestination()%></td>
					<td><%=flight.getTicketprice()%></td>
				</tr>
				<%}} %>
			</tbody>
		</table>
	</div>
</body>
</html>