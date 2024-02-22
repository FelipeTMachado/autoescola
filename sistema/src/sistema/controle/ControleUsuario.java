package sistema.controle;

import sistema.visual.VisualUsuario;

public class ControleUsuario {
	VisualUsuario visual;
	
	public ControleUsuario() {
		
	}
	
	public void login() {
		visual = new VisualUsuario();
		visual.login();
	}
}
