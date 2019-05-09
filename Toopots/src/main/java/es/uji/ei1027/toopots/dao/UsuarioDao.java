package es.uji.ei1027.toopots.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;


import es.uji.ei1027.toopots.model.Usuario;

public class UsuarioDao {
private JdbcTemplate jdbcTemplate;
    
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource); 
	}
	
	private static final class UsuarioMapper implements RowMapper<Usuario> {

		@Override
		public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			Usuario usuario = new Usuario();
			usuario.setIdUsuario(rs.getString("idUsuario"));
			usuario.setPassword(rs.getString("password"));
			return usuario;
		}
	}
	
	public List<Usuario> getUsuarios() {
		return this.jdbcTemplate.query("select * from usuarios", new UsuarioMapper());
	}
	
	public Usuario getUsuarios(String idUsuario) {
		return this.jdbcTemplate.queryForObject("select * from usuarios where identificador = ?",
				new UsuarioMapper(), idUsuario);
	}
	
	public Usuario getUsuario(String idUsuario, String password) {
		return this.jdbcTemplate.queryForObject("select * from usuarios where identificador = ? and clave = ?", 
				new UsuarioMapper(), idUsuario, password);
	}
	
	public void addUsuario(Usuario usuario) {
		this.jdbcTemplate.update(" "
				+ " insert into usuarios "
				+ " values (?, ?) " ,
				usuario.getIdUsuario(), usuario.getPassword());
	}
	
	public void updateUsuario(Usuario usuario, String idUusario) {
		this.jdbcTemplate.update(""
				+ " update usuarios set "
				+ " identificador = ?, "
				+ " clave = ? "
				+ " where identificador = ? " ,
				usuario.getIdUsuario(), usuario.getPassword(), idUusario);
	}
	
	public void deleteUsuario(String usuario) {
		this.jdbcTemplate.update("delete from usuarios where identificador = ?", usuario);
	}
}
