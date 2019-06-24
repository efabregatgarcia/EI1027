package es.uji.ei1027.toopots.dao;

import org.jasypt.util.password.BasicPasswordEncryptor; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.NaturAdventure.domain.*;

@Repository
public class EmpleadoProvider {

	private EmpleadoDao empleadoDao;
	private UserDetails userDetails = new UserDetails();
	
	@Autowired
	public void setEmpleadoDao( EmpleadoDao empleadoDao ) {
		this.empleadoDao = empleadoDao;
	}

	public UserDetails loadUserByUsername(String username, String password) {
		Empleado empleado = empleadoDao.getEmpleadoByLogin(username.trim());
		
		if (empleado == null)
			return null; // Empleado no encontrado
		
		// Comprobar la contrase�a
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor(); 
		if (passwordEncryptor.checkPassword(password, empleado.getPasswd())) {
			userDetails.setUsername(username);
			userDetails.setPassword(password);
			userDetails.setGrupo(empleado.getGrupo());
			return userDetails; 
			
		} else {
			
			return null; // bad login!
			
		}
	}

}