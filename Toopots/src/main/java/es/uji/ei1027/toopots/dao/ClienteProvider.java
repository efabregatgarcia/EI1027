package es.uji.ei1027.toopots.dao;

import org.jasypt.util.password.BasicPasswordEncryptor; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.toopots.domain.*;

@Repository
public class ClienteProvider {

	private ClienteDao clienteDao;
	private UserDetails userDetails = new UserDetails();
	
	@Autowired
	public void setClienteDao( ClienteDao clienteDao ) {
		this.clienteDao = clienteDao;
	}

	public UserDetails loadUserByUsername(String username, String password) {
		Cliente cliente = clienteDao.getClienteByLogin(username.trim());
		
		if (cliente == null)
			return null; // Cliente no encontrado
		
		// Comprobar la contrase�a
		BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor(); 
		if (passwordEncryptor.checkPassword(password, cliente.getPasswd())) {
			userDetails.setUsername(username);
			userDetails.setPassword(password);
			return userDetails; 
			
		} else {
			
			return null; // bad login!
			
		}
	}

}