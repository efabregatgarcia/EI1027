package es.uji.ei1027.toopots.dao;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.NaturAdventure.domain.Tipo;

@Repository
public class TipoDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource( DataSource dataSource ) {
		this.jdbcTemplate = new JdbcTemplate( dataSource );
	}
	
	private static final class TipoMapper implements RowMapper<Tipo> {
		/* id_tipo, descripcion */
		
		@Override
		public Tipo mapRow(ResultSet rs, int rowNum) throws SQLException {
			Tipo tipo = new Tipo();
			tipo.setId_tipo(rs.getInt("id_tipo"));
			tipo.setDescripcion(rs.getString("descripcion"));
			return tipo;
		}
	}
	
	public List<Tipo> getTipos() {
		return this.jdbcTemplate.query(
				"SELECT * FROM Tipos ORDER BY id_tipo ASC"
				, new TipoMapper());
	}
	
	public Tipo getTipo( int id ) {
		return this.jdbcTemplate.queryForObject(
				"SELECT * FROM Tipos WHERE id_tipo = ?", new Object[] {id}
				, new TipoMapper());
	}
	
	public void addTipo( Tipo tipo ) {
		this.jdbcTemplate.update(
				"INSERT INTO "
				+ "Tipos( id_tipo, descripcion )"
				+ "values ( DEFAULT, ? )"
				, tipo.getDescripcion()
				);
	}
	
	public void updateTipo( Tipo tipo ) {
		this.jdbcTemplate.update(
				"UPDATE Tipos SET "
				+ "descripcion = ? "
				+ "WHERE id_tipo = ?"
				, tipo.getDescripcion(), tipo.getId_tipo()
				);
	}
	
	public void deleteTipo( int id ) {
		this.jdbcTemplate.update(
				"DELETE FROM Tipos WHERE id_tipo = ?"
				, id );
	}
	
}
