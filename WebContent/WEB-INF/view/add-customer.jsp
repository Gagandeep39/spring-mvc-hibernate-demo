<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
</head>
<body class="container">

	<h2 class="display-3">Add Customer</h2>
	<hr>
	<form:form class="form-group" action="saveCustomer" modelAttribute="customer" method="post">
	<!-- To track the customer being updated, if empty then  new customer -->
	<form:hidden path="id"/>
		First Name: <form:input class="form-control" path="firstName"/>
		<form:errors path="firstName"/>
		Last Name: <form:input class="form-control" path="lastName"/>
		<form:errors path="lastName"/>
		Email: <form:input class="form-control" path="email"/>
		<form:errors path="email"/>
		<input type="submit" class="btn btn-primary" style="margin-top: 16px;" value="Save Customer">
	</form:form>
	<a href="${pageContext.request.contextPath}/customer/list">Back</a>
</body>
</html>