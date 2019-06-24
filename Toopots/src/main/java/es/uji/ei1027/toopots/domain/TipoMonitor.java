package es.uji.ei1027.toopots.domain;

public class TipoMonitor {

	/* id_monitor, id_tipo */
	private int id_monitor;
	private int id_tipo;
	
	public TipoMonitor() {
		this.setId_monitor(0);
		this.setId_tipo(0);
	}	
	
	public TipoMonitor( int id_monitor, int id_tipo) {
		this.setId_monitor(id_monitor);
		this.setId_tipo(id_tipo);
	}
	
	public int getId_monitor() {
		return id_monitor;
	}
	public void setId_monitor(int id_monitor) {
		this.id_monitor = id_monitor;
	}
	public int getId_tipo() {
		return id_tipo;
	}
	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}
	
	
}
