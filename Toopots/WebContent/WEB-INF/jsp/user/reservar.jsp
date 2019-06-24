<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:paginabasica title="Añadir una reserva">
<jsp:body>
	<h3>Actividad: ${actividad.nombre}</h3>
	<form:form  method="post"
				modelAttribute="reserva"
				action="${pageContext.request.contextPath}/user/reservar.html"
				oninput="valorRango.value=numParticip.value"
				class="form-horizontal">
		<form:hidden path="id_actividad" value="${actividad.id_actividad}"/>
		<form:hidden path="id_cliente" value="${id_cliente}"/>
		
		<div class="form-group">
			<form:label path="horaInicio" class="col-sm-2 control-label">Hora de inicio</form:label>
			<div class="col-sm-10">
				<form:select path="horaInicio" class="form-control">
					<form:option value="manana">Mañana (06:00 - 14:00)</form:option>
					<form:option value="tarde">Tarde (14:00 - 20:00)</form:option>
					<form:option value="noche">Noche (20:00 - 00:00)</form:option>
				</form:select>
			</div>
		</div>
		<form:hidden path="estado" value="pendiente" />
		
		<div class="form-group">
			<form:label path="numParticip" class="col-sm-2 control-label">Participantes</form:label>
			<div class="col-sm-10">
				<form:input type="range" path="numParticip"
							min="${actividad.minParticipantes}"
							max="${actividad.maxParticipantes}"
							value="${actividad.minParticipantes}"
							step="1"
							onchange="updateTextInput(valorRango,this.value);"></form:input>
				<span class="form-range-value"><output name="valorRango" id="valorRango" for="numParticip">${actividad.minParticipantes}</output> personas</span>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-sm-2" style="text-align: right;"><strong>Precio por persona</strong></div>
			<div class="col-sm-10">
				<span id="precioPorPersona">${actividad.precioPorPersona} &#8364;</span>
			</div>
		</div>
		
		<div class="form-group">
			<form:label class="col-sm-2 control-label" path="fechaActividad">Fecha actividad</form:label>
			<div class="col-sm-10">
				<form:input path="fechaActividad" type="date" class="form-control" min="${fechaHoy}" required="required"></form:input>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-smoffset-2 col-sm-10">
				<button class="btn btn-danger" onclick="history.back(-1)"><span class="glyphicon glyphicon-chevron-left"></span> Cancelar</button>
				<button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-ok"></span> Reservar</button>
			</div>
		</div>
	</form:form>
</jsp:body>
</t:paginabasica>