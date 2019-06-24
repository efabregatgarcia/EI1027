<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="panel" required="false" %>
<!-- La sesion esta disponible en el objeto "session" -->
<c:set var="user" scope="request" value='${session.getAttribute("user")}' />
<c:set var="grupo" scope="request" value='${session.getAttribute("grupo")}' />
<div class="nav" style="padding: 8px;">
<c:choose>
	<c:when test='${user == null}'>
		<div class="pull-right">
			No autenticado
			<a class="btn btn-success btn-sm" href="${pageContext.request.contextPath}/login.html"><span class="glyphicon glyphicon-log-in"></span> Entra</a>
			o
			<a class="btn btn-primary btn-sm" href="${pageContext.request.contextPath}/register.html">Registrate</a>
		</div>
	</c:when>
	<c:otherwise>
		<div class="btn-group">
		<c:choose>
			<c:when test='${grupo == "cliente"}'>
				<a class="btn btn-primary btn-sm <c:if test="${panel == 'princ'}">selected</c:if>" href="${pageContext.request.contextPath}/user/panel.html"><span class="glyphicon glyphicon-dashboard"></span> Panel principal</a>
				<a class="btn btn-primary btn-sm <c:if test="${panel == 'perfil'}">selected</c:if>" href="${pageContext.request.contextPath}/user/mi-perfil.html"><span class="glyphicon glyphicon-user"></span> Mi perfil</a>
				<a class="btn btn-primary btn-sm <c:if test="${panel == 'reservas'}">selected</c:if>" href="${pageContext.request.contextPath}/user/mis-reservas.html"><span class="glyphicon glyphicon-tasks"></span> Mis reservas</a>
			</c:when>
			<c:when test='${grupo == "monitor"}'>
				<a class="btn btn-primary btn-sm <c:if test="${panel == 'princ'}">selected</c:if>" href="${pageContext.request.contextPath}/admin.html"><span class="glyphicon glyphicon-dashboard"></span> Panel principal</a>
				<a class="btn btn-primary btn-sm <c:if test="${panel == 'perfil'}">selected</c:if>" href="${pageContext.request.contextPath}/admin/mi-perfil.html"><span class="glyphicon glyphicon-user"></span> Mi perfil</a>
				<a class="btn btn-primary btn-sm <c:if test="${panel == 'reservas'}">selected</c:if>" href="${pageContext.request.contextPath}/admin/mis-reservas.html"><span class="glyphicon glyphicon-tasks"></span> Mis reservas</a>
				<a class="btn btn-primary btn-sm <c:if test="${panel == 'calendario'}">selected</c:if>" href="${pageContext.request.contextPath}/admin/mi-calendario.html"><span class="glyphicon glyphicon-calendar"></span> Mi calendario</a>
			</c:when>
			<c:when test='${grupo == "gerente"}'>
				<a class="btn btn-primary btn-sm <c:if test="${panel == 'princ'}">selected</c:if>" href="${pageContext.request.contextPath}/admin.html"><span class="glyphicon glyphicon-dashboard"></span> Panel principal</a>
				<a class="btn btn-primary btn-sm <c:if test="${panel == 'noticias'}">selected</c:if>" href="${pageContext.request.contextPath}/admin/noticias.html"><span class="glyphicon glyphicon-list-alt"></span> Noticias</a>
				<div class="btn-group">
					<button type="button" class="btn btn-primary btn-sm dropdown-toggle <c:if test="${panel == 'usuarios'}">selected</c:if>" data-toggle="dropdown">
				    Usuarios <span class="caret"></span></button>
				    <ul class="dropdown-menu" role="menu">
				    	<li><a href="${pageContext.request.contextPath}/admin/clientes.html"><span class="glyphicon glyphicon-user"></span> Clientes</a></li>
						<li><a href="${pageContext.request.contextPath}/admin/empleados.html"><span class="glyphicon glyphicon-pawn"></span> Empleados</a></li>
				    </ul>
				</div>
				<a class="btn btn-primary btn-sm <c:if test="${panel == 'actividades'}">selected</c:if>" href="${pageContext.request.contextPath}/admin/actividades.html"><span class="glyphicon glyphicon-tent"></span> Actividades</a>
				<a class="btn btn-primary btn-sm <c:if test="${panel == 'reservas'}">selected</c:if>" href="${pageContext.request.contextPath}/admin/reservas.html"><span class="glyphicon glyphicon-tasks"></span> Reservas</a>
				<a class="btn btn-primary btn-sm <c:if test="${panel == 'historico'}">selected</c:if>" href="${pageContext.request.contextPath}/admin/historico.html"><span class="glyphicon glyphicon-floppy-disk"></span> Historico</a>
			</c:when>
		</c:choose>
		</div>
		<div class="pull-right">
			Autenticado como <strong>${user.username}</strong>
			<a class="btn btn-danger btn-sm" href="${pageContext.request.contextPath}/logout.html"><span class="glyphicon glyphicon-off"></span> Salir</a>
		</div>
	</c:otherwise>
</c:choose>
</div>