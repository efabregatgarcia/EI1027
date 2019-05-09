package es.uji.ei1027.toopots.model;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

public class Actividad {
	private String idActividad;
	private String idInstructor;
	private String estado;
	private String nombre;
	private String tipoActividad;
	private String descripcion;
	private int duracion;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fecha;
	private int precio;
	private int asistentesMinimos;
	private int asistentesMaximos;
	private String lugar;
	private String puntoLlegada;
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime horaLlegada;
	
	public String getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(String idActividad) {
		this.idActividad = idActividad;
	}
	public String getIdInstructor() {
		return idInstructor;
	}
	public void setIdInstructor(String idInstructor) {
		this.idInstructor = idInstructor;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	public int getAsistentesMinimos() {
		return asistentesMinimos;
	}
	public void setAsistentesMinimos(int asistentesMinimos) {
		this.asistentesMinimos = asistentesMinimos;
	}
	public int getAsistentesMaximos() {
		return asistentesMaximos;
	}
	public void setAsistentesMaximos(int asistentesMaximos) {
		this.asistentesMaximos = asistentesMaximos;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getPuntoLlegada() {
		return puntoLlegada;
	}
	public void setPuntoLlegada(String puntoLlegada) {
		this.puntoLlegada = puntoLlegada;
	}
	public LocalTime getHoraLlegada() {
		return horaLlegada;
	}
	public void setHoraLlegada(LocalTime horaLlegada) {
		this.horaLlegada = horaLlegada;
	}
	public String getTipoActividad() {
		return tipoActividad;
	}
	public void setTipoActividad(String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}
	@Override
	public String toString() {
		return "Actividad [idActividad=" + idActividad + ", idInstructor=" + idInstructor + ", estado=" + estado
				+ ", nombre=" + nombre + ", tipoActividad=" + tipoActividad + ", descripcion=" + descripcion
				+ ", duracion=" + duracion + ", fecha=" + fecha + ", precio=" + precio + ", asistentesMinimos="
				+ asistentesMinimos + ", asistentesMaximos=" + asistentesMaximos + ", lugar=" + lugar
				+ ", puntoLlegada=" + puntoLlegada + ", horaLlegada=" + horaLlegada + "]";
	}
	
	
	
	
}


