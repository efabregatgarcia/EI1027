package es.uji.ei1027.toopots.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Noticia {

	/* id_noticia, fecha, titulo, subtitulo, descripcion */
	private int id_noticia;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fecha;
	private String titulo;
	private String subtitulo;
	private String descripcion;
	
	public int getId_noticia() {
		return id_noticia;
	}
	public void setId_noticia(int id_noticia) {
		this.id_noticia = id_noticia;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getSubtitulo() {
		return subtitulo;
	}
	public void setSubtitulo(String subtitulo) {
		this.subtitulo = subtitulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
