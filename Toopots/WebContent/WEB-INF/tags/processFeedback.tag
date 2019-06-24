<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

	<!-- Dar feedback al usuario si ha ocurrido alguna acción -->

	<!-- FIRSTVISIT: Primera visita al panel de opciones -->
	<c:if test="${param.firstvisit != null}">
		<div class="alert alert-info alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			Utiliza los controles superiores de color azul para acceder a la opción deseada.
		</div>
	</c:if>

	<!-- OK: La acción se ha completado con éxito -->
	<c:if test="${param.ok != null}">
		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			El proceso se ha completado con éxito :)
		</div>
	</c:if>
	
	<!-- ERROR: Ha ocurrido un error al procesar la petición -->
	<c:if test="${param.error != null}">
		<div class="alert alert-danger alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			Ha ocurrido un error al procesar tu petición :(
		</div>
	</c:if>
	
	<!-- CLDTINT: Client Data Integrity, se podria violar las reglas de integridad referencial -->
	<c:if test="${param.cldtint != null}">
		<div class="alert alert-warning alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			Por motivos de seguridad no se  puede eliminar un cliente con reservas en el sistema.<br />
			<strong>Ayuda:</strong> Debes <a href="${pageContext.request.contextPath}/admin/reservas.html">archivar</a> sus reservas antes.
		</div>
	</c:if>

	<!-- ACTDTINT: Activity Data Integrity, se podria violar las reglas de integridad referencial -->
	<c:if test="${param.actdtint != null}">
		<div class="alert alert-warning alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			Por motivos de seguridad no se  puede eliminar una actividad con reservas en el sistema.<br />
			<strong>Ayuda:</strong> Debes <a href="${pageContext.request.contextPath}/admin/reservas.html">archivar</a> sus reservas antes.
		</div>
	</c:if>
	
	<!-- ARCHIVED: La reserva se ha archivado (en el historico) -->
	<c:if test="${param.archived != null}">
		<div class="alert alert-success alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			La reserva se ha archivado con éxito, podrás consultarla en el <a href="${pageContext.request.contextPath}/admin/historico.html">histórico</a>.
		</div>
	</c:if>