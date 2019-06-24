package es.uji.ei1027.toopots.domain;

public class MonitorReserva {

	/* id_monitor, id_reserva */
	private int id_reserva;
	private int id_monitor;
	
	public MonitorReserva() {
		this.setId_reserva(0);
		this.setId_monitor(0);
	}	
	
	public MonitorReserva( int id_reserva, int id_monitor) {
		this.setId_reserva(id_reserva);
		this.setId_monitor(id_monitor);
	}

	public int getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	
	
	public int getId_monitor() {
		return id_monitor;
	}
	public void setId_monitor(int id_monitor) {
		this.id_monitor = id_monitor;
	}
}
