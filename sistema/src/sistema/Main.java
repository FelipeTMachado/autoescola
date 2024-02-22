package sistema;

import sistema.sistema.Sistema;

public class Main {
	public static void main(String[] args) {
		Sistema sistema = new Sistema();
		
		try {
			sistema.iniciarSistema();
		} finally {
			sistema.finalizarSistema();
		}
	}
}
