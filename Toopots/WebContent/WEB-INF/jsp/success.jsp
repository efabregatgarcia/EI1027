<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:paginabasica title="Registro completado">
<jsp:body>
<h2>Registro completado</h2>
<p>Enhorabuena <strong>${cliente.login}</strong>, ha completado el proceso de registro con éxito.</p>
<p>En breve recibirá un correo electrónico con información sobre su cuenta de cliente en NaturAdventure.</p>
<p>Bienvenido, ya puede <a class="btn btn-success btn-sm" href="${pageContext.request.contextPath}/login.html">Entrar</a> a su panel de control.</p>
</jsp:body>
</t:paginabasica>