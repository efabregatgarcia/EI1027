package es.uji.ei1027.toopots.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.toopots.model.Usuario;

public class UsuarioRowMapper implements RowMapper<Usuario> {
	public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(rs.getString("idUsuario"));
		usuario.setPassword(rs.getString("password"));
		//usuario.setEnumTipo(rs.getObject("enumTipo"));
		return usuario;
	}
}