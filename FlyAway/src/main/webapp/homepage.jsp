<!doctype html>
<%@page import="java.util.ArrayList"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="com.FlyAway.layers.util.ConnectionManagerImpl"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.FlyAway.layers.dto.Flights"%>
<%@page import="com.FlyAway.layers.dto.Airlines"%>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<%@ include file="Boosttrapfiles.jsp"%>
<style type="text/css">
<%@ include file="CSS/homepage.css" %>
.homebtn{
display: none;
}
</style>

<title>Fly Away</title>
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
		for(Airlines airlines:list){
		for (Flights flight : airlines.getFlights()) {
	%>

	<div class="card m-3 p-2" style="max-width: auto;">
		<div class="card-body">
			<h5 class="card-title"><%=airlines.getName()%></h5>
			<input type="datetime-local" value="<%=flight.getDate() + flight.getTime()%>" style="border-style: none;" disabled="disabled">

			<table class="table">
				<thead>
					<tr>
						<th scope="col">Flight ID</th>
						<th scope="col">Source</th>
						<th scope="col">Destination</th>
						<th scope="col">Ticket-Price</th>
						<th scope="col">Passenger-limit</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row"><%=flight.getId()%></th>
						<td><%=flight.getSource()%></td>
						<td><%=flight.getDestination()%></td>
						<td><%=flight.getTicketprice()%></td>
						<td><%=flight.getPassengerlimit()%></td>
				</tbody>
			</table>
			<a href="Bookflight?flightid=<%=flight.getId()%>
			&airlinename=<%=airlines.getName().trim()%>
			&source=<%=flight.getSource().trim()%> 
			&dest=<%=flight.getDestination().trim()%> 
			&date=<%=flight.getDate().trim()%> 
			&time=<%=flight.getTime().trim()%>  
			&price=<%=flight.getTicketprice()%> 
			&sits=1"  
			class="btn btn-primary"  >Book now</a>
		</div>
	</div>


	<%
	}
	}	
	%>



</body>
</html>