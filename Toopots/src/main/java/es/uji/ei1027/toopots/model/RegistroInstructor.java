package es.uji.ei1027.toopots.model;

public class RegistroInstructor {
	
	private String idRegistro;
	private String emailInstructor;
	private String nombre;
	private String direccion;
	private String dni;
	private String telefono;
	private String curriculum;

	
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
	public String getEmailInstructor() {
		return emailInstructor;
	}
	public void setEmailInstructor(String emailInstructor) {
		this.emailInstructor = emailInstructor;
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
	@Override
	public String toString() {
		return "RegistroInstructor [idRegistro=" + idRegistro + ", emailInstructor=" + emailInstructor + ", nombre="
				+ nombre + ", direccion=" + direccion + ", dni=" + dni + ", telefono=" + telefono + ", curriculum="
				+ curriculum + "]";
	}
	
	

	
	
}
