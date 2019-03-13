package es.uji.ei1027.toopots.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import es.uji.ei1027.toopots.dao.InstructorDao;
import es.uji.ei1027.toopots.model.Instructor;

@Controller
@RequestMapping("/instructor")
public class InstructorController {

	@Autowired
	InstructorDao instructorDao;


	@RequestMapping("/list")
	public String listInstructor(Model model) {
		model.addAttribute("instructores", instructorDao.getInstructores());
		return "instructor/list";
	}
	
	
	// Operacions: Crear, llistar, actualitzar, esborrar
	   
	   //Crear
	   // Creació d'objectes
	   @RequestMapping(value="/add") 
	   public String addInstructor(Model model) {
	       model.addAttribute("instructor", new Instructor());
	       return "instructor/add";
	   }
	   // Gestió de la resposta del formulari de creació d'objectes
	   @RequestMapping(value="/add", method=RequestMethod.POST) 
	   public String processAddSubmit(@ModelAttribute("instructor") Instructor instructor,
	                                   BindingResult bindingResult) {  
	        if (bindingResult.hasErrors()) 
	               return "instructor/add";
	        instructorDao.addInstructor(instructor);
	        return "redirect:list"; 
	    }
	   
	   //Modificar
	   //Modificació d'objectes
	   @RequestMapping(value="/update/{nom}", method = RequestMethod.GET) 
	   public String editInstructor(Model model, @PathVariable String idInstructor) { 
	       model.addAttribute("instructor", instructorDao.getInstructor(idInstructor));
	       return "instructor/update"; 
	   }
	   //Resposta de modificació d'objectes
	   @RequestMapping(value="/update/{nom}", method = RequestMethod.POST) 
	   public String processUpdateSubmit(@PathVariable String idInstructor, 
	                           @ModelAttribute("instructor") Instructor instructor, 
	                           BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) 
	            return "instructor/update";
	        instructorDao.updateInstructor(instructor);
	        return "redirect:../list"; 
	   }
	   
	   //Borrar un instructor
	   @RequestMapping(value="/delete/{nom}")
	   public String processDelete(@PathVariable String instructor) {
	          instructorDao.deleteInstructor(instructor);
	          return "redirect:../list"; 
	   }

}
