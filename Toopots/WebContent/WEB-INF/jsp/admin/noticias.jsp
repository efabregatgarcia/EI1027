<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<t:paginabasica title="Noticias" panel="noticias">
<jsp:body>

	<t:processFeedback />
	
	<div>
		<h3>Nueva noticia</h3>
		<form:form method="post" modelAttribute="noticia" class="form-horizontal">
			<div class="form-group">
				<form:label path="titulo" class="col-sm-2 control-label">Título</form:label>
				<div class="col-sm-10">
					<form:input path="titulo" class="form-control" maxlength="50"></form:input>
					<form:errors path="titulo" cssClass="error" />
				</div>
			</div>
			
			<div class="form-group">
				<form:label path="subtitulo" class="col-sm-2 control-label">Subtítulo</form:label>
				<div class="col-sm-10">
					<form:input path="subtitulo" class="form-control" maxlength="100"></form:input>
					<form:errors path="subtitulo" cssClass="error" />
					</div>
			</div>
			
			<div class="form-group">
				<form:label path="descripcion" class="col-sm-2 control-label">Cuerpo</form:label>
				<div class="col-sm-10">
					<form:textarea id="wysiwyg" path="descripcion" rows="5" cols="50" maxlength="256" class="form-control"></form:textarea>
					<form:errors path="descripcion" cssClass="error" />
				</div>
			</div>
				
			<div class="form-group">
				<div class="col-smoffset-2 col-sm-10">
					<button class="btn btn-danger" onclick="history.back(-1)"><span class="glyphicon glyphicon-chevron-left"></span> Cancelar</button>
					<button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-ok"></span> Añadir noticia</button>
				</div>
			</div>
		</form:form>
	</div>
	<h3>Listado de noticias</h3>
	<table class="table table-hover">
		<tr>
			<th>ID</th>
			<th>Título</th>
			<th>Subtítulo</th>
			<th>Cuerpo</th>
			<th colspan="2">Acciones</th>			
		</tr>
			<c:forEach items="${noticias}" var="noticia">
				<tr>
					<td>${noticia.id_noticia}</td>
					<td>${noticia.titulo}</td>
					<td>${noticia.subtitulo}</td>
					<td>${fn:substring(noticia.descripcion, 0, 40)}...</td>
					<td><a href="updateNoticia/${noticia.id_noticia}.html" class="btn btn-primary btn-xs"><span class="glyphicon glyphicon-pencil"></span> Editar</a></td>
					<td><a href="deleteNoticia/${noticia.id_noticia}.html" class="btn btn-danger btn-xs" onclick="return confirmDeleteModal(this.href);"><span class="glyphicon glyphicon-trash"></span> Borrar</a></td>
				</tr>
			</c:forEach>
	</table>
</jsp:body>
</t:paginabasica>