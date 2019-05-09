package es.uji.ei1027.toopots.enumeracion;

public class EnumTipoUsuario {


	public enum EnumTipoUsuarios {

		CLIENTE("CL"),
		INSTRUCTOR("INS"),
		ADMINISTRADOR("AD");

		private final String tipo;

		private EnumTipoUsuarios(String tipo) {
			this.tipo= tipo;
		}

		public String getTipo() {
			return this.tipo;
		}

		public static EnumTipoUsuarios getTipoEnum(String value) {
			for(EnumTipoUsuarios rec: values()) {
				if(rec.getTipo().equals(value)) {
					return rec;
				}
			}
			return null;
		}

	}

}
