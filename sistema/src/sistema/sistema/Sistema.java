package sistema.sistema;

import java.io.Console;
import java.util.Scanner;

import sistema.controle.ControleUsuario;
import sistema.persistencia.mysql.PersistenciaMySQLUsuario;
import sistema.visual.Visual;

public class Sistema {
	// ATRIBUTOS
	public static Scanner leitura;
	public static Console console;
	public static int tipoPersistencia = 1;
	public static int tipoUsuarioLogado;
	public static String nomeUsuarioLogado;
	
	
	
	// CONSTRUTOR
	public Sistema() {
		leitura = new Scanner(System.in);
		console = System.console();
		
		Visual.configurarTela(70);
	}
	
	

	public void iniciarSistema() {
		ControleUsuario controleUsuario = new ControleUsuario(new PersistenciaMySQLUsuario());
		controleUsuario.login();	
	}
	
	public void finalizarSistema() {
		leitura.close();
	}
}
