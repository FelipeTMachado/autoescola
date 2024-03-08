package sistema.sistema;

import java.io.Console;
import java.util.Scanner;

import sistema.persistencia.TipoPersistencia;
import sistema.visual.Visual;

// CLASSE SINGLETON
public class Aplicacao {
	private static Aplicacao aplicacao;
	private Scanner scanner;
	private Console console;
	private int usuarioConectado;
	private TipoPersistencia tipoPersistencia;
	
	private Aplicacao() {
		
	}
	
	public static Aplicacao getInstance() {
		if (aplicacao == null) {
			aplicacao = new Aplicacao();
			
			aplicacao.scanner = new Scanner(System.in);
			aplicacao.console = System.console();
			
			Visual.getInstance().configurarTela(70);
		}
		
		return aplicacao;
	}

	
	// GETTERS AND SETTERS
	public Scanner getScanner() {
		return scanner;
	}

	public Console getConsole() {
		return console;
	}

	public int getUsuarioConectado() {
		return usuarioConectado;
	}

	public void setUsuarioConectado(int usuarioConectado) {
		this.usuarioConectado = usuarioConectado;
	}

	public TipoPersistencia getTipoPersistencia() {
		return tipoPersistencia;
	}

	public void setTipoPersistencia(TipoPersistencia tipoPersistencia) {
		this.tipoPersistencia = tipoPersistencia;
	}
}
