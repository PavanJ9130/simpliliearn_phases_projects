<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@ include file="Boosttrapfiles.jsp"%>
<style type="text/css">
.container {
	width:100vw;
	height:100vh;
  display:flex;
  align-items:center;
  justify-content: center;
  }
</style>
<title>Flyaway : Reset Password</title>
</head>
<body>
<form action="Resetpassword" method="post">
<div class="container ">
<div class="card  p-2  p-5 m-5 w-100 " style="max-width: 50%;margin-top: 10px;"  >
<h1>Reset Password</h1>
<% String msg=(String)request.getAttribute("msg");
if(msg!=null){
	%>
<h5 style="color: red;" ><%= msg %> </h5> 
	<% 
}
%>
  <div class="form-group">
    <label for="username">Username </label>
    <input type="text" class="form-control" name="username" required="required" placeholder="Enter username">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" class="form-control" name="oldpassword" required="required" placeholder="Enter Old Password">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">New Password</label>
    <input type="password" class="form-control" name="newpassword" required="required" placeholder="Enter New Password">
  </div>
  <button type="submit" class="btn btn-success m-2">Submit</button>
  <a href="AdminLogin.jsp" class="btn btn-primary m-2">Return</a>
</div>
</div>
</form>
</body>
</html>