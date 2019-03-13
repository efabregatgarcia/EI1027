package es.uji.ei1027.toopots.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.toopots.model.Instructor;

public class InstructorRowMapper implements RowMapper<Instructor> {
	public Instructor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Instructor instructor= new Instructor();
		instructor.setIdInstructor(rs.getString("idInstructor"));
		instructor.setEstado(rs.getString("estado"));
		instructor.setNombre(rs.getString("nombre"));
		instructor.setDomicilio(rs.getString("domicilio"));
		instructor.setEmail(rs.getString("email"));
		instructor.setIban(rs.getString("iban"));
		
		return instructor;
	}
}
