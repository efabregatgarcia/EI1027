<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:paginabasica title="Actualizar perfil" panel="perfil">
<jsp:body>
	
	<t:processFeedback />

	<form:form method="post" modelAttribute="empleado" class="form-horizontal">
		<form:hidden path="id_empleado" />
		<form:hidden path="grupo" />
		<div class="form-group">
			<form:label path="nombre" class="col-sm-2 control-label">Nombre</form:label>
			<div class="col-sm-10">
				<form:input path="nombre" class="form-control" maxlength="60"></form:input>
			</div>
		</div>
		
		<div class="form-group">
			<form:label path="email" class="col-sm-2 control-label">Email</form:label>
			<div class="col-sm-10">
				<form:input path="email" type="email" class="form-control" readonly="true"></form:input>
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