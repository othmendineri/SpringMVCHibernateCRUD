<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>New/Edit Facture</title>
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
		<h1>New/Edit Facture</h1>
		<form:form action="saveFacture" method="post" modelAttribute="facture">
			<table>
				<form:hidden path="numFacture" />
				<tr>
					<td>Date:</td>
					<td><form:input path="date" /></td>
				</tr>
				<tr>
					<td>Client:</td>
					<td><form:input path="nomClient" /></td>
				</tr>
				<tr>
					<td>Article:</td>
					<td><form:input path="article" /></td>
				</tr>
				<tr>
					<td>Qte:</td>
					<td><form:input path="qte" /></td>
				</tr>
				<tr>
					<td>Prix(DT):</td>
					<td><form:input path="prix" /></td>
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