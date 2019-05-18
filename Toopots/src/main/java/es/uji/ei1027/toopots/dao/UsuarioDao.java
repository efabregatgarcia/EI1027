package es.uji.ei1027.toopots.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uji.ei1027.toopots.model.Usuario;

@Repository
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
			usuario.setEmailUsuario(rs.getString("emailUsuario"));
			usuario.setContrasenya(rs.getString("contrasenya"));
			return usuario;
		}
	}
	
	public List<Usuario> getUsuarios() {
		return this.jdbcTemplate.query("select * from usuario", new UsuarioMapper());
	}
	
	public Usuario getUsuarios(String emailUsuario) {
		return this.jdbcTemplate.queryForObject("select * from usuario where emailUsuario = ?",
				new UsuarioMapper(), emailUsuario);
	}
	
	public Usuario getUsuario(String emailUsuario, String contrasenya) {
		return this.jdbcTemplate.queryForObject("select * from usuario where emailUsuario=? and contrasenya=?", 
				new UsuarioMapper(), emailUsuario, contrasenya);
	}
	
	public void addUsuario(Usuario usuario) {
		this.jdbcTemplate.update(" "
				+ " insert into usuario "
				+ " values (?, ?) " ,
				usuario.getEmailUsuario(), usuario.getContrasenya());
	}
	
	public void updateUsuario(Usuario usuario, String emailUsuario) {
		this.jdbcTemplate.update(""
				+ " update usuario set "
				+ " identificador = ?, "
				+ " clave = ? "
				+ " where identificador = ? " ,
				usuario.getEmailUsuario(), usuario.getContrasenya(), emailUsuario);
	}
	
	public void deleteUsuario(String usuario) {
		this.jdbcTemplate.update("delete from usuario where identificador = ?", usuario);
	}
}
