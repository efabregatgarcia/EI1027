<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<t:paginabasica title="Calendario de mis actividades" panel="calendario">
<jsp:body>
	
	<div id="full-clndr">
          <script type="text/template" id="full-clndr-template">
            <div class="clndr-controls">
              <div class="clndr-previous-button">&lt; Ant</div>
              <div class="clndr-next-button">Sig &gt;</div>
              <div class="current-month"><\%= month %> <\%= year %></div>
            </div>
            <div class="clndr-grid">
              <div class="days-of-the-week clearfix">
                <\% _.each(daysOfTheWeek, function(day) { %>
                  <div class="header-day"><\%= day %></div>
                <\% }); %>
              </div>
              <div class="days">
                <\% _.each(days, function(day) { %>
                  <div class="<\%= day.classes %>" id="<\%= day.id %>"><span class="day-number"><\%= day.day %></span></div>
                <\% }); %>
              </div>
            </div>
            <div class="event-listing">
              <div class="event-listing-title">ACTIVIDADES ESTE MES</div>
              <\% _.each(eventsThisMonth, function(event) { %>
                  <div class="event-item">
                    <div class="event-item-name"><\%= event.title %></div>
                    <div class="event-item-location"><\%= event.location %></div>
                  </div>
                <\% }); %>
            </div>
          </script>
   </div>
   
   	
	<script type="text/javascript" >
	var clndr = {};
	
	$(document).ready( function() {
		   moment.locale('es', {
			    months : [
			        "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio",
			        "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
			    ]
		   });
		  moment.locale('es');
		  var currentMonth = moment().format('YYYY-MM');
		  var nextMonth    = moment().add('month', 1).format('YYYY-MM');
		  
		  // Traducir el tipo HoraInicio a un texto mas significativo
		  var horaInicioMap = { manana : "Mañana (06:00 - 14:00)", tarde : "Tarde (14:00 - 20:00)", noche : "Noche (20:00 - 00:00)"};
		  
		  var actividadMap = new Map();
		  var table = document.getElementById("tablaActividades");
		  for (var i = 0, row; row = table.rows[i]; i++) {
			  var cells = table.rows.item(i).cells;
		      actividadMap[cells.item(0).innerHTML] = cells.item(1).innerHTML;
		  }
		  
		  // Usamos una tabla de interfaz entre JSP y Javascript
		  // Cargamos los datos en dicha tabla y los leemos desde JS para
		  // insertar los eventos en el calendario
		  var events = [];
		  var oTable = document.getElementById('tablaReservas');
		  for (i = 0; i < oTable.rows.length; i++){
			  var oCells = oTable.rows.item(i).cells;
			  events.push({
				  date: oCells.item(2).innerHTML,
				  title: oCells.item(2).innerHTML + ": " + actividadMap[oCells.item(0).innerHTML],
				  location: horaInicioMap[oCells.item(1).innerHTML]
			  });
		  }

		  clndr = $('#full-clndr').clndr({
		    template: $('#full-clndr-template').html(),
		    events: events,
		    weekOffset: 1,
		    daysOfTheWeek: ['Dom', 'Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab'],
		    forceSixRows: true
		  });
	});
	</script>
   
   
   <!-- Las siguientes tablas se usan como interfaz para comunicar Spring con JavaScript -->
	<table id="tablaReservas" class="hidden">
		<c:forEach items="${reservas}" var="reserva">
			<tr><td>${reserva.id_actividad}</td><td>${reserva.horaInicio}</td><td>${reserva.fechaActividad}</td></tr>
		</c:forEach>
	</table>
	
	<table id="tablaActividades" class="hidden">
		<c:forEach items="${actividades}" var="actividad">
			<tr><td>${actividad.id_actividad}</td><td>${actividad.nombre}</td></tr>
		</c:forEach>
	</table>
</jsp:body>
</t:paginabasica>