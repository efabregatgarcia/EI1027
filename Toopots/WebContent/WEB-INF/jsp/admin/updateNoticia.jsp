<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<t:paginabasica title="Actualizar una noticia">
<jsp:body>
	<div>
		<h3>Actualizar noticia #${noticia.id_noticia}</h3>
		<form:form method="post" modelAttribute="noticia" class="form-horizontal">
			<form:hidden path="id_noticia" readonly="true" />
			<div class="form-group">
				<form:label path="titulo" class="col-sm-2 control-label">Título</form:label>
				<div class="col-sm-10">
					<form:input path="titulo" class="form-control" required="required"></form:input>
					<form:errors path="titulo" cssClass="error" />
				</div>
			</div>
			
			<div class="form-group">
				<form:label path="subtitulo" class="col-sm-2 control-label">Subtítulo</form:label>
				<div class="col-sm-10">
					<form:input path="subtitulo" class="form-control"></form:input>
					<form:errors path="subtitulo" cssClass="error" />
					</div>
			</div>
			
			<div class="form-group">
				<form:label path="descripcion" class="col-sm-2 control-label">Cuerpo</form:label>
				<div class="col-sm-10">
					<form:textarea id="wysiwyg" path="descripcion" rows="5" cols="50" class="form-control"></form:textarea>
					<form:errors path="descripcion" cssClass="error" />
				</div>
			</div>
				
			<div class="form-group">
				<div class="col-smoffset-2 col-sm-10">
					<button class="btn btn-danger" onclick="history.back(-1)"><span class="glyphicon glyphicon-chevron-left"></span> Cancelar</button>
					<button class="btn btn-success" type="submit"><span class="glyphicon glyphicon-ok"></span> Actualizar</button>
				</div>
			</div>
		</form:form>
	</div>
</jsp:body>
</t:paginabasica>