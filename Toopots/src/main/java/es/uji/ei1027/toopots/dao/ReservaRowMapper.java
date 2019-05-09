package es.uji.ei1027.toopots.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.toopots.model.Reserva;

public class ReservaRowMapper implements RowMapper<Reserva> {
	public Reserva mapRow(ResultSet rs, int rowNum) throws SQLException {
		Reserva reserva = new Reserva();
		reserva.setIdReserva(rs.getString("idReserva"));
		reserva.setIdActividad(rs.getString("idActividad"));
		reserva.setIdCliente(rs.getString("idCliente"));
		reserva.setEstadoPagamiento(rs.getString("estadoPagamiento"));
		reserva.setFecha(rs.getObject("fecha", LocalDate.class));
		reserva.setNumeroAsistentes(rs.getInt("numeroAsistentes"));
		reserva.setPrecioPersona(rs.getInt("precioPersona"));
		return reserva;
	}
}