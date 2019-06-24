package es.uji.ei1027.toopots.dao;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.NaturAdventure.domain.Hora;
import es.uji.ei1027.NaturAdventure.domain.HoraInicio;

@Repository
public class HoraInicioDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource( DataSource dataSource ) {
		this.jdbcTemplate = new JdbcTemplate( dataSource );
	}
	
	private static final class HoraInicioMapper implements RowMapper<HoraInicio> {
		/* horaInicio, id_actividad */
		
		@Override
		public HoraInicio mapRow(ResultSet rs, int rowNum) throws SQLException {
			HoraInicio horaInicio = new HoraInicio();
			horaInicio.setHoraInicio(Hora.valueOf(rs.getString("horaInicio")));
			horaInicio.setId_actividad(rs.getInt("id_actividad"));
			return horaInicio;
		}
	}
		
	public List<HoraInicio> getHorasInicio() {
		return this.jdbcTemplate.query(
				"SELECT * FROM HorasInicio ORDER BY id_actividad ASC"
				, new HoraInicioMapper());
	}
	
	public List<HoraInicio> getHorasInicio( int id_actividad ) {
		return this.jdbcTemplate.query(
				"SELECT * FROM HorasInicio WHERE id_actividad = ?", new Object[] {id_actividad}
				, new HoraInicioMapper());
	}
	
	public void addHoraInicio( HoraInicio horaInicio ) {
		this.jdbcTemplate.update(
				"INSERT INTO "
				+ "HorasInicio( horaInicio, id_actividad )"
				+ "values ( CAST(? AS e_horaInicio), ?)"
				, horaInicio.getHoraInicio().name(), horaInicio.getId_actividad()
				);
	}
	
	public void updateHoraInicio( HoraInicio horaInicio ) {
		this.jdbcTemplate.update(
				"UPDATE HorasInicio SET "
				+ " id_actividad = ? "
				+ "WHERE horaInicio = CAST(? AS e_horaInicio)"
				, horaInicio.getId_actividad(), horaInicio.getHoraInicio().name()
				);
	}
	
	public void deleteHoraInicio( int id_actividad, Hora horaInicio ) {
		this.jdbcTemplate.update(
				"DELETE FROM HorasInicio WHERE id_actividad = ? AND horaInicio = CAST(? AS e_horaInicio)"
				, id_actividad, horaInicio.name() );
	}
	
	public void deleteHorasInicio( int id_actividad ) {
		this.jdbcTemplate.update(
				"DELETE FROM HorasInicio WHERE id_actividad = ?"
				, id_actividad );
	}
	
}
