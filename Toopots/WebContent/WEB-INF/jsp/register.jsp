<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:paginabasica title="Área privada">
<jsp:body>
		<h2>Registro de cliente</h2>
		<form:form method="post"
				   modelAttribute="cliente"
				   action="${pageContext.request.contextPath}/register.html"
				   class="form-horizontal">

			
			<div class="form-group">
				<form:label path="email" class="col-sm-2 control-label">E-mail</form:label>
				<div class="col-sm-10">
					<form:input maxlength="90" type="email" path="email" id="inputemail" class="form-control" placeholder="Introduzca su email" required="required"/>
					<form:errors path="email" cssClass="error" />
				</div>
			</div>
			
			<div class="form-group">
				<form:label path="login" class="col-sm-2 control-label">Usuario</form:label>
				<div class="col-sm-10">
					<form:input maxlength="30" path="login" id="inputLogin" class="form-control" placeholder="Introduzca su nombre de usuario" required="required"/>
					<form:errors path="login" cssClass="error" />
				</div>
			</div>
			
			<div class="form-group">
				<form:label path="passwd" class="col-sm-2 control-label">Contraseña</form:label>
				<div class="col-sm-10">
					<form:password maxlength="50" path="passwd" id="inputPasswd" class="form-control" placeholder="Introduzca su contraseña" required="required"/>
					<form:errors path="passwd" cssClass="error" />
				</div>
			</div>
			
			<div class="form-group">
				<form:label path="passwd2" class="col-sm-2 control-label">Repite la contraseña</form:label>
				<div class="col-sm-10">
					<form:password maxlength="50" path="passwd2" id="inputPasswd2" class="form-control" placeholder="Por favor, repita la contraseña" required="required"/>
					<form:errors path="passwd2" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<div class="col-smoffset-2 col-sm-10">
					<button class="btn btn-default" type="submit">Completar registro</button>
				</div>
			</div>
			
		</form:form>
</jsp:body>
</t:paginabasica>