package es.uji.ei1027.toopots.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.toopots.model.Actividad;

@Repository
public class ActividadDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/* Añade la actividad a la base de datos */
	public void addActividad(Actividad actividad) {
		jdbcTemplate.update("INSERT INTO actividad VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				actividad.getIdActividad(), actividad.getIdInstructor(), actividad.getEstado(), actividad.getNombre(),
				actividad.getNivelActividad(), actividad.getTipoActividad(), actividad.getDescripcion(),
				actividad.getDuracion(), actividad.getFecha(), actividad.getPrecio(), actividad.getAsistentesMinimos(),
				actividad.getAsistentesMaximos(), actividad.getLugar(), actividad.getPuntoLlegada(),
				actividad.getHoraLlegada());
	}

	public void deleteActividad(String actividad) {
		jdbcTemplate.update("DELETE from actividad where idActividad=?", actividad);
	}

	public void deleteActividad(Actividad actividad) {
		jdbcTemplate.update("DELETE from actividad where idActividad=?", actividad.getIdActividad());
	}

	/*
	 * Actualiza los atributos de la actividad (menos la idActividad y idInstructor
	 * que son claves primarias)
	 */
	public void updateActividad(Actividad actividad) {
		jdbcTemplate.update(
				"UPDATE actividad SET   estado=?, nombre=?, nivelActividad=?, tipoActividad=?, duracion=?, descripcion=?, fecha=?, "
						+ "precio=?, asistentesMinimos=?, asistentesMaximos=?, lugar=?, puntoLlegada=?, horaLlegada=? where idActividad=?",
				actividad.getEstado(), actividad.getNombre(), actividad.getNivelActividad(), actividad.getTipoActividad(), actividad.getDuracion(),
				actividad.getDescripcion(), actividad.getFecha(), actividad.getPrecio(),
				actividad.getAsistentesMinimos(), actividad.getAsistentesMaximos(), actividad.getLugar(),
				actividad.getPuntoLlegada(), actividad.getHoraLlegada(), actividad.getIdActividad());
	}

	/*
	 * Obtiene la actividad a partir de su IdActividad. Devuelve nulo si no existe.
	 */
	public Actividad getActividad(Actividad idActividad) {
		try {
			return jdbcTemplate.queryForObject("SELECT * from actividad WHERE idActividad=?", new ActividadRowMapper(),
					idActividad.getIdActividad());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public Actividad getActividad(String idActividad) {
		try {
			return jdbcTemplate.queryForObject("SELECT * from actividad WHERE idActividad=?", new ActividadRowMapper(),
					idActividad);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/* Obtiene todas las actividades. Devuelve una lista vacia si no existe. */
	public List<Actividad> getActividades() {
		try {
			return jdbcTemplate.query("SELECT * from actividad", new ActividadRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return new ArrayList<Actividad>();
		}
	}
}
