package es.uji.ei1027.toopots.dao;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.NaturAdventure.domain.MonitorReserva;

@Repository
public class MonitorReservaDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource( DataSource dataSource ) {
		this.jdbcTemplate = new JdbcTemplate( dataSource );
	}
	
	private static final class MonitorReservaMapper implements RowMapper<MonitorReserva> {
		/* id_monitor, id_reserva */
		
		@Override
		public MonitorReserva mapRow(ResultSet rs, int rowNum) throws SQLException {
			MonitorReserva reservaMonitor = new MonitorReserva();
			reservaMonitor.setId_reserva(rs.getInt("id_reserva"));
			reservaMonitor.setId_monitor(rs.getInt("id_monitor"));
			return reservaMonitor;
		}
	}
	
	public List<MonitorReserva> getMonitoresReserva() {
		return this.jdbcTemplate.query(
				"SELECT * FROM MonitoresReserva ORDER BY id_monitor ASC"
				, new MonitorReservaMapper());
	}
	
	public List<MonitorReserva> getMonitoresReserva( int id_monitor ) {
		return this.jdbcTemplate.query(
				"SELECT * FROM MonitoresReserva WHERE id_monitor = ?", new Object[] {id_monitor}
				, new MonitorReservaMapper());
	}
	
	public void addMonitorReserva( MonitorReserva reservaMonitor ) {
		this.jdbcTemplate.update(
				"INSERT INTO "
				+ "MonitoresReserva( id_reserva ,id_monitor ) "
				+ "values ( ?, ?)"
				, reservaMonitor.getId_reserva(), reservaMonitor.getId_monitor()
				);
		this.jdbcTemplate.update(
				"UPDATE Reservas SET estado = 'aceptada' WHERE id_reserva = ?"
				, reservaMonitor.getId_reserva() );		
	}
	
	public void deleteMonitorReserva( MonitorReserva reservaMonitor ) {
		this.jdbcTemplate.update(
				"DELETE FROM MonitoresReserva WHERE id_monitor = ? AND id_reserva = ?"
				, reservaMonitor.getId_monitor(), reservaMonitor.getId_reserva() );
	}
	
	public void deleteMonitoresReserva( int id_monitor ) {
		this.jdbcTemplate.update(
				"DELETE FROM MonitoresReserva WHERE id_monitor = ?"
				, id_monitor );
	}
	
	public void deleteReserva( int id_reserva ) {
		this.jdbcTemplate.update(
				"DELETE FROM MonitoresReserva WHERE id_reserva = ?"
				, id_reserva );
	}
	
	
}
