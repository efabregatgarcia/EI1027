<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:paginabasica title="Listado de actividades" selected="acti">
<jsp:body>
	<div style="text-center">
		<c:forEach items="${actividades}" var="actividad">
			<div class="actividad">
				<div class="panel panel-success">
					<div class="panel-body">
						<h3 class="title">${actividad.nombre} (${actividad.duracionHoras} horas)</h3>
						<p class="descripcion text-justify">${actividad.descripcion}</p>
						<span class="dificultad ${actividad.nivel}"><span class="glyphicon glyphicon-fire"></span> Dificultad: <strong>${actividad.nivel}</strong></span>
					</div>
					<a class="btn btn-success reservar" href="${pageContext.request.contextPath}/user/reservar/${actividad.id_actividad}.html"><span class="glyphicon glyphicon-ok"></span> Reservar <strong>${actividad.precioPorPersona}&euro;/p</strong></a>
				</div>
			</div>
		</c:forEach>
	</div>
</jsp:body>
</t:paginabasica>