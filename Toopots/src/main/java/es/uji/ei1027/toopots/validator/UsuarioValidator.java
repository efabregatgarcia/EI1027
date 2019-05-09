package es.uji.ei1027.toopots.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.toopots.model.Usuario;

public class UsuarioValidator implements Validator{

	@Override
	public boolean supports(Class<?> cls) {
		// TODO Auto-generated method stub
		return Usuario.class.isAssignableFrom(cls);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		// TODO Auto-generated method stub
		Usuario usuario = (Usuario) obj;
		if (usuario == null) {
			errors.rejectValue("error", "obligatori", "Usuario o contraseña incorrecta");
			return;
		}
		
	}


	

}
