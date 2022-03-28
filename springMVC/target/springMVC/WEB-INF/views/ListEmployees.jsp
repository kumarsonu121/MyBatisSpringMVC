<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>my-app</title>
</head>
<link rel="stylesheet" href="resources/Stylesheets/ListEmployee.css" type="text/css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<body style="background-color: cyan">
<nav class="navbar navbar-light bg-dark">
    <img src="https://i.ibb.co/2sxtdT2/Employee.jpg" alt="Employee" width="130" height="30"  class="d-inline-block align-top">
    <h4 style="color: white; margin-right: 550px">Employee Portal</h4>
</nav>
<div class="container" style="height: 500px">
		<h3 style="margin-top: 30px; font-family: cursive; color: blue">Employee List</h3>
		<p align="right">
			<button
				onclick="window.location.href = 'showFormForAdd'; return false;"
				class="btn btn-primary">Add Employee</button>
		</p>
		<hr />
		<table border="1" style="border: black" class="table table-striped table-bordered">
			<thead class="thead-dark">
				<tr>
					<th>Full Name</th>
					<th>Email</th>
					<th>Gender</th>
					<th>Hobbies</th>
					<th>Country</th>
					<th>Address</th>
					<th>Actions</th>
				</tr>
			</thead>
			<c:forEach items="${employeeList}" var="e">
				<c:url var="updateLink" value="/employee/displayUpdateForm">
					<c:param name="employeeId" value="${e.id}" />
				</c:url>

				<c:url var="deleteLink" value="/employee/displayDeleteForm">
					<c:param name="employeeId" value="${e.id}" />
				</c:url>
				<tbody>
					<tr class="bg-warning">
						<td>${e.fullname}</td>
						<td>${e.email}</td>
						<td>${e.gender}</td>
						<td>${e.hobbies}</td>
						<td>${e.country}</td>
						<td>${e.address}</td>
						<td><a href="${updateLink}"><button type="button" class="btn btn-success">Update</button></a> | <a
							href="${deleteLink}"
							onclick="if(!(confirm('Are you sure want to delete this Employee permanently?'))) return false">
							<button type="button" class="btn btn-danger">Delete</button></a>
						</td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>
<nav class="navbar navbar-light bg-dark" style="height: 60px; text-align: center">
 <h5 style="color: white">All rights reserved</h5>
</nav>

</body>
</html>