package sistema.modelo;

public class ModeloUsuario {	
	// ATRIBUTOS
	private int codigo;
	private String usuario;
	private String senha;
	private int tipo;
	private int pessoa;
	
	
	
	public ModeloUsuario() {
		// TODO Auto-generated constructor stub
	}

	
	
	// GETTERS AND SETTERS
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getPessoa() {
		return pessoa;
	}
	public void setPessoa(int pessoa) {
		this.pessoa = pessoa;
	}
}
