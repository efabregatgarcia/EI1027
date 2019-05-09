package es.uji.ei1027.toopots.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import es.uji.ei1027.toopots.dao.RegistroInstructorDao;
import es.uji.ei1027.toopots.model.RegistroInstructor;

@Controller
@RequestMapping("/registroInstructor")
public class RegistroInstructorController {

	@Autowired
	RegistroInstructorDao registroInstructorDao;


	@RequestMapping("/list")
	public String listRegistroInstructor(Model model) {
		model.addAttribute("registros", registroInstructorDao.getRegistroInstructores());
		return "registroInstructor/list";
	}
	
	
	// Operacions: Crear, llistar, actualitzar, esborrar
	   
	   //Crear
	   // Creació d'objectes
	   @RequestMapping(value="/add") 
	   public String addRegistroInstructor(Model model) {
	       model.addAttribute("registroInstructor", new RegistroInstructor());
	       return "registroInstructor/add";
	   }
	   // Gestió de la resposta del formulari de creació d'objectes
	   @RequestMapping(value="/add", method=RequestMethod.POST) 
	   public String processAddSubmit(@ModelAttribute("registroInstructor") RegistroInstructor registroInstructor,
	                                   BindingResult bindingResult) {  
	        if (bindingResult.hasErrors()) 
	               return "registroInstructor/add";
	        registroInstructorDao.addRegistroInstructor(registroInstructor);
	        return "redirect:list"; 
	    }
	   
	   //Modificar
	   //Modificació d'objectes
	   @RequestMapping(value="/update/{idRegistro}", method = RequestMethod.GET) 
	   public String editRegistroInstructor(Model model, @PathVariable String idRegistro) { 
	       model.addAttribute("registroInstructor", registroInstructorDao.getRegistroInstructor(idRegistro));
	       return "registroInstructor/update"; 
	   }
	   //Resposta de modificació d'objectes
	   @RequestMapping(value="/update/{idRegistro}", method = RequestMethod.POST) 
	   public String processUpdateSubmit(@PathVariable String idRegistro, 
	                           @ModelAttribute("registroInstructor") RegistroInstructor registroInstructor, 
	                           BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) 
	            return "registroInstructor/update";
	        registroInstructorDao.updateRegistroInstructor(registroInstructor);
	        return "redirect:../list"; 
	   }
	   
	   //Borrar un instructor
	   @RequestMapping(value="/delete/{idRegistro}")
	   public String processDelete(@PathVariable String idRegistro) {
	          registroInstructorDao.deleteRegistroInstructor(idRegistro);
	          return "redirect:../list"; 
	   }

}
