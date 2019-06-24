<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:paginabasica title="Noticias" selected="noti">
<jsp:body>
		<c:forEach items="${noticias}" var="noticia">
		
			<div class="panel noticia">
				<div class="encabezado">
					<div class="container">
						<span class="titNoticia">${noticia.titulo}. </span>
						<span class="subNoticia">${noticia.subtitulo}</span>
					</div>
				</div>
  				<blockquote class="noticiaEscalado">
  					<p class="text-justify">${noticia.descripcion}</p>
					<footer class="noticiaFecha">Fecha de publicación: <cite>${noticia.fecha}</cite></footer>
				</blockquote>
			</div>
			<hr />
		</c:forEach>
</jsp:body>
</t:paginabasica>