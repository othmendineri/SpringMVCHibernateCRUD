<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Facture Management Screen</title>
<style>
#factures {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    border-collapse: collapse;
    width: 100%;
}

#factures td, #factures th {
    border: 1px solid #ddd;
    padding: 8px;
}

#factures tr:nth-child(even){background-color: #f2f2f2;}

#factures tr:hover {background-color: #ddd;}

#factures th {
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
		<h1>Liste de Factures</h1>
		
		<table id="factures">

			<th>Num_Facture</th>
			<th>Date</th>
			<th>Client</th>
			<th>Article</th>
			<th>Qte</th>
			<th>Prix(DT)</th>
			<th>Action</th>

			<c:forEach var="facture" items="${listFacture}">
				<tr>

					<td>${facture.numFacture}</td>
					<td>${facture.date}</td>
					<td>${facture.nomClient}</td>
					<td>${facture.article}</td>
					<td>${facture.qte}</td>
					<td>${facture.prix}</td>
					<td><a href="editFacture?numFacture=${facture.numFacture}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="deleteFacture?numFacture=${facture.numFacture}">Delete</a></td>

				</tr>
			</c:forEach>
		</table>
		<h4>
			New Facture Register <a href="newFacture">here</a>
		</h4>
	</div>
</body>
</html>