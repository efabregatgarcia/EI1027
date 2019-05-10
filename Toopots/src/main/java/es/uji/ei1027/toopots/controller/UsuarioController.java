package es.uji.ei1027.toopots.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping; 

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
}

