package es.uji.ei1027.toopots.domain;

public class TipoActividad {

	/* id_actividad, id_tipo */
	private int id_actividad;
	private int id_tipo;
	
	public TipoActividad() {
		this.setId_actividad(0);
		this.setId_tipo(0);
	}	
	
	public TipoActividad( int id_actividad, int id_tipo) {
		this.setId_actividad(id_actividad);
		this.setId_tipo(id_tipo);
	}
	
	public int getId_actividad() {
		return id_actividad;
	}
	public void setId_actividad(int id_actividad) {
		this.id_actividad = id_actividad;
	}
	public int getId_tipo() {
		return id_tipo;
	}
	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}
	
	
}
