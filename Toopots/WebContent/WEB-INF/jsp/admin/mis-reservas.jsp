<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:paginabasica title="Mis reservas" panel="reservas">
<jsp:body>
	<h2>Listado de reservas</h2>
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
		</tr>
			<c:forEach items="${reservas}" var="reserva">
				<tr>
					<td>${reserva.id_reserva}</td>
					<td>${reserva.id_actividad}</td>
					<td>${reserva.id_cliente}</td>
					<td>${reserva.horaInicio}</td>
					<td>${reserva.estado}</td>
					<td>${reserva.numParticip}</td>
					<td>${reserva.fechaReserva}</td>
					<td>${reserva.fechaActividad}</td>
				</tr>
			</c:forEach>
	</table>
</jsp:body>
</t:paginabasica>