package es.uji.ei1027.toopots.model;

import es.uji.ei1027.toopots.enumeracion.EnumTipoUsuario;
import es.uji.ei1027.toopots.enumeracion.EnumTipoUsuario.EnumTipoUsuarios;

public class Usuario {
	String idUsuario;
	String password; 
	EnumTipoUsuarios enumTipo;
	
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

}