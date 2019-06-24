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
public class ActividadDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource( DataSource dataSource ) {
		this.jdbcTemplate = new JdbcTemplate( dataSource );
	}
	
	private static final class ActividadMapper implements RowMapper<Actividad> {
		/* id_actividad, nombre, duracionHoras, descripcion,
		 * nivel, precioPorPersona, minParticipantes, maxParticipantes */
		
		@Override
		public Actividad mapRow(ResultSet rs, int rowNum) throws SQLException {
			Actividad actividad = new Actividad();
			actividad.setId_actividad(rs.getInt("id_actividad"));
			actividad.setNombre(rs.getString("nombre"));
			actividad.setDuracionHoras(rs.getInt("duracionHoras"));
			actividad.setDescripcion(rs.getString("descripcion"));
			actividad.setNivel(Nivel.valueOf(rs.getString("nivel")));
			actividad.setPrecioPorPersona(rs.getDouble("precioPorPersona"));
			actividad.setMinParticipantes(rs.getInt("minParticipantes"));
			actividad.setMaxParticipantes(rs.getInt("maxParticipantes"));
			return actividad;
		}
	}
	
	public List<Actividad> getActividades() {
		return this.jdbcTemplate.query(
				"SELECT * FROM Actividades ORDER BY id_actividad DESC"
				, new ActividadMapper());
	}
		
	public Actividad getActividad( int id_actividad ) {
		return this.jdbcTemplate.queryForObject(
				"SELECT * FROM Actividades WHERE id_actividad = ?", new Object[] {id_actividad}
				, new ActividadMapper());
	}
	
	public void addActividad( Actividad actividad ) {
		this.jdbcTemplate.update(
				"INSERT INTO "
				+ "Actividades( id_actividad, nombre, duracionHoras, descripcion,"
				+ " nivel, precioPorPersona, minParticipantes, maxParticipantes )"
				+ "values ( DEFAULT, ?, ?, ?, CAST(? AS e_nivel), ?, ?, ? )"
				, actividad.getNombre(), actividad.getDuracionHoras(), actividad.getDescripcion()
				, actividad.getNivel().name(), actividad.getPrecioPorPersona()
				, actividad.getMinParticipantes(), actividad.getMaxParticipantes()
				);
	}
	
	public void updateActividad( Actividad actividad ) {
		this.jdbcTemplate.update(
				"UPDATE Actividades SET "
				+ " nombre = ?, duracionHoras = ?, descripcion = ?,"
				+ " nivel = CAST(? AS e_nivel), precioPorPersona = ?, minParticipantes = ?, maxParticipantes = ? "
				+ "WHERE id_actividad = ?"
				, actividad.getNombre(), actividad.getDuracionHoras(), actividad.getDescripcion()
				, actividad.getNivel().name(), actividad.getPrecioPorPersona(), actividad.getMinParticipantes()
				, actividad.getMaxParticipantes(), actividad.getId_actividad()
				);
	}
	
	public void deleteActividad( int id_actividad ) {
		this.jdbcTemplate.update(
				"DELETE FROM Actividades WHERE id_actividad = ?"
				, id_actividad );
	}
	
}
