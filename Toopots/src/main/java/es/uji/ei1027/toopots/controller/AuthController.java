package es.uji.ei1027.toopots.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Controller; 
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult; 
import org.springframework.web.bind.annotation.ModelAttribute; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 

import es.uji.ei1027.toopots.dao.*;
import es.uji.ei1027.toopots.domain.*;
import es.uji.ei1027.toopots.validators.*;


@Controller
public class AuthController {
	
	private ClienteDao clienteDao;
	private EmpleadoDao empleadoDao;
	
	private ClienteProvider clienteProvider;
	private EmpleadoProvider empleadoProvider;
	
	private RegisterValidator registerValidator;
	private LoginValidator loginValidator;
	

	@Autowired
	public void setProviders( ClienteProvider clienteProvider, EmpleadoProvider empleadoProvider ) {
		this.clienteProvider = clienteProvider;
		this.empleadoProvider = empleadoProvider;
	}
	
	@Autowired
	public void setDaos( ClienteDao clienteDao, EmpleadoDao empleadoDao ) {
		this.clienteDao = clienteDao;
		this.empleadoDao = empleadoDao;
	}
	
	@Autowired
	public void setValidators ( RegisterValidator registerValidator, LoginValidator loginValidator){
		this.registerValidator = registerValidator;
		this.loginValidator = loginValidator;
	}
	
	public boolean esEmpleado( HttpSession session) {
		if (session.getAttribute("grupo") == "monitor" || session.getAttribute("grupo") == "gerente") {
			return true;
	    }
		return false;
	}

	public boolean esCliente( HttpSession session) {
		if (session.getAttribute("grupo") == "cliente") {
			return true;
	    }
		return false;
	}
	
	
	/*
	 * LOGIN DE CLIENTES
	 */
	@RequestMapping("/login")
	public String login(Model model, HttpSession session ) {
		if(esCliente(session)) {
			return "redirect:user/panel.html?firstvisit";
		}
		model.addAttribute("user", new UserDetails());
		return "login";
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String checkLogin(@ModelAttribute("user") UserDetails user,  BindingResult bindingResult, HttpSession session) {
		
		loginValidator.validate(user, bindingResult); 
		if (bindingResult.hasErrors()) {
			return "login";
		}
		
		// Comprova que el login siga correcte
		// intentant carregar les dades de l'usuari
		user = clienteProvider.loadUserByUsername(user.getUsername(), user.getPassword());
		if (user == null) {
			bindingResult.rejectValue("password", "badpw", "Contrase�a incorrecta"); 
			return "login";
		}
		
		// Autenticats correctament. 
        // Guardem les dades de l'usuari autenticat a la sessio
		Cliente cliente = clienteDao.getClienteByLogin(user.getUsername());
		session.setAttribute("user", user);
		session.setAttribute("userId", cliente.getId_cliente());
		session.setAttribute("grupo", "cliente");
			
		// Si hay una URL previa lo llevamos alli
		if (session.getAttribute("nextUrl") != null) {
			return "redirect:" + session.getAttribute("nextUrl");
		}
		// Sino a la p�gina principal
		return "redirect:user/panel.html?firstvisit";
	}
	
	
	/*
	 * LOGIN DE EMPLEADOS
	 */
	@RequestMapping("/admin-login")
	public String adminLogin(Model model, HttpSession session ) {
		if ( esEmpleado(session) ) {
			return "redirect:admin.html?firstvisit";
		}
		model.addAttribute("user", new UserDetails());
		return "admin-login";
	}

	@RequestMapping(value="/admin-login", method=RequestMethod.POST)
	public String checkAdminLogin(@ModelAttribute("user") UserDetails user,  BindingResult bindingResult, HttpSession session) {
		
		loginValidator.validate(user, bindingResult); 
		if (bindingResult.hasErrors()) {
			return "admin-login";
		}
		
		// Comprova que el login siga correcte
		// intentant carregar les dades de l'usuari
		user = empleadoProvider.loadUserByUsername(user.getUsername(), user.getPassword());
		if (user == null) {
			bindingResult.rejectValue("password", "badpw", "Contrase�a incorrecta"); 
			return "admin-login";
		}
		
		// Autenticats correctament. 
        // Guardem les dades de l'usuari autenticat a la sessio
		Empleado empleado = empleadoDao.getEmpleadoByLogin(user.getUsername());
		session.setAttribute("user", user);
		session.setAttribute("userId", empleado.getId_empleado());
		session.setAttribute("grupo", user.getGrupo().toString());
		
		// Sino al panel de administracion
		return "redirect:admin.html?firstvisit";
	}
	
	
	@RequestMapping("/register")
	public String register(Model model, HttpSession session) {
		if (session.getAttribute("user") != null) { 
	          return "/user/panel.html";
	    }
		model.addAttribute("cliente", new Cliente());
		// WEB-INF/jsp/register.jsp
		return "register";
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String processRegisterSubmit( Model model,
										 @ModelAttribute("cliente") Cliente cliente,
										 BindingResult bindingResult) {

		registerValidator.validate(cliente, bindingResult);
		if ( bindingResult.hasErrors()) {
			return "register";
		}
				
		// Si no tiene errores lo inserta
		clienteDao.addCliente(cliente);
		model.addAttribute(cliente);
		// WEB-INF/jsp/success.jsp
		return "success";
	}

	
	@RequestMapping("/logout") 
	public String logout(HttpSession session) {
		session.invalidate(); 
		return "redirect:index.jsp";
	}
}