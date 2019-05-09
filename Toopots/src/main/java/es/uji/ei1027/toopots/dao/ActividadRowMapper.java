package es.uji.ei1027.toopots.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.jdbc.core.RowMapper;

import es.uji.ei1027.toopots.model.Actividad;

public class ActividadRowMapper implements RowMapper<Actividad> {
	public Actividad mapRow(ResultSet rs, int rowNum) throws SQLException {
		Actividad actividad = new Actividad();
		actividad.setNombre(rs.getString("nombre"));
		actividad.setEstado(rs.getString("estado"));
		actividad.setIdActividad(rs.getString("idActividad"));
		actividad.setIdInstructor(rs.getString("idInstructor"));
		actividad.setDescripcion(rs.getString("descripcion"));
		actividad.setTipoActividad(rs.getString("tipoActividad"));
		actividad.setDuracion(rs.getInt("duracion"));
		actividad.setPrecio(rs.getInt("precio"));
		actividad.setFecha(rs.getObject("fecha", LocalDate.class));
		actividad.setAsistentesMinimos(rs.getInt("asistentesMinimos"));
		actividad.setAsistentesMaximos(rs.getInt("asistentesMaximos"));
		actividad.setLugar(rs.getString("lugar"));
		actividad.setPuntoLlegada(rs.getString("puntoLlegada"));
		actividad.setHoraLlegada(rs.getObject("horaLlegada", LocalTime.class));
		return actividad;
	}
}
