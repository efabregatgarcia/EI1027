<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<t:paginabasica title="Clientes" panel="usuarios">
<jsp:body>

	<t:processFeedback />
	
	<h3>Nuevo cliente</h3>
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
				<button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-ok"></span> Añadir cliente</button>
			</div>
		</div>
	</form:form>
	
	
	<h3>Listado de clientes</h3>
	<table class="table table-hover">
		<tr>
			<th>ID</th>
			<th>Nombre</th>
			<th>Teléfono</th>
			<th>Email</th>
			<th>Login</th>
			<th colspan="2">Acciones</th>
		</tr>
			<c:forEach items="${clientes}" var="cliente">
				<tr>
					<td>${cliente.id_cliente}</td>
					<td>${cliente.apellidos}, ${cliente.nombre}<span class="AdminRowSubtitle">Dirección: ${cliente.direccion}</span></td>
					<td>${cliente.telefono}</td>
					<td>${cliente.email}</td>
					<td>${cliente.login}</td>
					<td><a href="updateCliente/${cliente.id_cliente}.html" class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-pencil"></span> Editar</a></td>
					<td><a href="deleteCliente/${cliente.id_cliente}.html" class="btn btn-danger btn-xs" onclick="return confirmDeleteModal(this.href);"><span class="glyphicon glyphicon-trash"></span> Borrar</a></td>
				</tr>
			</c:forEach>
	</table>
</jsp:body>
</t:paginabasica>