package es.uji.ei1027.toopots.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.toopots.util.Cliente;

@Repository
public class ClienteDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);

	}

	public void addCliente(Cliente cliente) {
		jdbcTemplate.update("INSERT INTO cliente VALUES(?,?,?,?)", cliente.getEmailCliente(), cliente.getNombre(), cliente.getSexo(), cliente.getFechaNacimiento());
	}

	public void deleteCliente(String cliente) {
		jdbcTemplate.update("DELETE from cliente where emailCliente=?", cliente);
	}

	public void updateCliente(Cliente cliente) {
		jdbcTemplate.update("UPDATE cliente SET nombre=?, sexo=?, fechaNacimiento=? WHERE emailCliente=?", cliente.getNombre(),
				cliente.getSexo(), cliente.getFechaNacimiento(), cliente.getEmailCliente());
	}

	/*
	 * Obtiene el cliente a partir de su IdCliente. Devuelve nulo si no existe.
	 */
	public Cliente getCliente(Cliente idCliente) {
		try {
			return jdbcTemplate.queryForObject("SELECT * from cliente WHERE emailCliente=?", new ClienteRowMapper(),
					idCliente.getEmailCliente());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public Cliente getCliente(String idCliente) {
		try {
			return jdbcTemplate.queryForObject("SELECT * from cliente WHERE emailCliente=?", new ClienteRowMapper(),
					idCliente);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public List<Cliente> getClientes() {
		try {
			return jdbcTemplate.query("SELECT * from cliente", new ClienteRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return new ArrayList<Cliente>();
		}
	}

}
