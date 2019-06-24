package es.uji.ei1027.toopots.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.toopots.domain.Empleado;

@Component
public class EmpleadoValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return Empleado.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Empleado empleado = (Empleado) obj;
		if (empleado.getNombre().trim().equals(""))
			errors.rejectValue("nombre", "obligatorio", "Introduce un nombre");
		if (empleado.getEmail().trim().equals(""))
			errors.rejectValue("email", "obligatorio", "Introduce un email");
		if (empleado.getLogin().trim().equals(""))
			errors.rejectValue("login", "obligatorio", "Introduce un nombre de usuario");
		if (empleado.getPasswd().trim().equals("")) {
			errors.rejectValue("passwd", "obligatorio", "Introduce una contraseña");
		} else if (empleado.getPasswd().length() < 6) {
			errors.rejectValue("passwd", "menos de 6 caracteres", "La contraseña debe tener al menos 6 caracteres");
		}
	}

}
