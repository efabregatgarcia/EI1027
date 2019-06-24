package es.uji.ei1027.toopots.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import es.uji.ei1027.toopots.domain.Noticia;

@Component
public class NoticiaValidator implements Validator {

	@Override
	public boolean supports(Class<?> cls) {
		return Noticia.class.equals(cls);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		Noticia noticia = (Noticia) obj;
		if (noticia.getTitulo().trim().equals(""))
			errors.rejectValue("titulo", "obligatorio", "Título obligatorio");
		if (noticia.getSubtitulo().trim().equals(""))
			errors.rejectValue("subtitulo", "obligatorio", "Subtítulo obligatorio");
		if (noticia.getDescripcion().trim().equals(""))
			errors.rejectValue("descripcion", "obligatorio", "Introduce una descripción");
	}

}
