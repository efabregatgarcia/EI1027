<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<t:paginabasica title="Reservas" panel="reservas">
<jsp:body>

	<t:processFeedback />

	<h2>Listado de reservas</h2>
	<table class="table">
		<tr>
			<th>ID Actividad</th>
			<th>ID Cliente</th>
			<th>Horario</th>
			<th>Estado</th>
			<th>Particip.</th>
			<th>Fecha reserva</th>
			<th>Fecha actividad</th>
			<th colspan="3">Acciones</th>
		</tr>
			<c:forEach items="${reservas}" var="reserva">
				<tr>
					<td>${reserva.id_actividad}</td>
					<td>${reserva.id_cliente}</td>
					<td>${reserva.horaInicio}</td>
					<td>${reserva.estado}</td>
					<td>${reserva.numParticip}</td>
					<td>${reserva.fechaReserva}</td>
					<td>${reserva.fechaActividad}</td>
					<c:if test="${reserva.estado == 'aceptada'}">
						<td><a href="archivarReserva/${reserva.id_reserva}.html" class="btn btn-warning btn-xs" onclick="return confirmArchiveModal(this.href);"><span class="glyphicon glyphicon-share-alt"></span> Archivar</a></td> 
					</c:if>
					<c:if test="${reserva.estado != 'aceptada'}"><td></td></c:if>
					<c:if test="${reserva.estado == 'pendiente'}">
						<td><a href="asignarMonitor/${reserva.id_reserva}.html" class="btn btn-success btn-xs"><span class="glyphicon glyphicon-ok"></span> Asignar monitor</a></td>
						<td><a href="rechazarReserva/${reserva.id_reserva}.html" class="btn btn-danger btn-xs" onclick="return confirmRefuseModal(this.href);"><span class="glyphicon glyphicon-remove"></span> Rechazar</a></td>
					</c:if>
					<c:if test="${reserva.estado == 'aceptada'}"><td></td><td></td></c:if>
					<c:if test="${reserva.estado == 'rechazada'}"><td></td><td></td><td></td></c:if>
				</tr>
			</c:forEach>
	</table>
</jsp:body>
</t:paginabasica>