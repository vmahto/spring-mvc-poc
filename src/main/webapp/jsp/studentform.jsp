<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Registration Form</title>
<style>
.error {
	color: #ff0000;
}

.errorblock {
	color: #000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
</head>
<body>
<!--<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<c:if test="${pageContext.request.userPrincipal.name != null}">
	<a href="javascript:document.getElementById('logout').submit()">Logout</a>
</c:if>-->
<form action="addStudent" method="post">
<!--<form:form method="POST" commandName="studentAdd" >-->
		<form:errors path="*" cssClass="errorblock" element="div" /> 
			<table style="with: 50%">
				<tr>
					<td>First Name</td>
					<td><form:input type="text" path="fname" id="fname" class="form-control input-sm"/></td>
					<!--<div class="col-md-7">
					<form:input type="text" path="fname" id="fname" class="form-control input-sm"/>
					<div class="has-error">
						<form:errors path="fname" class="help-inline"/>
					</div>
				</div>-->
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
					<td>Contact No</td>
					<td><input type="text" name="contactNo" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<table><tr>
					<td>State: </td>
					<td><input type="text" name="state" /></td>
					<tr>
					<td>City: </td>
					<td><input type="text" name="city" /></td></tr>
					<tr>
					<td>Postal Code: </td>
					<td><input type="text" name="zipcode" /></td>
					</tr>
					</tr></table>
				</tr>
				</table>
			<input type="submit" value="Submit" /></form:form>
		<h3><a href="deleteStudent?id=1">Delete Studnet Id 1</a></h3>
		<h3><a href="login/logout">Logout</a></h3>
		<h3><a href="./showStudnets">Display Student List</a></h3>
</body>
</html>
