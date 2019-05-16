package es.uji.ei1027.toopots.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.toopots.dao.UsuarioDao;
import es.uji.ei1027.toopots.enumeracion.EnumTipoUsuario.EnumTipoUsuarios;
import es.uji.ei1027.toopots.model.Usuario;
import es.uji.ei1027.toopots.validator.UsuarioValidator;


@Controller
@RequestMapping("/login")


public class LoginController {
	
	@Autowired(required=true)
	//@Qualifier("UsuarioDao")
	private UsuarioDao usuarioDao;
	
	
	@RequestMapping("/login")
	public String login (Model model, HttpSession session) {
		model.addAttribute("usuario", new Usuario());
		return "/login/login.html";
	}
	
	@RequestMapping( value="/login", method = RequestMethod.POST)
	public String checkLogin(@ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult, HttpSession session) {
		
		UsuarioValidator usuarioValidator = new UsuarioValidator();
		usuarioValidator.validate(usuario, bindingResult);
		
		if(bindingResult.hasErrors()) {
			return "redirect:/";
		}
		
		usuario = usuarioDao.getUsuario(usuario.getEmailUsuario(), usuario.getContrasenya());
		if(usuario == null) {
			bindingResult.rejectValue("error", "obligatori", "Usuario o contraseña incorrecta");
			return "/";
		}
		session.setAttribute("usuarioActual", usuario);
		switch(EnumTipoUsuarios.getTipoEnum(usuario.getEnumTipoUsuario())) {
		case CLIENTE:
			return "redirect:/cliente/list.html";
		case INSTRUCTOR:
			return "redirect:/instructor/list.html";
		case ADMINISTRADOR:
			return "redirect:/administrador/list.html";
			default:
				break;
		}
		return "/";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return"redirect:/";
	}
	
}