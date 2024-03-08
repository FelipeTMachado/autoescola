package sistema.modelo;

public class ModeloPessoa {
	// ATRIBUTOS
	private int codigo;
	private String nome;
	private String cpf;
	
	
	
	
	// CONSTRUTOR
	public ModeloPessoa() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	// GETTERS AND SETTERS
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
	
	// TOSTRING
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ModeloPessoa [nome=");
		builder.append(nome);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append(", dataNascimento=");
		builder.append("]");
		return builder.toString();
	}
}
