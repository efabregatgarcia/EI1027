package es.uji.ei1027.toopots.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.toopots.dao.ReservaDao;
import es.uji.ei1027.toopots.model.Reserva;

@Controller
@RequestMapping("/reserva")
public class ReservaController {

	@Autowired
	ReservaDao reservaDao;

	@RequestMapping("/list")
	public String listReserva(Model model) {
		model.addAttribute("reservas", reservaDao.getReservas());
		return "reserva/list";
	}

	// Operacions: Crear, llistar, actualitzar, esborrar

	// Crear
	// Creació d'objectes
	@RequestMapping(value = "/add")
	public String addReserva(Model model) {
		model.addAttribute("reserva", new Reserva());
		return "reserva/add";
	}

	// Gestió de la resposta del formulari de creació d'objectes
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddSubmit(@ModelAttribute("reserva") Reserva reserva, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "reserva/add";
		reservaDao.addReserva(reserva);
		return "redirect:list";
	}

	// Modificar
	// Modificació d'objectes
	@RequestMapping(value = "/update/{idReserva}", method = RequestMethod.GET)
	public String editReserva(Model model, @PathVariable String idReserva) {
		model.addAttribute("reserva", reservaDao.getReserva(idReserva));
		return "reserva/update";
	}

	// Resposta de modificació d'objectes
	@RequestMapping(value = "/update/{idReserva}", method = RequestMethod.POST)
	public String processUpdateSubmit(@PathVariable String idReserva,
			@ModelAttribute("reserva") Reserva reserva, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return "reserva/update";
		reservaDao.updateReserva(reserva);
		return "redirect:../list";
	}

	// Borrar una actividad
	@RequestMapping(value = "/delete/{idReserva}")
	public String processDelete(@PathVariable String idReserva) {
		reservaDao.deleteReserva(idReserva);
		;
		return "redirect:../list";
	}

}
