<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:paginabasica title="Área administrativa">
<jsp:body>
		<h2>Iniciar sesión como empleado</h2>
		<form:form method="post"
				   modelAttribute="user"
				   action="${pageContext.request.contextPath}/admin-login.html"
				   class="form-horizontal">
			
			<div class="form-group">
				<form:label path="username" class="col-sm-2 control-label">Usuario</form:label>
				<div class="col-sm-10">
					<form:input path="username" id="inputUsername" class="form-control" placeholder="Introduce tu nombre de usuario" required="required" autofocus="autofocus"/>
					<form:errors path="username" cssClass="error" />
				</div>
			</div>
			
			<div class="form-group">
				<form:label path="username" class="col-sm-2 control-label">Contraseña</form:label>
				<div class="col-sm-10">
					<form:password path="password" id="inputPassword" class="form-control" placeholder="Introduce tu contraseña" required="required"/>
					<form:errors path="password" cssClass="error" />
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-smoffset-2 col-sm-10">
					<div class="checkbox">
						<label>
							<input type="checkbox" value="remember-me"> Recordarme
						</label>
					</div>
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-smoffset-2 col-sm-10">
					<button class="btn btn-default" type="submit">Entrar</button>
				</div>
			</div>
			
		</form:form>
</jsp:body>
</t:paginabasica>