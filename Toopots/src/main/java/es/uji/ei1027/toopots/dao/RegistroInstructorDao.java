package es.uji.ei1027.toopots.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.toopots.util.RegistroInstructor;

@Repository
public class RegistroInstructorDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/* Añade el registro de instructor a la base de datos */
	public void addRegistroInstructor(RegistroInstructor registroInstructor) {
		jdbcTemplate.update("INSERT INTO registroInstructor VALUES(?, ?, ?, ?, ?, ?, ?)",
				registroInstructor.getIdRegistro(), registroInstructor.getEmailInstructor(),
				registroInstructor.getNombre(), registroInstructor.getDireccion(), registroInstructor.getDni(),
				registroInstructor.getTelefono(), registroInstructor.getCurriculum());
	}

	public void deleteRegistroInstructor(String registroInstructor) {
		jdbcTemplate.update("DELETE from registroInstructor where idRegistro=?", registroInstructor);
	}

	/*
	 * Actualiza los atributos del registro instructor (menos la idRegistro que es
	 * clave primarias e idInstructor que es clave ajena)
	 */
	public void updateRegistroInstructor(RegistroInstructor registroInstructor) {
		jdbcTemplate.update(
				"UPDATE registroInstructor SET nombre=?, direccion=?, dni=?, telefono=?, curriculum=? WHERE idRegistro=?",
				registroInstructor.getNombre(), registroInstructor.getDireccion(), registroInstructor.getDni(),
				registroInstructor.getTelefono(), registroInstructor.getCurriculum(), registroInstructor.getIdRegistro());
	}

	/*
	 * Obtiene el registro instructor a partir de su idRegistro. Devuelve nulo si no
	 * existe.
	 */
	public RegistroInstructor getRegistroInstructor(String idRegistro) {
		try {
			return jdbcTemplate.queryForObject("SELECT * from registroInstructor WHERE idRegistro=?",
					new RegistroInstructorRowMapper(), idRegistro);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/*
	 * Obtiene todos los registros de intructores. Devuelve una lista vacia si no
	 * existe.
	 */
	public List<RegistroInstructor> getRegistroInstructores() {
		try {
			return jdbcTemplate.query("SELECT * from registroInstructor", new RegistroInstructorRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return new ArrayList<RegistroInstructor>();
		}
	}
}
