<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="com.FlyAway.layers.util.ConnectionManagerImpl"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.FlyAway.layers.dto.Flights"%>
<%@page import="com.FlyAway.layers.dto.Airlines"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@ include file="Boosttrapfiles.jsp"%>

<style type="text/css">
<%@ include file="CSS/homepage.css"%>
.searchbtn{
display: none;
}
.searchcontainer{
 display:flex; 
align-items: flex-start;
justify-content: center;
margin: 10px;
margin-top:3%;
padding: 10px

}
body {
	margin: 0px;
	padding: 0px;
}

</style>
<title>FlyAway : Search Flight</title>
</head>
<body>
<div class="container l-0px r-0px  ">
		<%@ include file="Navbar.jsp"%>
	</div>
	<form action="Searchflight" method="post">
<div class="searchcontainer ">
<div class="input-group">
  <input id="datepicker" width="160" value="2022-07-01" name="date"/>
  
  <input type="search" class="form-control rounded" name="source" placeholder="Where From?" aria-label="Search" aria-describedby="search-addon" />
  <i class="bi bi-arrow-left-right"></i>
  <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left-right m-auto" viewBox="0 0 16 16">
  <path fill-rule="evenodd" d="M1 11.5a.5.5 0 0 0 .5.5h11.793l-3.147 3.146a.5.5 0 0 0 .708.708l4-4a.5.5 0 0 0 0-.708l-4-4a.5.5 0 0 0-.708.708L13.293 11H1.5a.5.5 0 0 0-.5.5zm14-7a.5.5 0 0 1-.5.5H2.707l3.147 3.146a.5.5 0 1 1-.708.708l-4-4a.5.5 0 0 1 0-.708l4-4a.5.5 0 1 1 .708.708L2.707 4H14.5a.5.5 0 0 1 .5.5z"/>
</svg>
  <input type="search" class="form-control rounded" name="destination" placeholder="Where To?" aria-label="Search" aria-describedby="search-addon" />

	    <form class="col-md-4 rounded" >
	   
	   <select class="form-control select2 rounded" style="max-width: 65px;" name="sits" Selected="Sits" />  
	           <option value="" selected="selected" disabled="disabled">sits</option>
	           <option>1</option> 
	           <option>2</option> 
	           <option>3</option> 
	           <option>4</option> 
	           <option>5</option> 
	           <option>6</option> 
	        </select>
	    </form>
 

  <button type="submit" class="btn btn-outline-primary">search</button>
</div>
</div>
</form>
<% 

SessionFactory factory = new ConnectionManagerImpl().getConnection();
Session s = factory.openSession();
Transaction transaction = s.beginTransaction();
ArrayList<Airlines> searchflight=new ArrayList<Airlines>();

String flag="fail";
flag=(String)request.getAttribute("flag");

searchflight=(ArrayList<Airlines>)request.getAttribute("searchflight");
if(flag!=null ){ 
	if(flag.equals("pass")){
	 %> 
	<div class="searchcontainer mt-5">
	 <h1 >No Flights Available!!</h1> 
	  </div>
	 <%
 }}    
if(searchflight!=null){	
for(Airlines airlines:searchflight){
  for (Flights flight : airlines.getFlights()) {  
	%>
	<div class="card m-3 p-2" style="max-width: auto;">
		<div class="card-body">
			<h5 class="card-title"><%=airlines.getName()%></h5>
			<input type="datetime-local" value="<%=flight.getDate()+flight.getTime()%>"
				style="border-style: none;" disabled />

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
	<% }}}%>
		


	

</body>
<script>
        $('#datepicker').datepicker({
            uiLibrary: 'bootstrap4',format: 'yyyy-mm-dd',minDate: '2022-07-01',
        });
    </script>
</html>