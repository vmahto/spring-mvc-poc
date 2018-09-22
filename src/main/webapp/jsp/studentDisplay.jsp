<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring-MVC-POC</title>
</head>
<body>
<h2> <span style="color: green;">Show All Student</span></h2>
<table style="with: 50%">
				<tr>
					<td>First Name: </td>
					<td>${student.getFname()} </td>
				</tr>
				<tr>
					<td>Last Name: </td>
					<td>${student.getLname()}</td>
				</tr>
				<tr>
					<td>UserName: </td>
					<td>${student.getUsername()}</td>
				</tr>
					<tr>
					<td>Password: </td>
					<td>${student.getPassword()}</td>
				</tr>
				<tr>
					<td>Address: </td>
					<td>${student.getAddress()}</td>
				</tr>
				<tr>
					<td>Contact No: </td>
					<td>${student.getContactNo()}</td>
				</tr></table>
<h3><a href="./">Add New Student</a></h3>

</body>
</html>
