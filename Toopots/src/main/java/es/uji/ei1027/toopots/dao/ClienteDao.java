package es.uji.ei1027.toopots.dao;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.toopots.domain.Cliente;

@Repository
public class ClienteDao {

	private JdbcTemplate jdbcTemplate;
	private BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
	
	@Autowired
	public void setDataSource( DataSource dataSource ) {
		this.jdbcTemplate = new JdbcTemplate( dataSource );
	}
	
	private static final class ClienteMapper implements RowMapper<Cliente> {
		/* id_cliente, nombre, apellidos, telefono, email, direccion, login, passwd */
		
		@Override
		public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
			Cliente cliente = new Cliente();
			cliente.setId_cliente(rs.getInt("id_cliente"));
			cliente.setNombre(rs.getString("nombre"));
			cliente.setApellidos(rs.getString("apellidos"));
			cliente.setTelefono(rs.getInt("telefono"));
			cliente.setEmail(rs.getString("email"));
			cliente.setDireccion(rs.getString("direccion"));
			cliente.setLogin(rs.getString("login"));
			cliente.setPasswd(rs.getString("passwd"));
			return cliente;
		}
	}
	
	public List<Cliente> getClientes() {
		return this.jdbcTemplate.query(
				"SELECT * FROM Clientes ORDER BY id_cliente DESC"
				, new ClienteMapper());
	}
	
	public Cliente getCliente( int id ) {
		return this.jdbcTemplate.queryForObject(
				"SELECT * FROM Clientes WHERE id_cliente = ?", new Object[] {id}
				, new ClienteMapper());
	}
	
	public Cliente getClienteByLogin( String login ) {
		// Esta funcion se utiliza en el login, pero es posible que el login que nos
		// pasa el formulario no exista en la BD. Por lo tanto hay que ir con cuidado
		// y devolver un nulo cuando esto ocurra.
		try {
			return this.jdbcTemplate.queryForObject(
				"SELECT * FROM Clientes WHERE login = ?", new Object[] {login}
				, new ClienteMapper());
		} catch ( EmptyResultDataAccessException ex ) {
			return null;
		}
	}
	
	public void addCliente( Cliente cliente ) {
		// Hay que encriptar las contrase�as antes de meterlas en la base de datos
		String encryptedPasswd = passwordEncryptor.encryptPassword(cliente.getPasswd());
		this.jdbcTemplate.update(
				"INSERT INTO "
				+ "Clientes( id_cliente, nombre, apellidos, telefono, email, direccion, login, passwd )"
				+ "values ( DEFAULT, ?, ?, ?, ?, ?, ?, ? )"
				, cliente.getNombre(), cliente.getApellidos(), cliente.getTelefono()
				, cliente.getEmail(), cliente.getDireccion(), cliente.getLogin(), encryptedPasswd
				);
	}
	
	public void updateCliente( Cliente cliente ) {
		this.jdbcTemplate.update(
				"UPDATE Clientes SET "
				+ "nombre = ?, apellidos = ?, telefono = ?, email = ?, direccion = ?"
				+ "WHERE id_cliente = ?"
				, cliente.getNombre(), cliente.getApellidos(), cliente.getTelefono(), cliente.getEmail()
				, cliente.getDireccion(), cliente.getId_cliente()
				);
	}
	
	public boolean deleteCliente( int id ) {
		try{
			this.jdbcTemplate.update(
				"DELETE FROM Clientes WHERE id_cliente = ?"
				, id );
			return true;
		} catch ( DataIntegrityViolationException ex ) {
			return false;
		}
	}
	
	public boolean existeEmail( String email ) {
		Integer i = jdbcTemplate.queryForObject(
			    "SELECT count(*) FROM Clientes WHERE email = ?", new Object[] { email }, Integer.class);
		return i > 0;
	}
	
	
	public boolean existeLogin( String login ) {
		Integer i = jdbcTemplate.queryForObject(
			    "SELECT count(*) FROM Clientes WHERE login = ?", new Object[] { login }, Integer.class);
		return i > 0;
	}
	
}
