<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>home</title>
<style>
body {
    background-color: lightblue;
}

h1 {
    color: white;
    text-align: center;
}

p {
    font-family: sienna;
    font-size: 20px;
}
</style>
</head>
<body>
	<h1>Welcome to our website</h1>
	<p>
		<br>
		<a href="http://localhost:8888/SpringMVCHibernateCRUD/employeelist">Liste des employées</a>
		</br>
		<br>	
		<a href="http://localhost:8888/SpringMVCHibernateCRUD/factureslist">Liste de factures</a>
		</br>
		<br>	
		<a href="http://localhost:8888/SpringMVCHibernateCRUD/clientlist">Liste de clients</a>
		</br>
		<br>	
		<a href="http://localhost:8888/SpringMVCHibernateCRUD/providerlist">Liste de fournisseurs</a>
		</br>
	</p>
</body>
</html>