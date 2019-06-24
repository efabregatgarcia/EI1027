<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<t:paginabasica title="Actualizar un cliente">
<jsp:body>
	<div>
		<h3>Actualizar cliente #${cliente.id_cliente}</h3>
		<form:form method="post" modelAttribute="cliente" class="form-horizontal">
		<div class="form-group">
			<form:label path="nombre" class="col-sm-2 control-label">Nombre</form:label>
			<div class="col-sm-10">
				<form:input path="nombre" class="form-control" maxlength="60"></form:input>
				<form:errors path="nombre" cssClass="error" />
			</div>
		</div>
		<div class="form-group">
				<form:label path="apellidos" class="col-sm-2 control-label">Apellidos</form:label>
				<div class="col-sm-10">
					<form:input path="apellidos" class="form-control" maxlength="120"></form:input>
					<form:errors path="apellidos" cssClass="error" />
				</div>
		</div>
		<div class="form-group">
			<form:label path="telefono" class="col-sm-2 control-label">Teléfono</form:label>
			<div class="col-sm-10">
				<form:input path="telefono" type="tel" class="form-control" required="required"></form:input>
			</div>
		</div>
		<div class="form-group">
			<form:label path="email" class="col-sm-2 control-label">Email</form:label>
			<div class="col-sm-10">
				<form:input path="email" type="email" class="form-control" maxlength="90"></form:input>
				<form:errors path="email" cssClass="error" />
			</div>
		</div>
		<div class="form-group">
				<form:label path="direccion" class="col-sm-2 control-label">Dirección</form:label>
				<div class="col-sm-10">
					<form:input path="direccion" class="form-control" maxlength="200"></form:input>
					<form:errors path="direccion" cssClass="error" />
				</div>
		</div>
		<div class="form-group">
			<form:label path="login" class="col-sm-2 control-label">Login</form:label>
			<div class="col-sm-10">
				<form:input path="login" class="form-control" maxlength="30"></form:input>
				<form:errors path="login" cssClass="error" />
			</div>
		</div>
		<div class="form-group">
			<form:label path="passwd" class="col-sm-2 control-label">Passwd</form:label>
			<div class="col-sm-10">
				<form:input path="passwd" class="form-control" maxlength="200"></form:input>
				<form:errors path="passwd" cssClass="error" />
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