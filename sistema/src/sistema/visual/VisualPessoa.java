package sistema.visual;

public class VisualPessoa {
	//ATRIBUTOS
	private String codigo;
	private String nome;
	private String cpf;
	private String dataNascimento;
	private String email;
	
	
	// CONSTRUTOR
	public VisualPessoa() {
		
	}
	
	public String menuAluno(String prNome) {
		Visual.getInstance().visualizarTelaLimpa();
		Visual.getInstance().visualizarTitulo("SISTEMA AUTOESCOLA");
		Visual.getInstance().visualizarTextoAlinhadoCentro(prNome);
		Visual.getInstance().visualizarEspacoEmBranco();
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("1 - PROGRESSO");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("2 - PAGAMENTOS");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("3 - ALTERAR DADOS");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("4 - EMITIR CERTIFICADO");
		Visual.getInstance().visualizarEspacoEmBranco();
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("9 - VOLTAR");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("0 - SAIR");
		Visual.getInstance().visualizarLinha();
	
		return Visual.getInstance().retornaDado("DIGITE SUA OPCAO: ");
	}
	
	
	public String menuFuncionario(String prNome) {
		Visual.getInstance().visualizarTelaLimpa();
		Visual.getInstance().visualizarTitulo("SISTEMA AUTOESCOLA");
		Visual.getInstance().visualizarTextoAlinhadoCentro(prNome);
		Visual.getInstance().visualizarEspacoEmBranco();
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("1 - ALUNOS");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("2 - FUNCIONARIOS");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("3 - VEICULOS");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("4 - TURMAS");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("5 - MEUS DADOS");
		Visual.getInstance().visualizarLinha();
	
		return Visual.getInstance().retornaDado("DIGITE SUA OPCAO: ");
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
