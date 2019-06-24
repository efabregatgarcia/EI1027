<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<t:paginabasica title="Asignar un monitor" panel="reservas">
<jsp:body>

	<!-- Breve descripcion -->
	<c:if test="${param.firstvisit != null}">
		<div class="alert alert-warning" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			AVISO: La reserva se aceptará automáticamente al asignarle un monitor.
		</div>
	</c:if>
	
	<h3>Asignar un monitor</h3>
	<form:form method="post" modelAttribute="monitorReserva" class="form-horizontal">
		<form:hidden path="id_reserva" value="${id_reserva}"></form:hidden>
		
		<div class="form-group">
			<form:label path="id_monitor" class="col-sm-2 control-label">Monitor</form:label>
			<div class="col-sm-10">
				<form:select path="id_monitor" class="form-control" required="required">
					<form:option value="NONE" label="-- Selecciona un monitor --"/>
					<c:forEach items="${monitores}" var="monitor">
						<form:option value="${monitor.id_empleado}">#${monitor.id_empleado} - ${monitor.nombre}</form:option>
					</c:forEach>
				</form:select>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-smoffset-2 col-sm-10">
				<button class="btn btn-danger" onclick="history.back(-1)"><span class="glyphicon glyphicon-chevron-left"></span> Cancelar</button>
				<button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-ok"></span> Asignar</button>
			</div>
		</div>
	</form:form>

</jsp:body>
</t:paginabasica>