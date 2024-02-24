package sistema.visual;

public class VisualUsuario extends Visual{
	// ATRIBUTOS
	private String usuario;
	private String senha;
	private int tipo;
	
	
	
	// CONSTRUCTOR
	public VisualUsuario() {
		
	}
	
	
	
	public void login() {
		visualizarTelaLimpa();
		visualizarTitulo("SISTEMA AUTOESCOLA");
		visualizarEspacoEmBranco();
		this.usuario = retornaPassword("USUARIO: ");
		this.senha = retornaPassword("SENHA: ");
		
		visualizarTextoAlinhadoEsquerda(usuario);
		visualizarTextoAlinhadoEsquerda(senha);
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
