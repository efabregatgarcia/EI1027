package es.uji.ei1027.toopots.domain;

public class Actividad {

	/* id_actividad, nombre, duracionHoras, descripcion,
	 * nivel, precioPorPersona, minParticipantes, maxParticipantes */
	private int id_actividad;
	private String nombre;
	private int duracionHoras;
	private String descripcion;
	private Nivel nivel;
	private double precioPorPersona;
	private int minParticipantes;
	private int maxParticipantes;
	
	private int id_tipo;
	private String descripTipo;
	
	public int getId_actividad() {
		return id_actividad;
	}
	public void setId_actividad(int id_actividad) {
		this.id_actividad = id_actividad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDuracionHoras() {
		return duracionHoras;
	}
	public void setDuracionHoras(int duracionHoras) {
		this.duracionHoras = duracionHoras;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Nivel getNivel() {
		return nivel;
	}
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	public double getPrecioPorPersona() {
		return precioPorPersona;
	}
	public void setPrecioPorPersona(double precioPorPersona) {
		this.precioPorPersona = precioPorPersona;
	}
	public int getMinParticipantes() {
		return minParticipantes;
	}
	public void setMinParticipantes(int minParticipantes) {
		this.minParticipantes = minParticipantes;
	}
	public int getMaxParticipantes() {
		return maxParticipantes;
	}
	public void setMaxParticipantes(int maxParticipantes) {
		this.maxParticipantes = maxParticipantes;
	}	
	public int getId_tipo() {
		return id_tipo;
	}
	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}
	public String getDescripTipo() {
		return descripTipo;
	}
	public void setDescripTipo(String descripTipo) {
		this.descripTipo = descripTipo;
	}
	
}
