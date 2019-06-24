<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:paginabasica title="Administración" panel="princ">
<jsp:body>

	<t:processFeedback />
	
	<div class="row">
		<div class="col-sm-5 col-md-6">
	        <div class="profile-header-container">
	    		<div class="profile-header-img">
	    			<h3>${empleado.login}</h3>
	                <img class="img-circle" src="${pageContext.request.contextPath}/img/profile.png" />
	                <!-- badge -->
	                <div class="rank-label-container">
	                    <span class="label label-default rank-label">${empleado.email}</span>
	                </div>
	            </div>
	        </div>
	    </div>
	    <div class="col-sm-5 col-sm-offset-2 col-md-6 col-md-offset-0">
	    	<h3>Información personal</h3>
	    	<dl class="dl-horizontal">
	    		<dt>Id de empleado</dt> <dd>#${empleado.id_empleado}</dd>
	    		<dt>Login</dt> <dd>${empleado.login}</dd>
	    		<dt>Email</dt> <dd>${empleado.email}</dd>
	    		<c:if test="${empleado.nombre != ''}">
	    			<dt>Nombre</dt> <dd>${empleado.nombre}</dd>
	    		</c:if>
	    	</dl>
	    </div>
    </div>
</jsp:body>
</t:paginabasica>