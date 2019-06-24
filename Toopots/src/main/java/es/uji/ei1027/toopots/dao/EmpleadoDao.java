package es.uji.ei1027.toopots.dao;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.jasypt.util.password.BasicPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.toopots.domain.Empleado;
import es.uji.ei1027.toopots.domain.Grupo;

@Repository
public class EmpleadoDao {

	private JdbcTemplate jdbcTemplate;
	private BasicPasswordEncryptor passwordEncryptor = new BasicPasswordEncryptor();
	
	@Autowired
	public void setDataSource( DataSource dataSource ) {
		this.jdbcTemplate = new JdbcTemplate( dataSource );
	}
	
	private static final class EmpleadoMapper implements RowMapper<Empleado> {
		/* id_empleado, grupo, nombre, email, login, passwd */
		
		@Override
		public Empleado mapRow(ResultSet rs, int rowNum) throws SQLException {
			Empleado empleado = new Empleado();
			empleado.setId_empleado(rs.getInt("id_empleado"));
			empleado.setGrupo(Grupo.valueOf(rs.getString("grupo")));
			empleado.setNombre(rs.getString("nombre"));
			empleado.setEmail(rs.getString("email"));
			empleado.setLogin(rs.getString("login"));
			empleado.setPasswd(rs.getString("passwd"));
			return empleado;
		}
	}
	
	public List<Empleado> getEmpleados() {
		return this.jdbcTemplate.query(
				"SELECT * FROM Empleados ORDER BY id_empleado DESC"
				, new EmpleadoMapper());
	}
	
	public List<Empleado> getEmpleadosMenos( int id_empleado ) {
		return this.jdbcTemplate.query(
				"SELECT * FROM Empleados "
				+ "WHERE id_empleado != ? ORDER BY id_empleado DESC", new Object[] {id_empleado}
				, new EmpleadoMapper());
	}
	
	public List<Empleado> getEmpleados(Grupo grupo) {
		return this.jdbcTemplate.query(
				"SELECT * FROM Empleados WHERE grupo = CAST(? AS e_grupo) ORDER BY id_empleado ASC", new Object[] {grupo.name()}
				, new EmpleadoMapper());
	}
	
	public Empleado getEmpleado( int id ) {
		return this.jdbcTemplate.queryForObject(
				"SELECT * FROM Empleados WHERE id_empleado = ?", new Object[] {id}
				, new EmpleadoMapper());
	}
	
	public Empleado getEmpleadoByLogin( String login ) {
		// Esta funcion se utiliza en el login, pero es posible que el login que nos
		// pasa el formulario no exista en la BD. Por lo tanto hay que ir con cuidado
		// y devolver un nulo cuando esto ocurra.
		try {
			return this.jdbcTemplate.queryForObject(
				"SELECT * FROM Empleados WHERE login = ?", new Object[] {login}
				, new EmpleadoMapper());
		} catch ( EmptyResultDataAccessException ex ) {
			return null;
		}
	}
	
	public void addEmpleado( Empleado empleado ) {
		String encryptedPasswd = passwordEncryptor.encryptPassword(empleado.getPasswd());
		this.jdbcTemplate.update(
				"INSERT INTO "
				+ "Empleados( id_empleado, grupo, nombre, email, login, passwd )"
				+ "values ( DEFAULT, CAST(? AS e_grupo), ?, ?, ?, ? )"
				, empleado.getGrupo().name(), empleado.getNombre(), empleado.getEmail()
				, empleado.getLogin(), encryptedPasswd
				);
	}
	
	public void updateEmpleado( Empleado empleado ) {
		this.jdbcTemplate.update(
				"UPDATE Empleados SET "
				+ "grupo = CAST(? AS e_grupo), nombre = ?, email = ? "
				+ "WHERE id_empleado = ?"
				, empleado.getGrupo().name(), empleado.getNombre(), empleado.getEmail()
				, empleado.getId_empleado()
				);
	}
	
	public void deleteEmpleado( int id ) {
		this.jdbcTemplate.update(
				"DELETE FROM Empleados WHERE id_empleado = ?"
				, id );
	}
}
