<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:paginabasica title="Actualizar perfil" panel="perfil">
<jsp:body>
	
	<t:processFeedback />

	<form:form method="post" modelAttribute="cliente" class="form-horizontal">
		<form:hidden path="id_cliente" />
		<div class="form-group">
			<form:label path="nombre" class="col-sm-2 control-label">Nombre</form:label>
			<div class="col-sm-10">
				<form:input path="nombre" class="form-control" maxlength="60"></form:input>
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="apellidos" class="col-sm-2 control-label">Apellidos</form:label>
			<div class="col-sm-10">
				<form:input path="apellidos" class="form-control" maxlength="120"></form:input>
			</div>
		</div>

		<div class="form-group">
			<form:label path="telefono" class="col-sm-2 control-label">Teléfono</form:label>
			<div class="col-sm-10">
				<form:input path="telefono" type="tel" class="form-control"></form:input>
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="email" class="col-sm-2 control-label">Email</form:label>
			<div class="col-sm-10">
				<form:input path="email" type="email" class="form-control" readonly="true"></form:input>
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="direccion" class="col-sm-2 control-label">Direccion</form:label>
			<div class="col-sm-10">
				<form:input maxlength="200" path="direccion" class="form-control"></form:input>
			</div>
		</div>
		
		<div class="form-group">
			<div class="col-smoffset-2 col-sm-10">
				<button class="btn btn-danger" onclick="history.back(-1)"><span class="glyphicon glyphicon-chevron-left"></span> Cancelar</button>
				<button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-ok"></span> Actualizar</button>
			</div>
		</div>

	</form:form>
</jsp:body>
</t:paginabasica>