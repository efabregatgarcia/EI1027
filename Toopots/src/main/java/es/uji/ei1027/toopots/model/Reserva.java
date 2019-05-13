package es.uji.ei1027.toopots.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Reserva {
	private String idReserva;
	private String idActividad;
	private String emailCliente;
	private String estadoPagamiento;
	private String numeroTransaccion;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fecha;
	private int numeroAsistentes;
	private int precioPersona;
	public String getIdReserva() {
		return idReserva;
	}
	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}
	public String getIdActividad() {
		return idActividad;
	}
	public void setIdActividad(String idActividad) {
		this.idActividad = idActividad;
	}
	public String getemailCliente() {
		return emailCliente;
	}
	public void setemailCliente(String idCliente) {
		this.emailCliente = emailCliente;
	}
	public String getEstadoPagamiento() {
		return estadoPagamiento;
	}
	public void setEstadoPagamiento(String estadoPagamiento) {
		this.estadoPagamiento = estadoPagamiento;
	}
	public String getNumeroTransaccion() {
		return numeroTransaccion;
	}
	public void setNumeroTransaccion(String numeroTransaccion) {
		this.numeroTransaccion = numeroTransaccion;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public int getNumeroAsistentes() {
		return numeroAsistentes;
	}
	public void setNumeroAsistentes(int numeroAsistentes) {
		this.numeroAsistentes = numeroAsistentes;
	}
	public int getPrecioPersona() {
		return precioPersona;
	}
	public void setPrecioPersona(int precioPersona) {
		this.precioPersona = precioPersona;
	}
	@Override
	public String toString() {
		return "Reserva [idReserva=" + idReserva + ", idActividad=" + idActividad + ", emailCliente=" + emailCliente
				+ ", estadoPagamiento=" + estadoPagamiento + ", numeroTransaccion=" + numeroTransaccion + ", fecha="
				+ fecha + ", numeroAsistentes=" + numeroAsistentes + ", precioPersona=" + precioPersona + "]";
	}
	
}
