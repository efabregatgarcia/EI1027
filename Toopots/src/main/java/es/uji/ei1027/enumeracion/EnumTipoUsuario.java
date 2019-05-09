package es.uji.ei1027.enumeracion;

public class EnumTipoUsuario {


	public enum EnumUsuarios {

		CLIENTE("CL"),
		INSTRUCTOR("INS"),
		ADMINISTRADOR("AD");

		private final String tipo;

		private EnumUsuarios(String tipo) {
			this.tipo= tipo;
		}

		public String getTipo() {
			return this.tipo;
		}

		public static EnumUsuarios getTipoEnum(String value) {
			for(EnumUsuarios rec: values()) {
				if(rec.getTipo().equals(value)) {
					return rec;
				}
			}
			return null;
		}

	}
}
