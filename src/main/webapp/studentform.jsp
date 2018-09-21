<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Registration Form</title>
</head>
<body>
<form action="addStudent" method="post">
			<table style="with: 50%">
				<tr>
					<td>First Name</td>
					<td><input type="text" name="fname" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lname" /></td>
				</tr>
				<tr>
					<td>UserName</td>
					<td><input type="text" name="username" /></td>
				</tr>
					<tr>
					<td>Password</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><input type="text" name="address" /></td>
				</tr>
				<tr>
					<td>Contact No</td>
					<td><input type="text" name="contactNo" /></td>
				</tr></table>
			<input type="submit" value="Submit" /></form>
		<h3><a href="deleteStudent/1">Delete Studnet Id 1</a></h3>
		<h3><a href="./showStudnets">Display Student List</a></h3>
</body>
</html>
