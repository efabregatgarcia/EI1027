<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<t:paginabasica title="Empleados" panel="usuarios">
<jsp:body>

	<t:processFeedback />
	
	<h3>Nuevo empleado</h3>
	<form:form method="post" modelAttribute="empleado" class="form-horizontal">
		<div class="form-group">
			<form:label path="nombre" class="col-sm-2 control-label">Nombre</form:label>
			<div class="col-sm-10">
				<form:input path="nombre" class="form-control" maxlength="60"></form:input>
				<form:errors path="nombre" cssClass="error" />
				</div>
		</div>
		<div class="form-group">
				<form:label path="grupo" class="col-sm-2 control-label">Grupo</form:label>
				<div class="col-sm-10">
					<form:select path="grupo" class="form-control" required="required">
						<form:option value="" label="-- Selecciona el grupo --"/>
						<form:option value="monitor" label="Monitor"/>
						<form:option value="gerente" label="Gerente"/>
					</form:select>
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
				<button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-ok"></span> Añadir empleado</button>
			</div>
		</div>
	</form:form>
	
	
	<h3>Listado de empleados</h3>
	<table class="table table-hover">
		<tr>
			<th>ID</th>
			<th>Grupo</th>
			<th>nombre</th>
			<th>Email</th>
			<th>Login</th>
			<th>Acciones</th>
		</tr>
			<c:forEach items="${empleados}" var="empleado">
				<tr>
					<td>${empleado.id_empleado}</td>
					<td>${empleado.grupo}</td>
					<td>${empleado.nombre}</td>
					<td>${empleado.email}</td>
					<td>${empleado.login}</td>
					<td><a href="deleteEmpleado/${empleado.id_empleado}.html" class="btn btn-danger btn-xs" onclick="return confirmDeleteModal(this.href);"><span class="glyphicon glyphicon-trash"></span> Borrar</a></td>
				</tr>
			</c:forEach>
	</table>
</jsp:body>
</t:paginabasica>