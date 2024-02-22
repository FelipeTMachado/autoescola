package sistema.sistema;

import java.io.Console;
import java.util.Scanner;

import sistema.controle.ControleUsuario;
import sistema.visual.Visual;

public class Sistema {
	public static Scanner leitura;
	public static Console console;
	public static int tipoUsuarioLogado;
	public static String nomeUsuarioLogado;
	
	public Sistema() {
		leitura = new Scanner(System.in);
		console = System.console();
		
		Visual.configurarTela(70);
	}
	
	public void iniciarSistema() {
		ControleUsuario controleUsuario = new ControleUsuario();
		controleUsuario.login();
	}
	
	public void finalizarSistema() {
		leitura.close();
	}
}
