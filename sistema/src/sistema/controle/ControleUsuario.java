package sistema.controle;

import sistema.modelo.ModeloUsuario;
import sistema.persistencia.interfaces.Persistencia;
import sistema.sistema.Aplicacao;
import sistema.visual.VisualUsuario;

public class ControleUsuario {
	// ATRIBUTOS
	private VisualUsuario visual;
	private ModeloUsuario modelo;
	private Persistencia<ModeloUsuario> persistencia;
	
	
	// CONSTRUTOR
	public ControleUsuario(Persistencia<ModeloUsuario> prPersistencia) {
		this.persistencia = prPersistencia;
	}

	public void login() {
		visual = new VisualUsuario();
		visual.login();	
		
		ModeloUsuario modeloTemp = new ModeloUsuario();
		modeloTemp.setUsuario(visual.getUsuario());
		modeloTemp.setSenha(visual.getSenha());
		
		modelo = persistencia.buscar(modeloTemp);
		
		if (modelo == null) {
			visual.mensagemUsuarioSenhaIncorretos();
		} else {
			Aplicacao.getInstance().setUsuarioConectado(modelo.getTipo());
		}
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
}
