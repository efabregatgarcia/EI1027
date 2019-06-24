<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:paginabasica title="Mis reservas" panel="reservas">
<jsp:body>
	<c:choose>
		<c:when test="${empty reservas}">
			<div class="alert alert-warning alert-dismissible" role="alert">
				<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				No tienes ninguna reserva para mostrar.
			</div>
		</c:when>
		<c:otherwise>
			<table class="table">
				<tr>
					<th>ID Reserva</th>
					<th>ID Actividad</th>
					<th>Hora de inicio</th>
					<th>Estado</th>
					<th>Participantes</th>
					<th>Fecha reserva</th>
					<th>Fecha actividad</th>
				</tr>
					<c:forEach items="${reservas}" var="reserva">
						<tr>
							<td>${reserva.id_reserva}</td>
							<td>${reserva.id_actividad}</td>
							<td>${reserva.horaInicio}</td>
							<td>${reserva.estado}</td>
							<td>${reserva.numParticip}</td>
							<td>${reserva.fechaReserva}</td>
							<td>${reserva.fechaActividad}</td>
						</tr>
					</c:forEach>
			</table>
		</c:otherwise>
	</c:choose>


</jsp:body>
</t:paginabasica>