package es.uji.ei1027.toopots.dao;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.NaturAdventure.domain.*;

@Repository
public class ReservaDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource( DataSource dataSource ) {
		this.jdbcTemplate = new JdbcTemplate( dataSource );
	}
	
	private static final class ReservaMapper implements RowMapper<Reserva> {
		/* id_reserva, id_actividad, id_cliente, horaInicio, estado,
		 * numParticip, fechaReserva, fechaActividad */
		
		@Override
		public Reserva mapRow(ResultSet rs, int rowNum) throws SQLException {
			Reserva reserva = new Reserva();
			reserva.setId_reserva(rs.getInt("id_reserva"));
			reserva.setId_actividad(rs.getInt("id_actividad"));
			reserva.setId_cliente(rs.getInt("id_cliente"));
			reserva.setHoraInicio(Hora.valueOf(rs.getString("horaInicio")));
			reserva.setEstado(Estado.valueOf(rs.getString("estado")));
			reserva.setNumParticip(rs.getInt("numParticip"));
			reserva.setFechaReserva(rs.getDate("fechaReserva"));
			reserva.setFechaActividad(rs.getDate("fechaActividad"));
			return reserva;
		}
	}
	
	public List<Reserva> getReservas() {
		return this.jdbcTemplate.query(
				"SELECT * FROM Reservas ORDER BY id_reserva DESC"
				, new ReservaMapper());
	}
	
	public List<Reserva> getReservasMonitor( int id_monitor ) {
		return this.jdbcTemplate.query(
				"SELECT  *"
				+ " FROM Reservas INNER JOIN MonitoresReserva ON (Reservas.id_reserva = MonitoresReserva.id_reserva)"
				+ " WHERE id_monitor = ? ORDER BY fechaActividad ASC", new Object[] {id_monitor}
				, new ReservaMapper());
	}
	
	public List<Reserva> getReservasCliente( int id_cliente ) {
		return this.jdbcTemplate.query(
				"SELECT * FROM Reservas WHERE id_cliente = ? ORDER BY id_reserva DESC", new Object[] {id_cliente}
				, new ReservaMapper());
	}
	
	public Reserva getReserva( int id_reserva ) {
		return this.jdbcTemplate.queryForObject(
				"SELECT * FROM Reservas WHERE id_reserva = ?", new Object[] {id_reserva}
				, new ReservaMapper());
	}
	
	public void addReserva( Reserva reserva ) {
		this.jdbcTemplate.update(
				"INSERT INTO "
				+ "Reservas( id_reserva, id_actividad, id_cliente, horaInicio, estado,"
				+ " numParticip, fechaReserva, fechaActividad )"
				+ "values ( DEFAULT, ?, ?, CAST(? AS e_horaInicio), CAST(? AS e_estado), ?, CURRENT_DATE, ? )"
				, reserva.getId_actividad(), reserva.getId_cliente(), reserva.getHoraInicio().name()
				, reserva.getEstado().name(), reserva.getNumParticip()
				, reserva.getFechaActividad()
				);
	}
	
	public void updateReserva( Reserva reserva ) {
		this.jdbcTemplate.update(
				"UPDATE Reservas SET "
				+ " id_actividad = ?, id_cliente = ?, horaInicio = CAST(? AS e_horaInicio),"
				+ " estado = CAST(? AS e_estado), numParticip = ?, fechaReserva = ?, fechaActividad = ? "
				+ "WHERE id_reserva = ?"
				, reserva.getId_actividad(), reserva.getId_cliente(), reserva.getHoraInicio().name()
				, reserva.getEstado().name(), reserva.getNumParticip()
				, reserva.getFechaReserva(), reserva.getFechaActividad()
				, reserva.getId_reserva()
				);
	}
	
	public void deleteReserva( int id_reserva ) {
		this.jdbcTemplate.update(
				"DELETE FROM Reservas WHERE id_reserva = ?"
				, id_reserva );
	}
	
	public void rechazarReserva( int id_reserva ) {
		this.jdbcTemplate.update(
				"UPDATE Reservas SET estado = 'rechazada' WHERE id_reserva = ?"
				, id_reserva );
	}
	
}
