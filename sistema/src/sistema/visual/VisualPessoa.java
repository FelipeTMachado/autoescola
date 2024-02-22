package sistema.visual;

import java.util.Scanner;

public class VisualPessoa extends Visual{
	//ATRIBUTOS
	private String codigo;
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String email;
	
	private Scanner leitura;
	
	// CONSTRUTOR
	public VisualPessoa(Scanner leitura) {
		this.leitura = leitura;
	}
	
	// GETTERS AND SETTERS
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
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
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
