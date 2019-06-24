<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:paginabasica title="NaturAdventure - Deportes de aventura" selected="ini">
<jsp:body>

	<!-- Diapositivas automaticas -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
	    <!-- Carousel indicators -->
	    <ol class="carousel-indicators">
	        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
	        <li data-target="#myCarousel" data-slide-to="1"></li>
	        <li data-target="#myCarousel" data-slide-to="2"></li>
	    </ol>   
	    <!-- Wrapper for carousel items -->
	    <div class="carousel-inner">
	        <div class="item active">
	            <img src="${pageContext.request.contextPath}/img/slides/slide_1.jpg" alt="">
	        	<div class="carousel-caption">
	        		<h2>Deportes de aventura</h2>
	        	</div>
	        </div>
	        <div class="item">
	            <img src="${pageContext.request.contextPath}/img/slides/slide_2.jpg" alt="">
	        	<div class="carousel-caption">
	        		<h2>Aventuras al aire libre</h2>
	        	</div>
	        </div>
	        <div class="item">
	            <img src="${pageContext.request.contextPath}/img/slides/slide_3.jpg" alt="">
	        	<div class="carousel-caption">
	        		<h2>Actividades acuáticas</h2>
	        	</div>
	        </div>
	    </div>
	    <!-- Carousel controls -->
	    <a class="carousel-control left" href="#myCarousel" data-slide="prev">
	        <span class="glyphicon glyphicon-chevron-left"></span>
	    </a>
	    <a class="carousel-control right" href="#myCarousel" data-slide="next">
	        <span class="glyphicon glyphicon-chevron-right"></span>
	    </a>
	</div>
	
	<!-- Que servicios ofrecemos -->
	<div class="container-fluid">
	    <div class="row">
	        <h3 class="text-center text-primary">¿Que servicios ofrecemos?</h3>
	    	<div class="col-lg-12">
				<blockquote class="blockquote-reverse">
				  <p>NaturAdventure nació como un grupo de amigos aficionados a los deportes de aventura. Hoy ofrecemos actividades de todo tipo a precios económicos, con personal altamente formado y total seguridad.</p>
				  <footer>Juan Nadie, Presidente de NaturAdventure</footer>
				</blockquote>
			</div><!--/.col-->	
		</div><!--/.row-->
	</div>
	
	<!-- Testimonios de nuestros clientes -->
	<div class="container-fluid">
	    <div class="row">
	        <h3 class="text-center text-primary">¿Que opinan nuestros clientes?</h3>
	    	<div class="col-md-10 col-md-offset-1">
				<div class="row testimonials">
					<div class="col-sm-4">
						<blockquote>
							<p class="clients-words">Un servicio impecable con precios muy ajustados, cero problemas y mucha diversión.</p>
							<span class="clients-name text-primary">- Daniel Rincón</span>
							<img class="img-circle img-thumbnail" src="http://lorempixel.com/400/400/people/1/">
						</blockquote>
					</div>
					<div class="col-sm-4">
						<blockquote>
							<p class="clients-words">Se encargan de todo para que puedas relajarte y pasar un rato muy divertido.</p>
							<span class="clients-name text-primary">- María Lopez</span>
							<img class="img-circle img-thumbnail" src="http://lorempixel.com/400/400/people/5/">
						</blockquote>
					</div>
					<div class="col-sm-4">
						<blockquote>
							<p  class="clients-words">Un servicio excelente, los monitores son profesionales y están muy bien formados</p>
							<span class="clients-name text-primary">- Agustín y Paloma</span>
							<img class="img-circle img-thumbnail" src="http://lorempixel.com/400/400/people/4/">
						</blockquote>
					</div>
				</div><!--/.row-->
			</div><!--/.col-->	
		</div><!--/.row-->
	</div>
	
	<!-- Redes sociales -->
	<div class="container-fluid">
	    <div class="row text-center">
	        <h3 class="text-center text-primary">Síguenos en las redes sociales</h3>
	    	<div class="row socialButtons">
	    	    <div class="col-xs-4">
			        <a class="btn btn-lg btn-block btn-facebook" title="Síguenos en Facebook !">
				        <i class="fa fa-facebook"></i>
				        <span class="hidden-xs">Facebook</span>
			        </a>
		        </div>
	        	<div class="col-xs-4">
			        <a class="btn btn-lg btn-block btn-twitter" title="Síguenos en Twitter !">
				        <i class="fa fa-twitter"></i>
				        <span class="hidden-xs">Twitter</span>
			        </a>
		        </div>	
	        	<div class="col-xs-4">
			        <a class="btn btn-lg btn-block btn-google" title="Síguenos en Google+ !">
				        <i class="fa fa-google"></i>
				        <span class="hidden-xs">Google+</span>
			        </a>
		        </div>	
			</div>
		</div>
	</div>
</jsp:body>
</t:paginabasica>