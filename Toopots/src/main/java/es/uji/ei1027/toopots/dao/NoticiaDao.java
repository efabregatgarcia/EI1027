package es.uji.ei1027.toopots.dao;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.toopots.domain.*;

@Repository
public class NoticiaDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource( DataSource dataSource ) {
		this.jdbcTemplate = new JdbcTemplate( dataSource );
	}
	
	private static final class NoticiaMapper implements RowMapper<Noticia> {
		/* id_noticia, fecha, titulo, subtitulo, descripcion */
		
		@Override
		public Noticia mapRow(ResultSet rs, int rowNum) throws SQLException {
			Noticia noticia = new Noticia();
			noticia.setId_noticia(rs.getInt("id_noticia"));
			noticia.setFecha(rs.getDate("fecha"));
			noticia.setTitulo(rs.getString("titulo"));
			noticia.setSubtitulo(rs.getString("subtitulo"));
			noticia.setDescripcion(rs.getString("descripcion"));
			return noticia;
		}
	}
	
	public List<Noticia> getNoticias() {
		return this.jdbcTemplate.query(
				"SELECT * FROM Noticias ORDER BY id_noticia DESC"
				, new NoticiaMapper());
	}
	
	public Noticia getNoticia( int id_noticia ) {
		return this.jdbcTemplate.queryForObject(
				"SELECT * FROM Noticias WHERE id_noticia = ?", new Object[] {id_noticia}
				, new NoticiaMapper());
	}
	
	public void addNoticia( Noticia noticia ) {
		this.jdbcTemplate.update(
				"INSERT INTO "
				+ "Noticias( id_noticia, fecha, titulo, subtitulo, descripcion)"
				+ "values ( DEFAULT, CURRENT_DATE, ?, ?, ? )"
				, noticia.getTitulo(), noticia.getSubtitulo()
				, noticia.getDescripcion()
				);
	}
	
	public void updateNoticia( Noticia noticia ) {
		this.jdbcTemplate.update(
				"UPDATE Noticias SET "
				+ " fecha = CURRENT_DATE, titulo = ?, subtitulo = ?,"
				+ " descripcion = ? "
				+ "WHERE id_noticia = ?"
				, noticia.getTitulo(), noticia.getSubtitulo()
				, noticia.getDescripcion(), noticia.getId_noticia()
				);
	}
	
	public void deleteNoticia( int id_noticia ) {
		this.jdbcTemplate.update(
				"DELETE FROM Noticias WHERE id_noticia = ?"
				, id_noticia );
	}
	
}
