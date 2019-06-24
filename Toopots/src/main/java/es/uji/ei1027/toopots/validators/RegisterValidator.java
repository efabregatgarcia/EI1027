package es.uji.ei1027.toopots.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors; 
import org.springframework.validation.Validator;

import es.uji.ei1027.toopots.dao.*;
import es.uji.ei1027.toopots.domain.*;

@Component
public class RegisterValidator implements Validator {
	
	ClienteDao clienteDao;
	
	
	@Autowired
	public void setEmpleadoDao( ClienteDao clienteDao ) {
		this.clienteDao = clienteDao;
	}

	
	@Override
	public boolean supports(Class<?> cls) { 
		return UserDetails.class.isAssignableFrom(cls);
	}
	@Override 
	public void validate(Object obj, Errors errors) {
		Cliente cliente = (Cliente) obj;
		
		if (cliente.getEmail().trim().equals("")) {
			errors.rejectValue("email", "obligatorio", "Introduce un email");
		}
		
		if (cliente.getLogin().trim().equals("")) {
			errors.rejectValue("login", "obligatorio", "Introduce un nombre de usuario");
		}
		
		if ( clienteDao.existeEmail(cliente.getEmail()) ) {
			errors.rejectValue("email", "obligatorio", "Ya existe un usuario con este email");
		}
		
		if ( clienteDao.existeLogin(cliente.getLogin()) ) {
			errors.rejectValue("login", "obligatorio", "Ya existe un usuario con este login");
		}
		
		if (cliente.getPasswd().trim().equals("")) {
			errors.rejectValue("passwd", "obligatorio", "Introduce una contrase�a");
		}
		
		if (cliente.getPasswd().trim().length() < 6) {
			errors.rejectValue("passwd", "menos de 6 caracteres", "La contrase�a debe tener al menos 6 caracteres");
		}
		
		if (!cliente.getPasswd().trim().equals(cliente.getPasswd2().trim())) {
			errors.rejectValue("passwd2", "no coinciden", "Las contrase�as no coinciden");
		}
		
		System.out.println("Pass: "+cliente.getPasswd().trim() +", Pass2: "+ cliente.getPasswd2());
		System.out.println(cliente.getPasswd().trim() == cliente.getPasswd2().trim());
	}
}
