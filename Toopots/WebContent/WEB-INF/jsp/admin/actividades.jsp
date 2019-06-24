<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<t:paginabasica title="Actividades" panel="actividades">
<jsp:body>

	<t:processFeedback />
	
	<h3>Nueva actividad</h3>
	<form:form method="post" modelAttribute="actividad" class="form-horizontal">
		<div class="form-group">
			<form:label path="nombre" class="col-sm-2 control-label">Nombre</form:label>
			<div class="col-sm-10">
				<form:input path="nombre" class="form-control" maxlength="60"></form:input>
				<form:errors path="nombre" cssClass="error" />
			</div>
		</div>

		<div class="form-group">
			<form:label path="descripcion" class="col-sm-2 control-label">Descripción</form:label>
			<div class="col-sm-10">
				<form:input path="descripcion" class="form-control" maxlength="255"></form:input>
				<form:errors path="descripcion" cssClass="error" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="id_tipo" class="col-sm-2 control-label">Tipo</form:label>
			<div class="col-sm-10">
				<form:select path="id_tipo" class="form-control">
					<form:option value="NONE" label="-- Selecciona un tipo --"/>
					<c:forEach items="${tipos}" var="tipo">
						<form:option value="${tipo.id_tipo}">${fn:substring(tipo.descripcion, 0, 40)}</form:option>
					</c:forEach>
				</form:select>
				<form:errors path="descripcion" cssClass="error" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="duracionHoras" class="col-sm-2 control-label">Duración (horas)</form:label>
			<div class="col-sm-10">
				<form:input path="duracionHoras" class="form-control" type="number" min="0"></form:input>
				<form:errors path="duracionHoras" cssClass="error" />
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="nivel" class="col-sm-2 control-label">Nivel</form:label>
			<div class="col-sm-10">
				<form:select path="nivel" class="form-control">
					<form:option value="iniciacion" label="Iniciación" />
					<form:option value="medio" label="Medio" />
					<form:option value="experto" label="Experto" />
				</form:select>
			</div>
		 </div>
		 
		 <div class="form-group">
			<form:label path="precioPorPersona" class="col-sm-2 control-label">Precio (por persona)</form:label>
			<div class="col-sm-10">
				<form:input class="form-control" path="precioPorPersona" type="number" min="0"></form:input>
				<form:errors path="precioPorPersona" cssClass="error" />
				</div>
		</div>
		
		<div class="form-group">
			<form:label path="minParticipantes" class="col-sm-2 control-label">Mínimo de participantes</form:label>
			<div class="col-sm-10">
				<form:input class="form-control" path="minParticipantes" type="number" min="0"></form:input>
				<form:errors path="minParticipantes" cssClass="error" />
				</div>
		</div>
		
		<div class="form-group">
			<form:label path="maxParticipantes" class="col-sm-2 control-label">Máximo de participantes</form:label>
			<div class="col-sm-10">
				<form:input class="form-control" path="maxParticipantes" type="number" min="0"></form:input>
				<form:errors path="maxParticipantes" cssClass="error" />
				</div>
		</div>
		
		<div class="form-group">
			<div class="col-smoffset-2 col-sm-10">
				<button class="btn btn-danger" onclick="history.back(-1)"><span class="glyphicon glyphicon-chevron-left"></span> Cancelar</button>
				<button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-ok"></span> Añadir actividad</button>
			</div>
		</div>
	</form:form>
	
	
	<h3>Listado de actividades</h3>
	<table class="table table-hover">
		<tr>
			<th>Nombre</th>
			<th>Descripción</th>
			<th>Duración (horas)</th>
			<th>Nivel</th>
			<th>Precio (por persona)</th>
			<th>Participantes (min-max)</th>
			<th colspan="2">Acciones</th>
		</tr>
			<c:forEach items="${actividades}" var="actividad">
				<tr>
					<td>${actividad.nombre}</td>
					<td>${actividad.descripcion}</td>
					<td>${actividad.duracionHoras}</td>
					<td>${actividad.nivel}</td>
					<td>${actividad.precioPorPersona}</td>
					<td>${actividad.minParticipantes} - ${actividad.maxParticipantes}</td>
					<td><a href="updateActividad/${actividad.id_actividad}.html" class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-pencil"></span> Editar</a></td>
					<td><a href="deleteActividad/${actividad.id_actividad}.html" class="btn btn-danger btn-xs" onclick="return confirmDeleteModal(this.href);"><span class="glyphicon glyphicon-trash"></span> Borrar</a></td>
					
				</tr>
			</c:forEach>
	</table>
</jsp:body>
</t:paginabasica>