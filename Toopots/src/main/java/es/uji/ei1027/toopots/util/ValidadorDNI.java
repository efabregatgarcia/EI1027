package es.uji.ei1027.toopots.util;

import com.aeat.valida.Validador;

public class ValidadorDNI {

	public boolean correcto (String dni) {
		Validador validador = new Validador();
		if (validador.checkNif(dni) > 0) return true;
		else return false;
	}
}
