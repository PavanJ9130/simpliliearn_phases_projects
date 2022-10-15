<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="Boosttrapfiles.jsp"%>
<style type="text/css">
<%@ include file="CSS/homepage.css"%>
.adminlogin {
	display: none;
}

.lcontainer {
	width: 100%;
	height: 100vh;
	display: flex;
	align-items: center;
	justify-content: center;
}
</style>
<title>FlyAway: Admin Login</title>
</head>
<body>
	<div class="container l-0px r-0px">
		<%@ include file="Navbar.jsp"%>
	</div>
	<form action="Validadmin" method="post">
		<div class="lcontainer ">
			<div class="card  p-2  p-5 m-5 w-100 "
				style="max-width: 50%; margin-top: 10px;">
				<h1>Admin Login</h1>
				<%
				String msg = (String) request.getAttribute("msg");
				if (msg != null) {
				%>
				<h5 style="color: green;"><%=msg%>
				</h5>
				<%
				}
				%>
				<div class="form-group">
					<label for="username">Username </label> <input type="text"
						class="form-control" name="username" required="required"
						placeholder="Enter username">
				</div>
				<div class="form-group">
					<label for="exampleInputPassword1">Password</label> <input
						type="password" class="form-control" name="password"
						required="required" placeholder="Enter Password">
				</div>
				<a href="Resetpassword.jsp">Reset Password</a>

				<button type="submit" class="btn btn-primary m-2">Submit</button>
				<a href="AdminRegister.jsp">Signup</a>
			</div>
		</div>
	</form>
</body>
</html>