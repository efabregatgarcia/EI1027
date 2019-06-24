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
public class HistoricoDao {

	private JdbcTemplate jdbcTemplate;
	private ReservaDao reservaDao;
	private MonitorReservaDao monitorReservaDao;
	
	@Autowired
	public void setDataSource( DataSource dataSource ) {
		this.jdbcTemplate = new JdbcTemplate( dataSource );
	}
	
	@Autowired
	public void setReservaDao( ReservaDao reservaDao, MonitorReservaDao monitorReserva ) {
		this.reservaDao = reservaDao;
		this.monitorReservaDao = monitorReserva;
	}
	
	private static final class HistoricoMapper implements RowMapper<Historico> {
		/* id_historico, id_actividad, id_liente, horaInicio, estado,
		 * numParticip, fechaReserva, fechaActividad, fechaCierre */
		
		@Override
		public Historico mapRow(ResultSet rs, int rowNum) throws SQLException {
			Historico historico = new Historico();
			historico.setId_reserva(rs.getInt("id_reserva"));
			historico.setId_actividad(rs.getInt("id_actividad"));
			historico.setId_cliente(rs.getInt("id_cliente"));
			historico.setHoraInicio(Hora.valueOf(rs.getString("horaInicio")));
			historico.setEstado(Estado.valueOf(rs.getString("estado")));
			historico.setNumParticip(rs.getInt("numParticip"));
			historico.setFechaReserva(rs.getDate("fechaReserva"));
			historico.setFechaActividad(rs.getDate("fechaActividad"));
			historico.setFechaCierre(rs.getDate("fechaCierre"));
			return historico;
		}
	}
	
	public List<Historico> getHistoricos() {
		return this.jdbcTemplate.query(
				"SELECT * FROM Historico ORDER BY id_reserva ASC"
				, new HistoricoMapper());
	}
	
	public Historico getHistorico( int id_reserva ) {
		return this.jdbcTemplate.queryForObject(
				"SELECT * FROM Historico WHERE id_reserva = ?", new Object[] {id_reserva}
				, new HistoricoMapper());
	}
	
	public void addHistorico( int id_reserva ) {
		
		// Obtener los datos de la reserva a archivar
		Reserva reserva = reservaDao.getReserva(id_reserva);
		
		// Copiar la reserva en la tabla Historico
		this.jdbcTemplate.update(
				"INSERT INTO "
				+ "Historico( id_reserva, id_actividad, id_cliente, horaInicio, estado,"
				+ " numParticip, fechaReserva, fechaActividad, fechaCierre )"
				+ "values ( ?, ?, ?, CAST(? AS e_horaInicio), CAST(? AS e_estado), ?, ?, ?, CURRENT_DATE)"
				, reserva.getId_reserva(), reserva.getId_actividad(), reserva.getId_cliente(), reserva.getHoraInicio().name()
				, reserva.getEstado().name(), reserva.getNumParticip()
				, reserva.getFechaReserva(), reserva.getFechaActividad()
				);
		
		// Eliminar las asignaciones en monitorReserva
		monitorReservaDao.deleteReserva(id_reserva);
		
		// Eliminar la reserva de la tabla de reservas
		reservaDao.deleteReserva(id_reserva);
		
	}
	
	public void deleteHistorico( int id_reserva ) {
		this.jdbcTemplate.update(
				"DELETE FROM Historico WHERE id_reserva = ?"
				, id_reserva );
	}
	
}
