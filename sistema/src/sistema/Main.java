package sistema;

import sistema.controle.ControleUsuario;
import sistema.persistencia.PersistenciaUsuario;
import sistema.persistencia.mysql.PersistenciaMySQLUsuario;
import sistema.sistema.Aplicacao;

public class Main {
	public static void main(String[] args) {
		try {
			Aplicacao.getInstance();
			
			ControleUsuario controle = new ControleUsuario(new PersistenciaMySQLUsuario());
			
		} catch (Exception e) {
			
		} 
	}
}
