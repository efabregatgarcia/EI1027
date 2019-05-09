package es.uji.ei1027.toopots.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.toopots.model.RegistroInstructor;

public class RegistroInstructorRowMapper implements RowMapper<RegistroInstructor> {
	public RegistroInstructor mapRow(ResultSet rs, int rowNum) throws SQLException {
		RegistroInstructor registroInstructor = new RegistroInstructor();
		registroInstructor.setIdRegistro(rs.getString("idRegistro"));
		registroInstructor.setIdInstructor(rs.getString("idInstructor"));
		registroInstructor.setNombre(rs.getString("nombre"));
		registroInstructor.setDireccion(rs.getString("direccion"));
		registroInstructor.setTelefono(rs.getString("telefono"));
		registroInstructor.setCurriculum(rs.getString("curriculum"));
		registroInstructor.setAptitudes(rs.getString("aptitudes"));

		return registroInstructor;
	}
}
