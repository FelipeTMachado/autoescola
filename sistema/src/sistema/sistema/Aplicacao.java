package sistema.sistema;

import java.io.Console;
import java.util.Scanner;

import sistema.visual.Visual;

// CLASSE SINGLETON
public class Aplicacao {
	private static Aplicacao aplicacao;
	private static Scanner leitura;
	private static Console console;
	
	private Aplicacao() {
		
	}
	
	public static Aplicacao getInstance() {
		if (aplicacao == null) {
			aplicacao = new Aplicacao();
			
			leitura = new Scanner(System.in);
			console = System.console();
			
			Visual.configurarTela(70);
		}
		
		return aplicacao;
	}

	
	// GETTERS AND SETTERS
	public static Scanner getLeitura() {
		return leitura;
	}

	public static void setLeitura(Scanner leitura) {
		Aplicacao.leitura = leitura;
	}

	public static Console getConsole() {
		return console;
	}

	public static void setConsole(Console console) {
		Aplicacao.console = console;
	}
}
