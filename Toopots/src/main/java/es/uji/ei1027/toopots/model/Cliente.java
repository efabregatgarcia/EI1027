package es.uji.ei1027.toopots.model;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Cliente {

	
	private String nombre;
	private String emailCliente;
	private String sexo;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDate fechaNacimiento;


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String email) {
		this.emailCliente = emailCliente;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", emailCliente=" + emailCliente + ", sexo=" + sexo + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}



}
