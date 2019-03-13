package es.uji.ei1027.toopots.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import es.uji.ei1027.toopots.dao.ActividadDao;
import es.uji.ei1027.toopots.model.Actividad;

@Controller
@RequestMapping("/actividad")
public class ActividadController {

	@RequestMapping("/prova")
	public String provaWeb(Model model) {
		String message = "Provant la Web de Toopots";
		model.addAttribute("message", message);
		return "prova";
	}
	@Autowired
	ActividadDao actividadDao;

	@RequestMapping("/provaActividad")
	public String provaUnaActividad(Model model) {
		Actividad actividad = actividadDao.getActividad("a01");
		model.addAttribute("message", actividad.toString());
		return "prova";
	}

	@RequestMapping("/list")
	public String listActividades(Model model) {
		model.addAttribute("actividades", actividadDao.getActividades());
		return "actividad/list";
	}
	
	
	// Operacions: Crear, llistar, actualitzar, esborrar
	   
	   //Crear
	   // Creació d'objectes
	   @RequestMapping(value="/add") 
	   public String addActividad(Model model) {
	       model.addAttribute("actividad", new Actividad());
	       return "actividad/add";
	   }
	   // Gestió de la resposta del formulari de creació d'objectes
	   @RequestMapping(value="/add", method=RequestMethod.POST) 
	   public String processAddSubmit(@ModelAttribute("actividad") Actividad actividad,
	                                   BindingResult bindingResult) {  
	        if (bindingResult.hasErrors()) 
	               return "actividad/add";
	        actividadDao.addActividad(actividad);
	        return "redirect:list"; 
	    }
	   
	   //Modificar
	   //Modificació d'objectes
	   @RequestMapping(value="/update/{idActividad}", method = RequestMethod.GET) 
	   public String editActividad(Model model, @PathVariable String idActividad) { 
	       model.addAttribute("actividad", actividadDao.getActividad(idActividad));
	       return "actividad/update"; 
	   }
	   //Resposta de modificació d'objectes
	   @RequestMapping(value="/update/{idActividad}", method = RequestMethod.POST) 
	   public String processUpdateSubmit(@PathVariable String idActividad, 
	                           @ModelAttribute("actividad") Actividad actividad, 
	                           BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) 
	            return "actividad/update";
	        actividadDao.updateActividad(actividad);
	        return "redirect:../list"; 
	   }
	   
	   //Borrar una actividad
	   @RequestMapping(value="/delete/{idActividad}")
	   public String processDelete(@PathVariable String idActividad) {
	          actividadDao.deleteActividad(idActividad);;
	          return "redirect:../list"; 
	   }

}
