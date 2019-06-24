package es.uji.ei1027.toopots.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.toopots.util.Instructor;

public class InstructorRowMapper implements RowMapper<Instructor> {
	public Instructor mapRow(ResultSet rs, int rowNum) throws SQLException {
		Instructor instructor= new Instructor();
		instructor.setEmailInstructor(rs.getString("emailInstructor"));
		instructor.setEstado(rs.getString("estado"));
		instructor.setNombre(rs.getString("nombre"));
		instructor.setDomicilio(rs.getString("domicilio"));
		instructor.setIban(rs.getString("iban"));
		
		return instructor;
	}
}
