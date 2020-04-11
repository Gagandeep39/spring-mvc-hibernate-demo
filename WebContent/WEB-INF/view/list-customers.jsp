<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customer</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
</head>
<body>
	<h2 class="display-3">List of Customers</h2>
	<hr>
	<div class="container">
	
	<button class="btn btn-primary" style="margin-bottom: 20px;" onclick="window.location.href='addCustomer'">Add Customer</button>
		<table class="table table-hover table-striped table-bordered">
			<thead>
			<tr>
				<td>First Name</td>
				<td>Last Name</td>
				<td>Email</td>
				<td>Action</td>
			</tr>
			</thead>
			<c:forEach var="tempCustomer" items="${customers}">
			<c:url var="updateLink" value="/customer/showFormForUpdate">
				<c:param name="customerId" value="${tempCustomer.id}" />
			</c:url>
			<c:url var="deleteLink" value="/customer/deleteCustomer">
				<c:param name="customerId" value="${tempCustomer.id}" />
			</c:url>
				<tr>
					<td>${tempCustomer.firstName }</td>
					<td>${tempCustomer.lastName}</td>
					<td>${tempCustomer.email }</td>
					<td> <a href="${updateLink}">Update</a> | <a href="${deleteLink}" onclick="if(!confirm('Are you sure you want to delete the customer?')) return false;">Delete</a> </td>
					<!-- If cancel is pressed in alert then do nothing -->
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>