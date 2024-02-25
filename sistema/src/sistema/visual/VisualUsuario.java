package sistema.visual;

public class VisualUsuario {
	// ATRIBUTOS
	private String usuario;
	private String senha;
	private int tipo;
	
	
	
	// CONSTRUCTOR
	public VisualUsuario() {
		
	}
	
	
	
	public void login() {
		Visual.getInstance().visualizarTelaLimpa();
		Visual.getInstance().visualizarTitulo("SISTEMA AUTOESCOLA");
		Visual.getInstance().visualizarEspacoEmBranco();
		this.usuario = Visual.getInstance().retornaDado("USUARIO: ");
		this.senha = Visual.getInstance().retornaPassword("SENHA: ");
	}
	
	public void mensagemUsuarioSenhaIncorretos() {
		Visual.getInstance().visualizarTelaLimpa();
		Visual.getInstance().visualizarTitulo("SISTEMA AUTOESCOLA");
		Visual.getInstance().visualizarTextoAlinhadoCentro("USUÁRIO OU SENHA INCORRETOS!");
		Visual.getInstance().visualizarLinha();
	}
	
	
	// GETTERS AND SETTERS
	public String getUsuario() {
		return this.usuario;
	}
	public void setUsuario(String prUsuario) {
		this.usuario = prUsuario;
	}
	public String getSenha() {
		return this.senha;
	}
	public void setSenha(String prSenha) {
		this.senha = prSenha;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int prTipo) {
		this.tipo = prTipo;
	}
}
