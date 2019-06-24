package es.uji.ei1027.toopots.dao;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.toopots.domain.TipoActividad;

@Repository
public class TipoActividadDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource( DataSource dataSource ) {
		this.jdbcTemplate = new JdbcTemplate( dataSource );
	}
	
	private static final class TipoActividadMapper implements RowMapper<TipoActividad> {
		/* id_actividad, id_tipo */
		
		@Override
		public TipoActividad mapRow(ResultSet rs, int rowNum) throws SQLException {
			TipoActividad tipoActividad = new TipoActividad();
			tipoActividad.setId_actividad(rs.getInt("id_actividad"));
			tipoActividad.setId_tipo(rs.getInt("id_tipo"));
			return tipoActividad;
		}
	}
	
	public List<TipoActividad> getTiposActividad() {
		return this.jdbcTemplate.query(
				"SELECT * FROM TiposActividad ORDER BY id_actividad ASC"
				, new TipoActividadMapper());
	}
	
	public List<TipoActividad> getTiposActividad( int id_actividad ) {
		return this.jdbcTemplate.query(
				"SELECT * FROM TiposActividad WHERE id_actividad = ?", new Object[] {id_actividad}
				, new TipoActividadMapper());
	}
	
	public void addTipoActividad( TipoActividad tipoActividad ) {
		this.jdbcTemplate.update(
				"INSERT INTO "
				+ "TiposActividad( id_actividad, id_tipo ) "
				+ "values ( ?, ?)"
				, tipoActividad.getId_actividad(), tipoActividad.getId_tipo()
				);
	}
	
	public void deleteTipoActividad( TipoActividad tipoActividad ) {
		this.jdbcTemplate.update(
				"DELETE FROM TiposActividad WHERE id_actividad = ? AND id_tipo = ?"
				, tipoActividad.getId_actividad(), tipoActividad.getId_tipo() );
	}
	
	public void deleteTiposActividad( int id_actividad ) {
		this.jdbcTemplate.update(
				"DELETE FROM TiposActividad WHERE id_actividad = ?"
				, id_actividad );
	}
	
}
