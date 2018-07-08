<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Provider Management Screen</title>
<style>
#providers {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#providers td, #factures th {
	border: 1px solid #ddd;
	padding: 8px;
}

#providers tr:nth-child(even) {
	background-color: #f2f2f2;
}

#providers tr:hover {
	background-color: #ddd;
}

#providers th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}
</style>
</head>
<body>
	<div>
		<h1>Providers List</h1>

		<table id="providers">

			<th>Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Telephone 1</th>
			<th>Telephone 2</th>
			<th>Telephone fixe</th>
			<th>Fax</th>
			<th>Article</th>
			<th>Action</th>

			<c:forEach var="provider" items="${listProvider}">
				<tr>

					<td>${provider.name}</td>
					<td>${provider.email}</td>
					<td>${provider.address}</td>
					<td>${provider.tel1}</td>
					<td>${provider.tel2}</td>
					<td>${provider.telFixe}</td>
					<td>${provider.fax}</td>
					<td>${provider.article}</td>
					<td><a href="editProvider?id=${provider.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteProvider?id=${provider.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			New Provider Register <a href="newProvider">here</a>
		</h4>
	</div>
</body>
</html>