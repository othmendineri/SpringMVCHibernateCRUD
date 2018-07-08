<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Contact</title>
<style>
body {
	background-color: lightblue;
}

h1 {
	color: white;
	text-align: center;
}

table {
	font-family: sienna;
	font-size: 20px;
}
</style>
</head>
<body>
	<div align="center">
		<h1>New/Edit Provider</h1>
		<form:form action="saveProvider" method="post" modelAttribute="provider">
			<table>
				<form:hidden path="id" />
				<tr>
					<td>Name:</td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>Address:</td>
					<td><form:input path="address" /></td>
				</tr>
				<tr>
					<td>Telephone 1:</td>
					<td><form:input path="tel1" /></td>
				</tr>
				<tr>
					<td>Telephone 2:</td>
					<td><form:input path="tel2" /></td>
				</tr>
				<tr>
					<td>Telephone fixe:</td>
					<td><form:input path="telFixe" /></td>
				</tr>
				<tr>
					<td>Fax:</td>
					<td><form:input path="fax" /></td>
				</tr>
				<tr>
					<td>Article:</td>
					<td><form:input path="article" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Save"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>