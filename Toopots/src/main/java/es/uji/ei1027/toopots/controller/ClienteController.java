package es.uji.ei1027.toopots.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.toopots.dao.ClienteDao;
import es.uji.ei1027.toopots.model.Actividad;
import es.uji.ei1027.toopots.model.Cliente;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteDao clienteDao;
	
	 //Modificació d'objectes
	 @RequestMapping(value="/add") 
	   public String addCliente(Model model) {
	       model.addAttribute("cliente", new Cliente());
	       return "cliente/add";
	   }
	 
	 @RequestMapping("/list")
		public String listClientes(Model model) {
			model.addAttribute("actividades", clienteDao.getClientes());
			return "cliente/list";
		}
	 
	// Gestió de la resposta del formulari de creació d'objectes
	   @RequestMapping(value="/add", method=RequestMethod.POST) 
	   public String processAddSubmit(@ModelAttribute("cliente") Cliente cliente,
	                                   BindingResult bindingResult) {  
	        if (bindingResult.hasErrors()) 
	               return "actividad/add";
	        clienteDao.addCliente(cliente);
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
