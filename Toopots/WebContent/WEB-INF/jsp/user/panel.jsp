<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:paginabasica title="Panel de cliente" panel="princ">
<jsp:body>

	<t:processFeedback />
	
	<div class="row">
		<div class="col-sm-5 col-md-6">
	        <div class="profile-header-container">
	    		<div class="profile-header-img">
	    			<h3>${cliente.login}</h3>
	                <img class="img-circle" src="${pageContext.request.contextPath}/img/profile.png" />
	                <!-- badge -->
	                <div class="rank-label-container">
	                    <span class="label label-default rank-label">${cliente.email}</span>
	                </div>
	            </div>
	        </div>
	    </div>
	    <div class="col-sm-5 col-sm-offset-2 col-md-6 col-md-offset-0">
	    	<h3>Información personal</h3>
	    	<dl class="dl-horizontal">
	    		<dt>Id de usuario</dt> <dd>#${cliente.id_cliente}</dd>
	    		<dt>Login</dt> <dd>${cliente.login}</dd>
	    		<dt>Email</dt> <dd>${cliente.email}</dd>
	    		<c:if test="${cliente.nombre != ''}">
	    			<dt>Nombre completo</dt> <dd>${cliente.apellidos}, ${cliente.nombre}</dd>
	    		</c:if>
	    		<c:if test="${cliente.telefono != 0}">
	    			<dt>Teléfono</dt> <dd>${cliente.telefono}</dd>
	    		</c:if>
	    		<c:if test="${cliente.direccion != ''}">
	    			<dt>Dirección</dt> <dd>${cliente.direccion}</dd>
	    		</c:if>
	    	</dl>
	    </div>
    </div>
</jsp:body>
</t:paginabasica>