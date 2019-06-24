package es.uji.ei1027.toopots.model;

import es.uji.ei1027.toopots.domain.EnumTipoUsuario.EnumTipoUsuarios;

public class Usuario {
	String emailUsuario;
	String contrasenya; 
	EnumTipoUsuarios enumTipo;
	
	
	public String getEmailUsuario() {
		return emailUsuario;
	}
	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	public String getContrasenya() {
		return contrasenya;
	}
	public void setContrasenya(String contrasenya) {
		this.contrasenya = contrasenya;
	}
	public EnumTipoUsuarios getEnumTipoUsuario() {
		return this.enumTipo;
		
	}
	public boolean isCliente() {
		if (enumTipo == EnumTipoUsuarios.CLIENTE) {
			return true;
		}
		return false;
	}
	public boolean isInstructor() {
		
		if (enumTipo == EnumTipoUsuarios.INSTRUCTOR) {
			return true;
		}
		return false;
	}
	public boolean isAdministrador() {
		
		if (enumTipo == EnumTipoUsuarios.ADMINISTRADOR) {
			return true;
		}
		return false;
	}

	public EnumTipoUsuarios getEnumTipo() {
		return enumTipo;
	}

	public void setEnumTipo(EnumTipoUsuarios enumTipo) {
		this.enumTipo = enumTipo;
	}	

}