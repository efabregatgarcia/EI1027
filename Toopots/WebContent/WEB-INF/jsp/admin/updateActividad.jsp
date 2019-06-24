<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<t:paginabasica title="Actualizar una noticia">
<jsp:body>
	<div>
		<h3>Actualizar noticia #${actividad.id_actividad}</h3>
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
				<button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-ok"></span> Actualizar</button>
			</div>
		</div>
	</form:form>
	</div>
</jsp:body>
</t:paginabasica>