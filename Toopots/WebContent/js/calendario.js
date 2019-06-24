// call this from the developer console and you can control both instances

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

	  var events = [
	    { date: currentMonth + '-' + '10', title: 'Persian Kitten Auction', location: 'Center for Beautiful Cats' },
	    { date: currentMonth + '-' + '19', title: 'Cat Frisbee', location: 'Jefferson Park' },
	    { date: currentMonth + '-' + '23', title: 'Kitten Demonstration', location: 'Center for Beautiful Cats' },
	    { date: nextMonth + '-' + '07',    title: 'Small Cat Photo Session', location: 'Center for Cat Photography' }
	  ];

	  clndr = $('#full-clndr').clndr({
	    template: $('#full-clndr-template').html(),
	    events: events,
	    weekOffset: 1,
	    daysOfTheWeek: ['Dom', 'Lun', 'Mar', 'Mie', 'Jue', 'Vie', 'Sab'],
	    forceSixRows: true
	  });
});