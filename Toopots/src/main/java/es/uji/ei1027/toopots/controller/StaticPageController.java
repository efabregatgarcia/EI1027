package es.uji.ei1027.toopots.controller;

import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 

import es.uji.ei1027.toopots.domain.Contacto;

@Controller
public class StaticPageController {
	
	@RequestMapping("/about")
	public String login() {
		// WEB-INF/jsp/static/about.jsp
		return "static/about";
	}
	
	@RequestMapping("/contact")
	public String contact( Model model ) {
		
		model.addAttribute("contacto", new Contacto());
		
		// WEB-INF/jsp/static/contact.jsp
		return "static/contact";
	}
	
	// Falta por hacer, esta funcion recibe el formulario de contacto completo
	// y manda un email o algo...
	@RequestMapping(value="/contact", method=RequestMethod.POST)
	public String processContactSubmit(@ModelAttribute("contacto") Contacto contacto, BindingResult bindingResult) {
		if ( bindingResult.hasErrors()) {
			return "contact";
		}
		// Mandar email, en el objeto "contacto" estan todos los campos listos para usar en java
		// POR HACER
		
		// Mostrar pagina de exito
		// WEB-INF/jsp/static/contactDone.jsp
		return "static/contactDone";
	}

}