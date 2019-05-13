package es.uji.ei1027.toopots.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.toopots.dao.UsuarioDao; 
import es.uji.ei1027.toopots.model.Usuario;

@Controller 
@RequestMapping("/usuario") 
public class UsuarioController {
   private UsuarioDao usuarioDao;

   @Autowired 
   public void setUsuario(UsuarioDao usuarioDao) {
       this.usuarioDao = usuarioDao;
   }
  
   @RequestMapping("/list") 
   public String listUsuarios(HttpSession session, Model model) {
       if (session.getAttribute("usuario") == null) 
       { 
          model.addAttribute("usuario", new Usuario()); 
          return "login";
       } 
       model.addAttribute("usuarios", usuarioDao.getUsuarios());
       return "usuario/list";
   }
   
   @RequestMapping(value="/add") 
	public String addUsuario(Model model) {
	    model.addAttribute("usuario", new Usuario());
	    return "usuario/add";
	}	    
	
	@RequestMapping(value="/add", method=RequestMethod.POST) 
	public String addUsuario(@ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult) {  
		if (bindingResult.hasErrors()) {
			return "usuario/add";
		}
		usuarioDao.addUsuario(usuario);
		return "redirect:list.html"; 
	}
	@RequestMapping(value="/update/{emailUsuario}", method = RequestMethod.GET) 
	public String updateUsuario(Model model, @PathVariable String identificadoranterior) { 
		model.addAttribute("usuario", usuarioDao.getUsuarios(identificadoranterior));
		model.addAttribute("emailUsuario", identificadoranterior);
		return "usuario/update"; 
	}
	
	@RequestMapping(value="/update/{emailUsuario}", method = RequestMethod.POST) 
	public String updateUsuario(@ModelAttribute("usuario") Usuario usuario, @PathVariable String emailUsuario, BindingResult bindingResult) {
	     if (bindingResult.hasErrors()) {	    	 
	    	 return "usuario/update";
	     }
	     usuarioDao.updateUsuario(usuario, emailUsuario);
	     return "redirect:../list"; 
	  }
	
	@RequestMapping(value="/delete/{usuario}")    
	public String deleteUsuario(@PathVariable String usuario) {
		usuarioDao.deleteUsuario(usuario);
		return "redirect:../list"; 
	} 
}

