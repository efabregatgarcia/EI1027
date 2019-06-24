package es.uji.ei1027.toopots.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors; 
import org.springframework.validation.Validator;

import es.uji.ei1027.toopots.domain.*;

@Component
public class LoginValidator implements Validator {
	@Override
	public boolean supports(Class<?> cls) { 
		return UserDetails.class.isAssignableFrom(cls);
	}
	@Override 
	public void validate(Object obj, Errors errors) {
		UserDetails user = (UserDetails) obj;
		if (user.getUsername().trim().equals("")) {
			errors.rejectValue("username", "obligatorio", "Introduce un nombre de usuario");
		}
		if (user.getPassword().trim().equals("")) {
			errors.rejectValue("password", "obligatorio", "Introduce una contrase�a");
		}
	}
}
