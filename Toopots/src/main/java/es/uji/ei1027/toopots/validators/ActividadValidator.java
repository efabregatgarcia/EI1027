package es.uji.ei1027.toopots.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.toopots.domain.Actividad;

@Component
public class ActividadValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return Actividad.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Actividad actividad = (Actividad) obj;
		if (actividad.getNombre().trim().equals(""))
			errors.rejectValue("nombre", "obligatorio", "Nombre obligatorio");
		if (actividad.getDuracionHoras() <= 0)
			errors.rejectValue("duracionHoras", "menor o igual a 0", "La duración debe ser de al menos 1 hora");
		if (actividad.getDescripcion().trim().equals(""))
			errors.rejectValue("descripcion", "obligatorio", "Introduce una descripción");
		if (actividad.getPrecioPorPersona() <= 0)
			errors.rejectValue("precioPorPersona", "menor o igual a 0", "El precio debe ser positivo");
		if (actividad.getMinParticipantes() <= 0)
			errors.rejectValue("minParticipantes", "menor o igual a 0", "El número de participantes debe ser de al menos 1");
		if (actividad.getMaxParticipantes() <= actividad.getMinParticipantes())
			errors.rejectValue("maxParticipantes", "menor o igual a minParticipantes", "El número máximo de participantes debe ser mayor que el número mínimo");
	}

}
