package es.uji.ei1027.toopots.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.toopots.model.Reserva;

@Repository
public class ReservaDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/* Añade la actividad a la base de datos */
	public void addReserva(Reserva reserva) {
		jdbcTemplate.update("INSERT INTO reserva VALUES(?, ?, ?, ?, ?, ?, ?, ?)", reserva.getIdReserva(),
				reserva.getIdActividad(), reserva.getemailCliente(), reserva.getEstadoPagamiento(),
				reserva.getNumeroTransaccion(), reserva.getFecha(), reserva.getNumeroAsistentes(),
				reserva.getPrecioPersona());
	}

	public void deleteReserva(String reserva) {
		jdbcTemplate.update("DELETE from reserva where idReserva=?", reserva);
	}

	public void deleteReserva(Reserva reserva) {
		jdbcTemplate.update("DELETE from reserva where idReserva=?", reserva.getIdReserva());
	}

	/*
	 * Actualiza los atributos de la actividad (menos la idActividad y idInstructor
	 * que son claves primarias)
	 */
	public void updateReserva(Reserva reserva) {
		jdbcTemplate.update(
				"UPDATE reserva SET estadoPagamento=?, numeroTransacion=?, fecha=?, numeroAsistentes=?, precioPersona=?",
				reserva.getEstadoPagamiento(), reserva.getNumeroTransaccion(), reserva.getFecha(),
				reserva.getNumeroAsistentes(), reserva.getPrecioPersona());
	}

	/*
	 * Obtiene la actividad a partir de su IdActividad. Devuelve nulo si no existe.
	 */
	public Reserva getReserva(Reserva idReserva) {
		try {
			return jdbcTemplate.queryForObject("SELECT * from reserva WHERE idReserva=?", new ReservaRowMapper(),
					idReserva.getIdReserva());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public Reserva getReserva(String idReserva) {
		try {
			return jdbcTemplate.queryForObject("SELECT * from reserva WHERE idReserva=?", new ReservaRowMapper(),
					idReserva);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	/* Obtiene todas las actividades. Devuelve una lista vacia si no existe. */
	public List<Reserva> getReservas() {
		try {
			return jdbcTemplate.query("SELECT * from reserva", new ReservaRowMapper());
		} catch (EmptyResultDataAccessException e) {
			return new ArrayList<Reserva>();
		}
	}
}