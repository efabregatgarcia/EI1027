package es.uji.ei1027.toopots.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

import es.uji.ei1027.toopots.dao.*;
import es.uji.ei1027.toopots.domain.*;
import es.uji.ei1027.toopots.validators.*;
import es.uji.ei1027.toopots.dao.ActividadDao;
import es.uji.ei1027.toopots.dao.ClienteDao;
import es.uji.ei1027.toopots.dao.ReservaDao;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	private ReservaDao reservaDao;
	private EmpleadoDao empleadoDao;
	private ActividadDao actividadDao;
	private NoticiaDao noticiaDao;
	private ClienteDao clienteDao;
	private HistoricoDao historicoDao;
	private TipoDao tipoDao;
	private MonitorReservaDao monitorReservaDao;
	
	private ClienteValidator clienteValidator;
	private EmpleadoValidator empleadoValidator;
	private NoticiaValidator noticiaValidator;
	private ActividadValidator actividadValidator;
	
	@Autowired
	public void setDaos( ReservaDao reservaDao, EmpleadoDao empleadoDao, ActividadDao actividadDao,
						 NoticiaDao noticiaDao, ClienteDao clienteDao, HistoricoDao historicoDao,
						 TipoDao tipoDao, MonitorReservaDao monitorReservaDao) {
		this.reservaDao = reservaDao;
		this.empleadoDao = empleadoDao;
		this.actividadDao = actividadDao;
		this.noticiaDao = noticiaDao;
		this.clienteDao = clienteDao;
		this.historicoDao = historicoDao;
		this.tipoDao = tipoDao;
		this.monitorReservaDao = monitorReservaDao;
	}
	
	
	@Autowired
	public void setValidators ( ClienteValidator clienteValidator, EmpleadoValidator empleadoValidator, 
								NoticiaValidator noticiaValidator, ActividadValidator actividadValidator) {
		this.clienteValidator = clienteValidator;
		this.empleadoValidator = empleadoValidator;
		this.noticiaValidator = noticiaValidator;
		this.actividadValidator = actividadValidator;
		
	}
	
	public boolean esEmpleado( HttpSession session) {
		if (session.getAttribute("grupo") == "monitor" || session.getAttribute("grupo") == "gerente") {
			return true;
	    }
		return false;
	}
	
	public boolean esGrupo( HttpSession session, String grupo) {
		if (session.getAttribute("grupo") == grupo) {
			return true;
	    }
		return false;
	}
	
	public int idEmpleado( HttpSession session) {
		return Integer.parseInt(session.getAttribute("userId").toString());
	}
	
	// Metodo por defecto, con un mensaje de bienvenida
	@RequestMapping(method = RequestMethod.GET)
	public String defaultMethod( HttpSession session, Model model) {
		if ( esEmpleado(session) ) {
			Empleado empleado = empleadoDao.getEmpleado(idEmpleado(session));
			model.addAttribute("empleado", empleado);
			return "admin";
		}
		return "redirect:";
	}
	


	/***************************************
	/***************************************
	 * OPCIONES DE LOS MONITORES
	 */
	@RequestMapping("/mis-reservas")
	public String misReservas( Model model, HttpSession session ) {
		if( !esGrupo(session, "monitor") ) {
			return "redirect:../";
		} else {
			model.addAttribute("reservas", reservaDao.getReservasMonitor(idEmpleado(session)));
			return "admin/mis-reservas";
		}
	}
	
	@RequestMapping(value="/mi-perfil")
	public String perfilUsuario( HttpSession session, Model model ) {
		// Si no esta logeado lo mandamos a la pagina de login
		if ( !esGrupo(session, "monitor") ) {
			return "redirect:../";
		}
		
		// De lo contrario significa que es un cliente
		model.addAttribute("empleado", empleadoDao.getEmpleado(idEmpleado(session)));
		return "admin/perfil";
	}
	
	@RequestMapping(value="/mi-perfil", method=RequestMethod.POST)
	public String perfilUsuarioProcess(@ModelAttribute("empleado") Empleado empleado,  BindingResult bindingResult, HttpSession session) {
		// Si no esta logeado lo mandamos fuera
		if (!esGrupo(session, "monitor")) {
			return "redirect:../";
		}
		
		if( bindingResult.hasErrors() ) {
			return "admin/perfil";
		}
		
		empleadoDao.updateEmpleado(empleado);
		return "redirect:mi-perfil.html?ok";
	}
	
	@RequestMapping("/mi-calendario")
	public String miCalendario( Model model, HttpSession session ) {
		if( !esGrupo(session, "monitor") ) {
			return "redirect:../";
		} else {
			model.addAttribute("reservas", reservaDao.getReservasMonitor(idEmpleado(session)));
			model.addAttribute("actividades", actividadDao.getActividades());
			return "admin/mi-calendario";
		}
	}
	
	
	
	
	
	
	
	/******************************************
	/******************************************
	 * OPCIONES DEL GERENTE
	 */
	
	
	
	/*
	 * NOTICIAS
	 */
	// Listado de noticias y formulario
	@RequestMapping(value="/noticias", method=RequestMethod.GET)
	public String noticias( Model model, HttpSession session) {
		if( !esGrupo(session, "gerente") ) {
			return "redirect:../";
		} else {
			model.addAttribute("noticias", noticiaDao.getNoticias());
			model.addAttribute("noticia", new Noticia());
			return "admin/noticias";
		}
	}
	
	// Al a�adir una noticia
	@RequestMapping(value="/noticias", method=RequestMethod.POST)
	public String noticiasProcess(@ModelAttribute("noticia") Noticia noticia,  BindingResult bindingResult, Model model, HttpSession session) {
		if( !esGrupo(session, "gerente") ) {
			return "redirect:../";
		} else {
			
			noticiaValidator.validate(noticia, bindingResult);
			if (bindingResult.hasErrors()) {
				return "admin/noticias";
			}
			noticiaDao.addNoticia(noticia);
			model.addAttribute("noticias", noticiaDao.getNoticias());
			return "redirect:noticias.html?ok";
		}
	}
	
	// Al actualizar una noticia
	@RequestMapping(value="/updateNoticia/{id}", method=RequestMethod.GET)
	public String updateNoticia( Model model, @PathVariable int id, HttpSession session ) {
		if( !esGrupo(session, "gerente") ) {
			return "redirect:../";
		} else {
			model.addAttribute("noticia", noticiaDao.getNoticia(id)); 
			return "admin/updateNoticia";
		}
	}
	
	// Recibe los datos por POST del metodo anterior
	@RequestMapping(value="/updateNoticia/{id}", method=RequestMethod.POST)
	public String processUpdateNoticia(@PathVariable int id, 
									  @ModelAttribute("noticia") Noticia noticia,
									  BindingResult bindingResult) {

		noticiaValidator.validate(noticia, bindingResult);
		if( bindingResult.hasErrors() ) {
			return "admin/updateNoticia";
		}
		noticiaDao.updateNoticia(noticia);
		return "redirect:../noticias.html?ok";
	}
	
	// Borra una noticia de la base de datos
	@RequestMapping(value="/deleteNoticia/{id}")
	public String processDeleteNoticia(@PathVariable int id) {
		noticiaDao.deleteNoticia(id);
		return "redirect:../noticias.html?ok";
	}
	/*
	 * FIN DE NOTICIAS
	 */
	
	
	
	
	/*
	 * CLIENTES
	 */
	// Listado de clientes y formulario
	@RequestMapping(value="/clientes", method=RequestMethod.GET)
	public String clientes( Model model, HttpSession session) {
		if( !esGrupo(session, "gerente") ) {
			return "redirect:../";
		} else {
			model.addAttribute("clientes", clienteDao.getClientes());
			model.addAttribute("cliente", new Cliente());
			return "admin/clientes";
		}
	}
	
	// Al a�adir un cliente
	@RequestMapping(value="/clientes", method=RequestMethod.POST)
	public String clientesProcess(@ModelAttribute("cliente") Cliente cliente,  BindingResult bindingResult, Model model, HttpSession session) {
		if( !esGrupo(session, "gerente") ) {
			return "redirect:../";
		} else {
			
			clienteValidator.validate(cliente, bindingResult);
			if (bindingResult.hasErrors()) {
				return "admin/clientes";
			}
			clienteDao.addCliente(cliente);
			model.addAttribute("clientes", clienteDao.getClientes());
			return "redirect:clientes.html?ok";
		}
	}
	
	// Al actualizar un cliente
	@RequestMapping(value="/updateCliente/{id}", method=RequestMethod.GET)
	public String updateCliente( Model model, @PathVariable int id, HttpSession session ) {
		if( !esGrupo(session, "gerente") ) {
			return "redirect:../";
		} else {
			model.addAttribute("cliente", clienteDao.getCliente(id)); 
			return "admin/updateCliente";
		}
	}
	
	// Recibe los datos por POST del metodo anterior
	@RequestMapping(value="/updateCliente/{id}", method=RequestMethod.POST)
	public String processUpdateCliente(@PathVariable int id, 
									  @ModelAttribute("cliente") Cliente cliente,
									  BindingResult bindingResult) {
		
		clienteValidator.validate(cliente, bindingResult);
		if( bindingResult.hasErrors() ) {
			return "admin/updateCliente";
		}
		clienteDao.updateCliente(cliente);
		return "redirect:../clientes.html?ok";
	}
	
	// Borra un cliente de la base de datos
	@RequestMapping(value="/deleteCliente/{id}")
	public String processDeleteCliente(@PathVariable int id) {
		boolean estado = clienteDao.deleteCliente(id);
		if (estado) {
			return "redirect:../clientes.html?ok";
		} else {
			return "redirect:../clientes.html?cldtint";
		}
	}
	/*
	 * FIN DE CLIENTES
	 */
	
	/*
	 * EMPLEADOS
	 */
	// Listado de empleados y formulario
	@RequestMapping(value="/empleados", method=RequestMethod.GET)
	public String empleados( Model model, HttpSession session) {
		if( !esGrupo(session, "gerente") ) {
			return "redirect:../";
		} else {
			model.addAttribute("empleados", empleadoDao.getEmpleadosMenos( idEmpleado(session) ));
			model.addAttribute("empleado", new Empleado());
			return "admin/empleados";
		}
	}
	
	// Al a�adir un empleado
	@RequestMapping(value="/empleados", method=RequestMethod.POST)
	public String empleadosProcess(@ModelAttribute("empleado") Empleado empleado,  BindingResult bindingResult, Model model, HttpSession session) {
		if( !esGrupo(session, "gerente") ) {
			return "redirect:../";
		} else {
			
			empleadoValidator.validate(empleado, bindingResult);
			if (bindingResult.hasErrors()) {
				return "admin/empleados";
			}
			empleadoDao.addEmpleado(empleado);
			model.addAttribute("empleados", empleadoDao.getEmpleadosMenos( idEmpleado(session) ));
			return "redirect:empleados.html?ok";
		}
	}
		
	// Borra un empleado de la base de datos
	@RequestMapping(value="/deleteEmpleado/{id}")
	public String processDeleteEmpleado(@PathVariable int id) {
		empleadoDao.deleteEmpleado(id);
		return "redirect:../empleados.html?ok";
	}
	/*
	 * FIN DE EMPLEADOS
	 */
	
	
	/*
	 * ACTIVIDADES
	 */
	// Listado de actividades y formulario
	@RequestMapping(value="/actividades", method=RequestMethod.GET)
	public String actividades( Model model, HttpSession session) {
		if( !esGrupo(session, "gerente") ) {
			return "redirect:../";
		} else {
			model.addAttribute("actividades", actividadDao.getActividades());
			model.addAttribute("actividad", new Actividad());
			model.addAttribute("tipos", tipoDao.getTipos());
			return "admin/actividades";
		}
	}
	
	// Al a�adir una actividad
	@RequestMapping(value="/actividades", method=RequestMethod.POST)
	public String actividadesProcess(@ModelAttribute("actividad") Actividad actividad,  BindingResult bindingResult, Model model, HttpSession session) {
		if( !esGrupo(session, "gerente") ) {
			return "redirect:../";
		} else {
			
			actividadValidator.validate(actividad, bindingResult);
			if (bindingResult.hasErrors()) {
				return "admin/actividades";
			}
			actividadDao.addActividad(actividad);
			model.addAttribute("actividades", actividadDao.getActividades());
			return "redirect:actividades.html?ok";
		}
	}
	
	// Al actualizar una actividad
	@RequestMapping(value="/updateActividad/{id}", method=RequestMethod.GET)
	public String updateActividad( Model model, @PathVariable int id, HttpSession session ) {
		if( !esGrupo(session, "gerente") ) {
			return "redirect:../";
		} else {
			model.addAttribute("actividad", actividadDao.getActividad(id));
			model.addAttribute("tipos", tipoDao.getTipos());
			return "admin/updateActividad";
		}
	}
		
	// Recibe los datos por POST del metodo anterior
	@RequestMapping(value="/updateActividad/{id}", method=RequestMethod.POST)
	public String processUpdateActividad(@PathVariable int id, 
										 @ModelAttribute("actividad") Actividad actividad,
										 BindingResult bindingResult) {
			
		actividadValidator.validate(actividad, bindingResult);
		if( bindingResult.hasErrors() ) {
			return "admin/updateActividad";
		}
		actividadDao.updateActividad(actividad);
		return "redirect:../actividades.html?ok";
	}
	
	@RequestMapping(value="/deleteActividad/{id}")
	public String processDeleteActividad(@PathVariable int id) {
		actividadDao.deleteActividad(id);
		return "redirect:../actividades.html?ok";
	}
	
	/*
	 * RESERVAS
	 */
	// Listado de reservas y formulario
	@RequestMapping(value="/reservas", method=RequestMethod.GET)
	public String reservas( Model model, HttpSession session) {
		if( !esGrupo(session, "gerente") ) {
			return "redirect:../";
		} else {
			model.addAttribute("reservas", reservaDao.getReservas());
			model.addAttribute("reserva", new Reserva());
			model.addAttribute("monitorReserva", new MonitorReserva());
			model.addAttribute("monitores", empleadoDao.getEmpleados(Grupo.monitor));
			return "admin/reservas";
		}
	}
	
	// Archivar una reserva en el historico
	@RequestMapping(value="/archivarReserva/{id}")
	public String processArchiveSubmit( @PathVariable int id) {
		
		// Archivar la reserva
		historicoDao.addHistorico(id);
		return "redirect:../reservas.html?archived";
	}
	
	// Asignar un monitor
	@RequestMapping(value="/asignarMonitor/{id}", method=RequestMethod.GET)
	public String reservasAsignarMonitor(@PathVariable int id, Model model, HttpSession session) {
		if( !esGrupo(session, "gerente") ) {
			return "redirect:../";
		} else {
			model.addAttribute("monitores", empleadoDao.getEmpleados(Grupo.monitor));
			model.addAttribute("id_reserva", id);
			MonitorReserva MR = new MonitorReserva();
			MR.setId_reserva(id);
			model.addAttribute("monitorReserva", MR);
			return "admin/asignarMonitor";
		}
	}
	
	// Recibe los datos por POST del formulario anterior
	@RequestMapping(value="/asignarMonitor/{id}", method=RequestMethod.POST)
	public String processAsignarMonitor( @ModelAttribute("monitorReserva") MonitorReserva monitorReserva) {
		// Si no tiene errores lo a�ade y muestra el listado
		monitorReservaDao.addMonitorReserva(monitorReserva);
		return "redirect:../reservas.html?ok";
	}
	
	// Borra una reserva de la base de datos
	@RequestMapping(value="/deleteReserva/{id}")
	public String processDeleteReserva(@PathVariable int id) {
		reservaDao.deleteReserva(id);
		return "redirect:../reservas.html?ok";
	}
	
	// Borra una reserva de la base de datos
	@RequestMapping(value="/rechazarReserva/{id}")
	public String processRechazarReserva(@PathVariable int id) {
		reservaDao.rechazarReserva(id);
		return "redirect:../reservas.html?ok";
	}
	/*
	 * FIN DE RESERVAS
	 */
	
	
	/*
	 * HISTORICO
	 */
	// Listado de reservas y formulario
	@RequestMapping(value="/historico", method=RequestMethod.GET)
	public String historico( Model model, HttpSession session) {
		if( !esGrupo(session, "gerente") ) {
			return "redirect:../";
		} else {
			model.addAttribute("historicos", historicoDao.getHistoricos());
			return "admin/historico";
		}
	}
	
	// Borra una reserva de la base de datos
	@RequestMapping(value="/deleteHistorico/{id}")
	public String processDeleteHistorico(@PathVariable int id) {
		historicoDao.deleteHistorico(id);
		return "redirect:../historico.html?ok";
	}
	/*
	 * FIN DE HISTORICO
	 */
	
}
