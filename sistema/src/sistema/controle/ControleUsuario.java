package sistema.controle;

import sistema.modelo.ModeloUsuario;
import sistema.persistencia.PersistenciaUsuario;
import sistema.visual.VisualUsuario;

public class ControleUsuario {
	// ATRIBUTOS
	private VisualUsuario visual;
	private ModeloUsuario modelo;
	private PersistenciaUsuario persistencia;
	
	
	
	// CONSTRUTOR
	public ControleUsuario(PersistenciaUsuario prPersistencia) {
		this.persistencia = prPersistencia;
	}
	
	
	
	public void login() {
		visual = new VisualUsuario();
		visual.login();	
	
		
		modelo = persistencia.buscar("", "");
	}
	
	
	
	// METODOS GETTERS AND SETTERS
	public VisualUsuario getVisual() {
		return visual;
	}
	
	public void setVisual(VisualUsuario visual) {
		this.visual = visual;
	}
	
	public ModeloUsuario getModelo() {
		return modelo;
	}
	
	public void setModelo(ModeloUsuario modelo) {
		this.modelo = modelo;
	}
	
	public PersistenciaUsuario getPersistencia() {
		return persistencia;
	}
	
	public void setPersistencia(PersistenciaUsuario persistencia) {
		this.persistencia = persistencia;
	}
}
