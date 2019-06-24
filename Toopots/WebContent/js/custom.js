window.setTimeout(function() {
    $(".alert").fadeTo(500, 0).slideUp(500, function(){
        $(this).remove(); 
    });
}, 4000);


function updateTextInput( idElem, val ) {
	document.getElementById(idElem).value = val;
} 

function updateTotalInput( idElem, precioPorPersona, personas ) {
	document.getElementById(idElem).value = personas * precioPorPersona;
}

function confirmDeleteModal(url) {
    bootbox.confirm("&iquest;Seguro que quieres borrar el elemento? Esta acci&oacute;n no se puede deshacer.", function(okay) {
        if(okay)
             location.href = url;
    });
    return false;
}

function confirmArchiveModal(url) {
    bootbox.confirm("&iquest;Seguro que quieres archivar la reserva? Esta acci&oacute;n no se puede deshacer.", function(okay) {
        if(okay)
             location.href = url;
    });
    return false;
}

function confirmRefuseModal(url) {
    bootbox.confirm("&iquest;Seguro que quieres rechazar la reserva? Esta acci&oacute;n no se puede deshacer.", function(okay) {
        if(okay)
             location.href = url;
    });
    return false;
}