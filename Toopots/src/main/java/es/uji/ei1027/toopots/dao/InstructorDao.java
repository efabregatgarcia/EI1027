package es.uji.ei1027.toopots.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.toopots.model.Instructor;

@Repository
public class InstructorDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/* Añade el intructor a la base de datos */
	public void addInstructor(Instructor instructor) {
		jdbcTemplate.update("INSERT INTO instructor VALUES(?, ?, ?, ?, ?)", instructor.getEmailInstructor(),
				instructor.getEstado(), instructor.getNombre(), instructor.getDomicilio(), instructor.getIban());
	}

	public void deleteInstructor(String instructor) {
		jdbcTemplate.update("DELETE from instructor where emailInstructor=?", instructor);
	}

	/*
	 * Actualiza los atributos del instructor (menos la idInstructor que es clave
	 * primarias)
	 */
	public void updateInstructor(Instructor instructor) {
		jdbcTemplate.update("UPDATE instructor SET  estado=?, nombre=?, domicilio=?, iban=? WHERE emailInstructor=?",
				instructor.getEstado(), instructor.getNombre(), instructor.getDomicilio(), instructor.getIban(),
				instructor.getEmailInstructor());
	}

	/*
	 * Obtiene el instructor a partir de su idInstructor. Devuelve nulo si no
	 * existe.
	 */
	public Instructor getInstructor(String emailInstructor) {
		try {
			return jdbcTemplate.queryForObject("SELECT * from instructor WHERE emailInstructor=?",
					new InstructorRowMapper(), emailInstructor);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/* Obtiene todos los intructores. Devuelve una lista vacia si no existe. */
	public List<Instructor> getInstructores() {
		try {
			return jdbcTemplate.query("SELECT * from instructor", new InstructorRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return new ArrayList<Instructor>();
		}
	}
}
