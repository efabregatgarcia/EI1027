<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:paginabasica title="Contacte con NaturAdventure" selected="cont">
<jsp:body>
	<div class="col-md-7 col-sm-6">
		<h3>Dónde estamos</h3>
		<div id="map">
			<noscript>Debe tener activado JavaScript para ver el mapa.</noscript>
		</div>
		<div class="contact-info">
			<ul>
				<li>Avda. Sos Baynat, 8</li>
				<li>12071, Castellón de la Plana</li>
				<li>Tel: 964 555 555</li>
				<li>Email: <a href="mailto:contact@naturadventure.com">contact@naturadventure.com</a></li>
			</ul>
		</div>
	</div>
	<div class="col-md-5 col-sm-6">
		<h3>Contacta con nosotros</h3>
		<div class="contact-form">
			<form name="contactform" id="contactform" action="#" method="post">
				<p><input class="form-control" name="name" type="text" id="name" placeholder="Nombre"></p>
				<p><input class="form-control" name="email" type="text" id="email" placeholder="e-mail"></p>
				<p><input class="form-control" name="subject" type="text" id="subject" placeholder="Asunto"></p>
				<p><textarea class="form-control" name="message" id="message" placeholder="Mensaje"></textarea></p>
				<input type="submit" class="btn btn-primary mainBtn" id="submit" value="Enviar">
			</form>
		</div>
	</div>
	
	<!-- Google Map -->
	<script src="http://maps.google.com/maps/api/js?sensor=true"></script>
	
	<!-- Google Map Init-->
	<script type="text/javascript">
        var map;
        function initialize() {
       	  var myLatlng = new google.maps.LatLng(39.993995, -0.069576);
          var mapOptions = {
            zoom: 16,
            center: myLatlng
          };
          map = new google.maps.Map(document.getElementById('map'),
              mapOptions);
          var image = 'img/logo.png';
          var marker = new google.maps.Marker({
              position: myLatlng,
              map: map,
              title: 'NaturAdventure',
              icon: image
          });
        }
        google.maps.event.addDomListener(window, 'load', initialize);
	</script>

</jsp:body>
</t:paginabasica>