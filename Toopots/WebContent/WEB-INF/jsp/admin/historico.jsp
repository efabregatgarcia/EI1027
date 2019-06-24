<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:paginabasica title="Historico" panel="historico">
<jsp:body>

	<t:processFeedback />
	
	<h1>Listado de historicos</h1>
	<table class="table table-hover">
		<tr>
			<th>ID Reserva</th>
			<th>ID Actividad</th>
			<th>ID Cliente</th>
			<th>Hora de inicio</th>
			<th>Estado</th>
			<th>Participantes</th>
			<th>Fecha reserva</th>
			<th>Fecha actividad</th>
			<th>Fecha cierre</th>
			<th>Acciones</th>
		</tr>
			<c:forEach items="${historicos}" var="historico">
				<tr>
					<td>${historico.id_reserva}</td>
					<td>${historico.id_actividad}</td>
					<td>${historico.id_cliente}</td>
					<td>${historico.horaInicio}</td>
					<td>${historico.estado}</td>
					<td>${historico.numParticip}</td>
					<td>${historico.fechaReserva}</td>
					<td>${historico.fechaActividad}</td>
					<td>${historico.fechaCierre}</td>
					<td><a href="deleteHistorico/${historico.id_reserva}.html" class="btn btn-danger btn-xs" onclick="return confirmDeleteModal(this.href);"><span class="glyphicon glyphicon-trash"></span> Borrar</a></td>
				</tr>
			</c:forEach>
	</table>
</jsp:body>
</t:paginabasica>