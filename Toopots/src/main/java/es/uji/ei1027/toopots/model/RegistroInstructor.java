package es.uji.ei1027.toopots.model;

public class RegistroInstructor {
	
	private String idRegistro;
	private String idInstructor;
	private String nombre;
	private String direccion;
	private String dni;
	private String telefono;
	private String curriculum;
	private String aptitudes;
	
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getIdRegistro() {
		return idRegistro;
	}
	public void setIdRegistro(String idRegistro) {
		this.idRegistro = idRegistro;
	}
	public String getIdInstructor() {
		return idInstructor;
	}
	public void setIdInstructor(String idInstructor) {
		this.idInstructor = idInstructor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCurriculum() {
		return curriculum;
	}
	public void setCurriculum(String curriculum) {
		this.curriculum = curriculum;
	}
	public String getAptitudes() {
		return aptitudes;
	}
	public void setAptitudes(String aptitudes) {
		this.aptitudes = aptitudes;
	}
	@Override
	public String toString() {
		return "RegistroInstructor [idRegistro=" + idRegistro + ", idInstructor=" + idInstructor + ", nombre=" + nombre
				+ ", direccion=" + direccion + ", dni=" + dni + ", telefono=" + telefono + ", curriculum=" + curriculum
				+ ", aptitudes=" + aptitudes + "]";
	}
	
	
}
