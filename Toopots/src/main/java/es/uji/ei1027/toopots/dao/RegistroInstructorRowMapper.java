package es.uji.ei1027.toopots.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.toopots.util.RegistroInstructor;

public class RegistroInstructorRowMapper implements RowMapper<RegistroInstructor> {
	public RegistroInstructor mapRow(ResultSet rs, int rowNum) throws SQLException {
		RegistroInstructor registroInstructor = new RegistroInstructor();
		registroInstructor.setIdRegistro(rs.getString("idRegistro"));
		registroInstructor.setEmailInstructor(rs.getString("emailInstructor"));
		registroInstructor.setNombre(rs.getString("nombre"));
		registroInstructor.setDireccion(rs.getString("direccion"));
		registroInstructor.setDni(rs.getString("dni"));
		registroInstructor.setTelefono(rs.getString("telefono"));
		registroInstructor.setCurriculum(rs.getString("curriculum"));

		return registroInstructor;
	}
}
