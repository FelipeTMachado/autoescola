package sistema.controle;

import sistema.modelo.ModeloUsuario;
import sistema.persistencia.interfaces.Persistencia;
import sistema.sistema.Aplicacao;
import sistema.visual.VisualUsuario;

public class ControleUsuario {
	// ATRIBUTOS
	private VisualUsuario visual = new VisualUsuario();
	private ModeloUsuario modelo = null;
	private Persistencia<ModeloUsuario> persistencia;
	
	
	// CONSTRUTOR
	public ControleUsuario(Persistencia<ModeloUsuario> prPersistencia) {
		this.persistencia = prPersistencia;
	}

	public void login() {
		visual.login();	
		
		ModeloUsuario usuario = new ModeloUsuario();
		usuario.setCodigo(-1);
		usuario.setUsuario(visual.getUsuario());
		usuario.setSenha(visual.getSenha());
		
		modelo = persistencia.buscar(usuario);
		
		if (modelo == null) {
			visual.mensagemUsuarioSenhaIncorretos();
		} else {
			Aplicacao.getInstance().setUsuarioConectado(modelo.getTipo());
		}
	}
	
	
	public void excluirUsuario() {
		modelo.setCodigo(2);
		
		persistencia.excluir(modelo);
	}
	
	public void salvarUsuarioPadrao() {
		modelo = new ModeloUsuario();
		
		modelo.setCodigo(1);
		modelo.setUsuario("feh");
		modelo.setSenha("123");
		modelo.setTipo(1);
		modelo.setPessoa(1);
	
		persistencia.salvar(modelo);
		
		modelo = new ModeloUsuario();
		
		modelo.setCodigo(2);
		modelo.setUsuario("tai");
		modelo.setSenha("123");
		modelo.setTipo(2);
		modelo.setPessoa(2);
	
		persistencia.salvar(modelo);
		
		modelo = new ModeloUsuario();
		
		modelo.setCodigo(3);
		modelo.setUsuario("peh");
		modelo.setSenha("123");
		modelo.setTipo(2);
		modelo.setPessoa(3);
	
		persistencia.salvar(modelo);
		
		modelo = new ModeloUsuario();
		
		modelo.setCodigo(4);
		modelo.setUsuario("joa");
		modelo.setSenha("123");
		modelo.setTipo(2);
		modelo.setPessoa(3);
	
		persistencia.salvar(modelo);
	}
	
	public void buscar() {
		modelo = new ModeloUsuario();
		
		modelo.setUsuario("feh");
		
		System.out.println(persistencia.buscar(modelo).getSenha());
	}
	
	public void cadastrarNovoUsuario(int prPessoa) {
		
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

	public Persistencia<ModeloUsuario> getPersistencia() {
		return persistencia;
	}

	public void setPersistencia(Persistencia<ModeloUsuario> persistencia) {
		this.persistencia = persistencia;
	}
}
