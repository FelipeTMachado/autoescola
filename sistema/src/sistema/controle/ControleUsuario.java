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
	
	
	public void excluirUsuario() {
		modelo = new ModeloUsuario();
		modelo.setCodigo(2);
		
		persistencia.excluir(modelo);
	}
	
	public void salvarUsuario() {
		modelo = new ModeloUsuario();
		modelo.setCodigo(2);
		modelo.setPessoa(2);
		modelo.setUsuario("tai");
		modelo.setSenha("123");
		modelo.setTipo(2);
		
		persistencia.salvar(modelo);
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
