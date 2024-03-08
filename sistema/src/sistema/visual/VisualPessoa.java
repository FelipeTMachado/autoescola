package sistema.visual;

public class VisualPessoa {
	//ATRIBUTOS
	private String codigo;
	private String nome;
	private String cpf;
	
	
	// CONSTRUTOR
	public VisualPessoa() {
		
	}
	
	
	
	
	// MENUS
	public String menuPrincipalFuncionario(String prNome) {
		Visual.getInstance().visualizarTelaLimpa();
		Visual.getInstance().visualizarTitulo("SISTEMA AUTOESCOLA");
		Visual.getInstance().visualizarTextoAlinhadoCentro(prNome);
		Visual.getInstance().visualizarEspacoEmBranco();
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("1 - ALUNOS");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("2 - FUNCIONARIOS");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("3 - VEICULOS");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("4 - TURMAS");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("5 - MEUS DADOS");
		Visual.getInstance().visualizarEspacoEmBranco();
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("9 - RELOGAR");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("0 - SAIR");
		Visual.getInstance().visualizarLinha();
	
		return Visual.getInstance().retornaDado("DIGITE SUA OPCAO: ");
	}
	
	public String menuPrincipalAluno(String prNome) {
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
	
	public String menuGerenciamentoAlunos() {
		Visual.getInstance().visualizarTelaLimpa();
		Visual.getInstance().visualizarTitulo("SISTEMA AUTOESCOLA");
		Visual.getInstance().visualizarTextoAlinhadoCentro("GERENCIAMENTO DE ALUNOS");
		Visual.getInstance().visualizarEspacoEmBranco();
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("1 - NOVO");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("2 - BUSCAR");
		Visual.getInstance().visualizarEspacoEmBranco();
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("9 - VOLTAR");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("0 - SAIR");
		Visual.getInstance().visualizarLinha();
		
		return Visual.getInstance().retornaDado("DIGITE SUA OPCAO: ");
	}
	
	public String menuBuscaPessoa() {
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("1 - ALTERAR");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("2 - EXCLUIR");
		Visual.getInstance().visualizarEspacoEmBranco();
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("9 - VOLTAR");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("0 - SAIR");
		Visual.getInstance().visualizarLinha();
		
		return Visual.getInstance().retornaDado("DIGITE SUA OPCAO: ");
	}
	
	
	
	// FORMULARIOS
	public String formularioCadastroAluno() {
		Visual.getInstance().visualizarTelaLimpa();
		Visual.getInstance().visualizarTitulo("SISTEMA AUTOESCOLA");
		Visual.getInstance().visualizarTextoAlinhadoCentro("NOVO ALUNO");
		Visual.getInstance().visualizarEspacoEmBranco();
		this.nome = Visual.getInstance().retornaDado("NOME: ");
		this.cpf = Visual.getInstance().retornaDado("CPF: ");
		Visual.getInstance().visualizarLinha();
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("1 - SALVAR");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("2 - DESCARTAR E VOLTAR");
		Visual.getInstance().visualizarLinha();
		return Visual.getInstance().retornaDado("DIGITE SUA OPCAO: ");
	}
	
	public void formularioBuscaAluno() {
		this.cpf = "";
		this.nome = "";
		this.codigo = "";
		
		Visual.getInstance().visualizarTelaLimpa();
		Visual.getInstance().visualizarTitulo("SISTEMA AUTOESCOLA");
		Visual.getInstance().visualizarTextoAlinhadoCentro("BUSCAR ALUNO");
		Visual.getInstance().visualizarEspacoEmBranco();
		this.cpf = Visual.getInstance().retornaDado("CPF: ");
		this.nome = Visual.getInstance().retornaDado("NOME: ");
	}
	
	public void visualizarDadosAluno() {		
		Visual.getInstance().visualizarTelaLimpa();
		Visual.getInstance().visualizarTitulo("SISTEMA AUTOESCOLA");
		Visual.getInstance().visualizarTextoAlinhadoCentro("BUSCAR ALUNO");
		Visual.getInstance().visualizarEspacoEmBranco();
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("CODIGO: " + this.codigo);
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("CPF: " + this.cpf);
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("NOME: " + this.nome);
		Visual.getInstance().visualizarLinha();
	}
	
	// MENSAGENS
	public void mensagemAlunoSalvo() {
		Visual.getInstance().visualizarTelaLimpa();
		Visual.getInstance().visualizarTitulo("SISTEMA AUTOESCOLA");
		Visual.getInstance().visualizarTextoAlinhadoCentro("ALUNO SALVO COM SUCESSO");
		Visual.getInstance().visualizarLinha();
		Visual.getInstance().retornaDado("DIGITE ENTER PARA VOLTAR...");
	}
	
	public void mensagemOpcaoInvalida() {
		Visual.getInstance().visualizarTelaLimpa();
		Visual.getInstance().visualizarTitulo("SISTEMA AUTOESCOLA");
		Visual.getInstance().visualizarTextoAlinhadoCentro("OPCAO INVALIDA!");
		Visual.getInstance().visualizarTextoAlinhadoCentro("SELECIONE UMA OPCAO VALIDA DO MENU");
		Visual.getInstance().visualizarLinha();
		Visual.getInstance().retornaDado("DIGITE ENTER PARA VOLTAR...");
	}
	
	public void mensagemAlunoNaoEncontrado() {
		Visual.getInstance().visualizarTelaLimpa();
		Visual.getInstance().visualizarTitulo("SISTEMA AUTOESCOLA");
		Visual.getInstance().visualizarTextoAlinhadoCentro("ALUNO NAO ENCONTRADO");
		Visual.getInstance().visualizarLinha();
	}
	
	public void mensagemFuncionarioNaoEncontrado() {
		Visual.getInstance().visualizarTelaLimpa();
		Visual.getInstance().visualizarTitulo("SISTEMA AUTOESCOLA");
		Visual.getInstance().visualizarTextoAlinhadoCentro("FUNCIONARIO NAO ENCONTRADO");
		Visual.getInstance().visualizarLinha();
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
	
	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VisualPessoa [codigo=");
		builder.append(codigo);
		builder.append(", nome=");
		builder.append(nome);
		builder.append(", cpf=");
		builder.append(cpf);
		builder.append("]");
		return builder.toString();
	}

	
	
}
