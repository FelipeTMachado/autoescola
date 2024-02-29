package sistema.visual;

public class VisualUsuario {
	// ATRIBUTOS
	private String usuario;
	private String senha;
	private int tipo;
	
	
	
	// CONSTRUCTOR
	public VisualUsuario() {
		
	}
	
	public int menuGerenciamentoUsuarioFuncionario() {
		Visual.getInstance().visualizarTitulo("SISTEMA AUTOESCOLA");
		Visual.getInstance().visualizarTextoAlinhadoCentro("GERENCIAMENTO USUARIO");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("1 - NOVO");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("2 - EXCLUIR");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("3 - ALTERAR");
		Visual.getInstance().visualizarEspacoEmBranco();
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("9 - VOLTAR");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("0 - SAIR");
		Visual.getInstance().visualizarLinha();
		
		return Integer.parseInt(Visual.getInstance().retornaDado("DIGITE SUA ESCOLHA: "));
	}
	
	
	public int menuGerenciamentoUsuarioAluno() {
		Visual.getInstance().visualizarTitulo("SISTEMA AUTOESCOLA");
		Visual.getInstance().visualizarTextoAlinhadoCentro("GERENCIAMENTO USUARIO");
		Visual.getInstance().visualizarEspacoEmBranco();
		Visual.getInstance().visualizarTextoAlinhadoEsquerda(String.format("USUARIO: %s", usuario));
		Visual.getInstance().visualizarTextoAlinhadoEsquerda(String.format("SENHA: %s", senha));
		Visual.getInstance().visualizarLinha();
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("1 - ALTERAR");
		Visual.getInstance().visualizarEspacoEmBranco();
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("9 - VOLTAR");
		Visual.getInstance().visualizarTextoAlinhadoEsquerda("0 - SAIR");
		Visual.getInstance().visualizarLinha();
		
		return Integer.parseInt(Visual.getInstance().retornaDado("DIGITE SUA ESCOLHA: "));
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
	
	public void tentativas(int prContagem) {
		Visual.getInstance().visualizarTextoAlinhadoCentro(String.format("VOCE TEM %s TENTATIVA(S)", Math.abs(prContagem - 2)));
		Visual.getInstance().visualizarLinha();
		Visual.getInstance().retornaDado("DIGITE ENTER PARA TENTAR NOVAMENTE...");
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
