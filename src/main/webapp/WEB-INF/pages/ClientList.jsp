<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Client Management Screen</title>
<style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#customers td, #customers th {
    border: 1px solid #ddd;
    padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
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
		<h1>Clients List</h1>

		<table id="customers">

			<th>Name</th>
			<th>Email</th>
			<th>Address</th>
			<th>Telephone 1</th>
			<th>Telephone 2</th>
			<th>Telephone fixe</th>
			<th>Fax</th>
			<th>Facture Number</th>
			<th>Action</th>

			<c:forEach var="client" items="${listClient}">
				<tr>

					<td>${client.name}</td>
					<td>${client.email}</td>
					<td>${client.address}</td>
					<td>${client.tel1}</td>
					<td>${client.tel2}</td>
					<td>${client.telFixe}</td>
					<td>${client.fax}</td>
					<td>${client.numFacture}</td>
					<td><a href="editClient?id=${client.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteClient?id=${client.id}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			New Client Register <a href="newClient">here</a>
		</h4>
	</div>
</body>
</html>