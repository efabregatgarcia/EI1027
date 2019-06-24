package es.uji.ei1027.toopots.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod;

import es.uji.ei1027.toopots.dao.*;
import es.uji.ei1027.toopots.domain.*;

@Controller 
@RequestMapping("/user") 
public class UserController {
	
	private ClienteDao clienteDao;
	private ReservaDao reservaDao;
	private ActividadDao actividadDao;
	
	@Autowired
	public void setDaos( ClienteDao clienteDao, ReservaDao reservaDao, ActividadDao actividadDao) {
		this.clienteDao = clienteDao;
		this.reservaDao = reservaDao;
		this.actividadDao = actividadDao;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		// Establecer el formato de fechas por defecto
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	public boolean esCliente( HttpSession session) {
		if (session.getAttribute("grupo") == "cliente") {
			return true;
	    }
		return false;
	}
	
	public int idCliente(HttpSession session) {
		return Integer.parseInt(session.getAttribute("userId").toString());
	}
	
	/*
	 * PANEL DE CONTROL DEL USUARIO
	 */
	
	@RequestMapping("/panel")
	public String panelUsuario(HttpSession session, Model model) {
		// Si no est� logeado lo mandamos a la pagina de login
		if (session.getAttribute("user") == null) {
			model.addAttribute("user", new UserDetails());
			session.setAttribute("nextUrl", "user/panel.html");
			return "login";
			
		// Si esta logeado pero no es un cliente lo mandamos al panel de administracion
		} else if (session.getAttribute("grupo") != "cliente") {
			return "admin";
		}
		
		// De lo contrario significa que es un cliente, lo mandamos a su panel
		
		Cliente cliente = clienteDao.getCliente(idCliente(session));
		model.addAttribute("cliente", cliente);
		return "user/panel";
	}
	
	@RequestMapping(value="/mi-perfil")
	public String perfilUsuario( HttpSession session, Model model ) {
		// Si no est� logeado lo mandamos a la pagina de login
		if (!esCliente(session)) {
			model.addAttribute("user", new UserDetails());
			session.setAttribute("nextUrl", "user/panel.html");
			return "login";
		}
		
		// De lo contrario significa que es un cliente
		model.addAttribute("cliente", clienteDao.getCliente(idCliente(session)));
		return "user/perfil";
	}
	
	@RequestMapping(value="/mi-perfil", method=RequestMethod.POST)
	public String perfilUsuarioProcess(@ModelAttribute("cliente") Cliente cliente,  BindingResult bindingResult, HttpSession session) {
		// Si no est� logeado lo mandamos fuera
		if (!esCliente(session)) {
			return "redirect:../";
		}
		
		if( bindingResult.hasErrors() ) {
			return "user/perfil";
		}
		
		clienteDao.updateCliente(cliente);
		return "redirect:mi-perfil.html?ok";
	}
   
	
	@RequestMapping("/mis-reservas")
	public String misReservas( Model model, HttpSession session ) {
		if( !esCliente(session) ) {
			return "redirect:../";
		} else {
			model.addAttribute("reservas", reservaDao.getReservasCliente(idCliente(session)));
			return "user/mis-reservas";
		}
	}
	
	
	/*
	 * RESERVA DE ACTIVIDADES
	 */
	
	@RequestMapping(value="/reservar/{id_actividad}", method=RequestMethod.GET)
	public String hacerReserva( Model model, @PathVariable int id_actividad, HttpSession session ) {
		if (!esCliente(session)) {
			model.addAttribute("user", new UserDetails());
			String nextUrl = "user/reservar/" + id_actividad + ".html";
			session.setAttribute("nextUrl", nextUrl);
			return "redirect:../../login.html";
		}
		model.addAttribute("actividad", actividadDao.getActividad(id_actividad));
		model.addAttribute("id_cliente", idCliente(session));
		model.addAttribute("reserva", new Reserva());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		model.addAttribute("fechaHoy", dateFormat.format(new Date()));
		return "user/reservar";
	}
	
	
	@RequestMapping(value="/reservar", method=RequestMethod.POST)
	public String hacerReservaProcess( @ModelAttribute("reserva") Reserva reserva,  BindingResult bindingResult, HttpSession session ) {
		if (!esCliente(session)) {
			return "redirect:../";
		}
		
		if( bindingResult.hasErrors() ) {
			return "user/reservar";
		}
		
		reservaDao.addReserva(reserva);
		return "static/reservaDone";
	}
	
	
	
}
