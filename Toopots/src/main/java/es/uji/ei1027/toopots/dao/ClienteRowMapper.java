package es.uji.ei1027.toopots.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.toopots.model.Cliente;

public class ClienteRowMapper implements RowMapper<Cliente>{

	@Override
	public Cliente mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Cliente cliente = new Cliente();
		cliente.setIdCliente(rs.getString("id"));
		cliente.setNombre(rs.getString("nombre"));
		cliente.setEmail(rs.getString("email"));
		cliente.setSexo(rs.getString("sexo"));
		cliente.setFechaNacimiento(rs.getObject("fecha de nacimiento",LocalDate.class));
		
		return cliente;
	}

}
