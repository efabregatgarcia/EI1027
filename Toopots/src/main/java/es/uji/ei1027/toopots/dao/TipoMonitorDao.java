package es.uji.ei1027.toopots.dao;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.NaturAdventure.domain.TipoMonitor;

@Repository
public class TipoMonitorDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource( DataSource dataSource ) {
		this.jdbcTemplate = new JdbcTemplate( dataSource );
	}
	
	private static final class TipoMonitorMapper implements RowMapper<TipoMonitor> {
		/* id_monitor, id_tipo */
		
		@Override
		public TipoMonitor mapRow(ResultSet rs, int rowNum) throws SQLException {
			TipoMonitor tipoMonitor = new TipoMonitor();
			tipoMonitor.setId_monitor(rs.getInt("id_monitor"));
			tipoMonitor.setId_tipo(rs.getInt("id_tipo"));
			return tipoMonitor;
		}
	}
	
	public List<TipoMonitor> getTiposMonitor() {
		return this.jdbcTemplate.query(
				"SELECT * FROM TiposMonitor ORDER BY id_monitor ASC"
				, new TipoMonitorMapper());
	}
	
	public List<TipoMonitor> getTiposMonitor( int id_monitor ) {
		return this.jdbcTemplate.query(
				"SELECT * FROM TiposMonitor WHERE id_monitor = ?", new Object[] {id_monitor}
				, new TipoMonitorMapper());
	}
	
	public void addTipoMonitor( TipoMonitor tipoMonitor ) {
		this.jdbcTemplate.update(
				"INSERT INTO "
				+ "TiposMonitor( id_monitor, id_tipo ) "
				+ "values ( ?, ?)"
				, tipoMonitor.getId_monitor(), tipoMonitor.getId_tipo()
				);
	}
	
	public void deleteTipoMonitor( TipoMonitor tipoMonitor ) {
		this.jdbcTemplate.update(
				"DELETE FROM TiposMonitor WHERE id_monitor = ? AND id_tipo = ?"
				, tipoMonitor.getId_monitor(), tipoMonitor.getId_tipo() );
	}
	
	public void deleteTiposMonitor( int id_monitor ) {
		this.jdbcTemplate.update(
				"DELETE FROM TiposMonitor WHERE id_monitor = ?"
				, id_monitor );
	}
	
}
