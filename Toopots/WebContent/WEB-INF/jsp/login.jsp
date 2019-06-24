<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<t:paginabasica title="Área privada">
<jsp:body>
		<h2>Iniciar sesión</h2>
		<form:form method="post"
				   modelAttribute="user"
				   action="${pageContext.request.contextPath}/login.html"
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
					<button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-log-in"></span> Entrar</button>
				</div>
			</div>
			
		</form:form>
		<hr />
		<p>Todavía no tienes una cuenta? <a class="btn btn-primary" href="${pageContext.request.contextPath}/register.html">Registrate</a></p>
</jsp:body>
</t:paginabasica>