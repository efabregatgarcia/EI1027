package es.uji.ei1027.enumeracion;



public class EnumTipoActividad {


	public enum EnumTipos {

		RIESGO_BAJO("RB"),
		RIESGO_MEDIO("RM"),
		RIESGO_ALTO("RA");

		private final String tipo;

		private EnumTipos(String tipo) {
			this.tipo= tipo;
		}

		public String getTipo() {
			return this.tipo;
		}

		public static EnumTipos getTipoEnum(String value) {
			for(EnumTipos rec: values()) {
				if(rec.getTipo().equals(value)) {
					return rec;
				}
			}
			return null;
		}

	}
}
