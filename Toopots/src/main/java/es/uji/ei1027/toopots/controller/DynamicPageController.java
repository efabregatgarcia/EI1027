package es.uji.ei1027.toopots.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping; 

import es.uji.ei1027.toopots.dao.*;

@Controller
public class DynamicPageController {
	
	private NoticiaDao noticiaDao;
	private ActividadDao actividadDao;
	
	@Autowired
	public void setNoticiaDao( NoticiaDao noticiaDao ) {
		this.noticiaDao = noticiaDao;
	}
	
	@Autowired
	public void setActividadDao( ActividadDao actividadDao ) {
		this.actividadDao = actividadDao;
	}
	
	/*
	 * NOTICIAS
	 */
	@RequestMapping("/noticias")
	public String noticias( Model model) {
		model.addAttribute("noticias", noticiaDao.getNoticias());
		// WEB-INF/jsp/dynamic/noticias.jsp
		return "dynamic/noticias";
	}

	/*
	 * ACTIVIDADES
	 */
	@RequestMapping("/actividades")
	public String actividades( Model model ) {
		model.addAttribute("actividades", actividadDao.getActividades());
		// WEB-INF/jsp/dynamic/actividades.jsp
		return "dynamic/actividades";
	}
}