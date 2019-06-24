<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ attribute name="selected" required="false" %>
<%@ attribute name="panel" required="false" %>

<!-- Menu de navegacion -->
<nav class="navbar navbar-default" style="margin-bottom: 6px;">
	<div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            </button>
        </div>
		<div id="navbar" class="navbar-collapse collapse menuPrincipal">
			<ul class="nav navbar-nav">
				<li <c:if test="${selected == 'ini'}">class="active"</c:if>><a href="${pageContext.request.contextPath}">Inicio</a></li>
				<li <c:if test="${selected == 'noti'}">class="active"</c:if>><a href="${pageContext.request.contextPath}/noticias.html">Noticias</a></li>
				<li <c:if test="${selected == 'acti'}">class="active"</c:if>><a href="${pageContext.request.contextPath}/actividades.html">Reserva de actividades</a></li>
				<li <c:if test="${selected == 'about'}">class="active"</c:if>><a href="${pageContext.request.contextPath}/about.html">Quiénes somos</a></li>
				<li <c:if test="${selected == 'cont'}">class="active"</c:if>><a href="${pageContext.request.contextPath}/contact.html">Contacto</a></li>
			</ul>
		</div>
	</div>
</nav>
<t:logininfo panel="${panel}" />