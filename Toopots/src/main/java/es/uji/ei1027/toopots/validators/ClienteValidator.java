package es.uji.ei1027.toopots.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.toopots.domain.Cliente;

@Component
public class ClienteValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return Cliente.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Cliente cliente = (Cliente) obj;
		if (cliente.getNombre().trim().equals(""))
			errors.rejectValue("nombre", "obligatorio", "Introduce un nombre");
		if (cliente.getApellidos().trim().equals(""))
			errors.rejectValue("apellidos", "obligatorio", "Introduce los apellidos");
		if (cliente.getEmail().trim().equals(""))
			errors.rejectValue("email", "obligatorio", "Introduce un email");
		if (cliente.getDireccion().trim().equals(""))
			errors.rejectValue("direccion", "obligatorio", "Introduce una dirección");
		if (cliente.getLogin().trim().equals(""))
			errors.rejectValue("login", "obligatorio", "Introduce un nombre de usuario");
		if (cliente.getPasswd().trim().equals("")) {
			errors.rejectValue("passwd", "obligatorio", "Introduce una contraseña");
		} else if (cliente.getPasswd().length() < 6) {
			errors.rejectValue("passwd", "menos de 6 caracteres", "La contraseña debe tener al menos 6 caracteres");
		}
	}

}
