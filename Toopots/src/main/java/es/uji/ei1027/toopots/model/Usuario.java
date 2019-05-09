package es.uji.ei1027.toopots.model;

import es.uji.ei1027.toopots.enumeracion.EnumTipoUsuario;

public class Usuario {
	String idUsuario;
	String password; 
	EnumTipoUsuario enumTipo;
	
	public String getIdUsuario() {
		return idUsuario; 
	}

	public void setIdUsuario(String idUsuario) {
	    this.idUsuario = idUsuario; 
	}

	public String getPassword() {
	   return password; 
	}

	public void setPassword(String password) {
	   this.password = password;
	}
	public EnumTipoUsuario getEnumTipoUsuario() {
		return this.enumTipo;
		
	}
	public boolean isCliente() {
		if (enumTipo == EnumTipoUsuario.CLIENTE) {
			return true;
		}
		return false;
	}
	public boolean isInstructor() {
		
		if (enumTipo == EnumTipoUsuario.INSTRUCTOR) {
			return true;
		}
		return false;
	}
	public boolean isAdministrador() {
		
		if (enumTipo == EnumTipoUsuario.Administrador) {
			return true;
		}
		return false;
	}	

}