package es.uji.ei1027.toopots.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Historico {

	/* id_reserva, id_actividad, id_cliente, horaInicio, estado,
	 * numParticip, fechaReserva, fechaActividad, fechaCierre */
	
	private int id_reserva;
	private int id_actividad;
	private int id_cliente;
	private Hora horaInicio;
	private Estado estado;
	private int numParticip;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fechaReserva;
	private Date fechaActividad;
	private Date fechaCierre;
	
	public int getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	public int getId_actividad() {
		return id_actividad;
	}
	public void setId_actividad(int id_actividad) {
		this.id_actividad = id_actividad;
	}
	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public Hora getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Hora horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	public int getNumParticip() {
		return numParticip;
	}
	public void setNumParticip(int numParticip) {
		this.numParticip = numParticip;
	}
	public Date getFechaReserva() {
		return fechaReserva;
	}
	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}
	public Date getFechaActividad() {
		return fechaActividad;
	}
	public void setFechaActividad(Date fechaActividad) {
		this.fechaActividad = fechaActividad;
	}
	public Date getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}
	
}
