package es.uji.ei1027.toopots.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import es.uji.ei1027.toopots.model.Actividad;
import es.uji.ei1027.toopots.model.Cliente;

public class ClienteDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	
	public void addActividad(Cliente cliente) {
		jdbcTemplate.update("INSERT INTO cliente VALUES(?,?,?,?,?)",
				cliente.getIdCliente(), cliente.getNombre(), cliente.getEmail(), cliente.getSexo(), cliente.getFechaNacimiento());
	}
	
	public void deleteCliente(String cliente) {
		jdbcTemplate.update("DELETE from cliente where idCliente=?", cliente);
	}
	
	public void updateCliente(Cliente cliente) {
		jdbcTemplate.update("UPDATE cliente SET nombre=?, email=?, sexo=?",
				cliente.getNombre(), cliente.getEmail(), cliente.getSexo());
	}

}
