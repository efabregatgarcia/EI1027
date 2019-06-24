<%@ tag description="Estructura de una pagina basica"
		pageEncoding="ISO-8859-1" %>
<%@ attribute name="title" required="false" %>
<%@ attribute name="selected" required="false" %>
<%@ attribute name="panel" required="false" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="ISO-8859-1">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<title>${title}</title>
	
	<!-- Bootstrap -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
	<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
		  
	<!-- Estilos propios -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/clndr.css">
	
	<!-- Fuentes importadas -->
	<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
	<link href='http://fonts.googleapis.com/css?family=Indie+Flower' rel='stylesheet' type='text/css'>
	
	<!-- Javascript -->
	<script src="${pageContext.request.contextPath}/js/less.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/underscore.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/moment.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/clndr.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/confirm.js"></script>	
	<script src="${pageContext.request.contextPath}/js/custom.js"></script>	
</head>
<body>
	<div id="bodyContainer">
	    <div class="container">
			<header class="container">
				<img class="logo pull-left" src="${pageContext.request.contextPath}/img/logo.png" />
				<h1 class="pull-left">NaturAdventure<span class="subh">Deportes de aventura</span></h1>				
			</header>
			<t:navegacion selected="${selected}" panel="${panel}" />
			<div class="panel panel-default">
				<div class="panel-heading">${title}</div>
				<div class="panel-body">
					<jsp:doBody/>
				</div>
			</div>
						
			<footer>
				<div class="col-md-4 col-sm-4">
					<a href="${pageContext.request.contextPath}">
						<img width="62px" alt="NaturAdventure" src="${pageContext.request.contextPath}/img/logo.png" />
					</a>
				</div>
				<div class="col-md-4 col-sm-4">
					<p class="text-muted">Copyright © 2015 <a href="${pageContext.request.contextPath}/contact.html">NaturAdventure</a></p>
				</div>
				<div class="col-md-4 col-sm-4">
					<a href="${pageContext.request.contextPath}/admin-login.html"><span class="glyphicon glyphicon-lock"></span> Administración</a>
				</div>
			</footer>
		</div>
	</div>
</body>
</html>