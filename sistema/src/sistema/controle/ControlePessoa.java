package sistema.controle;

import sistema.modelo.ModeloPessoa;
import sistema.persistencia.interfaces.Persistencia;
import sistema.visual.Visual;
import sistema.visual.VisualPessoa;

public class ControlePessoa {
	VisualPessoa visual;
	// PESSOA CADASTRADA NO SISTEMA
	ModeloPessoa modelo;
	
	private Persistencia<ModeloPessoa> persistencia;
	
	public ControlePessoa(Persistencia<ModeloPessoa> prPersistencia) {
		persistencia = prPersistencia;
	}
	
	
	
	
	// TESTES
	public void excluirPessoa() {
		modelo = new ModeloPessoa();
		
		modelo.setCpf("09297363970");
		
		persistencia.excluir(modelo);
	}
	
	public void salvarPessoaPadrao() {
		modelo = new ModeloPessoa();
		
		modelo.setCodigo(1);
		modelo.setCpf("09297363970");
		modelo.setNome("Felipe Caue Machado");
		
		persistencia.salvar(modelo);
		
		modelo = new ModeloPessoa();
		
		modelo.setCodigo(2);
		modelo.setCpf("12180829922");
		modelo.setNome("Tainara Jasper");
		
		persistencia.salvar(modelo);
		
		modelo = new ModeloPessoa();
		
		modelo.setCodigo(3);
		modelo.setCpf("85110523991");
		modelo.setNome("Pedro Rian");
		
		persistencia.salvar(modelo);
		
		modelo = new ModeloPessoa();
		
		modelo.setCodigo(4);
		modelo.setCpf("00773120904");
		modelo.setNome("Tiago Santos");
		
		persistencia.salvar(modelo);
	}
	
	public void buscarPessoa() {
		modelo = new ModeloPessoa();
		
		modelo.setCpf("85110523991");
		
		modelo = persistencia.buscar(modelo);
		
		if (modelo != null) {
			Visual.getInstance().visualizarTextoAlinhadoEsquerda(modelo.getNome());
			Visual.getInstance().visualizarTextoAlinhadoEsquerda(String.format("%d", modelo.getCodigo()));
		}
	}
	
	
	
	
	// MENUS DE ACESSO E GERENCIAMENTO
	public boolean menuAluno(int prCodigoPessoa) {
		visual = new VisualPessoa();
		modelo = new ModeloPessoa();
		
		
		modelo.setCodigo(prCodigoPessoa);
		
		modelo = persistencia.buscar(modelo);

		boolean ehSair = false;
		
		while (!ehSair) {
			switch (visual.menuPrincipalAluno(modelo.getNome())) {
			case "1": {
				// PROGRESSO
				break;
			}
			
			case "2": {
				// PAGAMENTOS
				break;
			}
			
			case "3": {
				// ALTERAR DADOS
				break;
			}
			
			case "4": {
				// EMITIR CERTIFICADO
				break;
			}
			
			case "0": {
				System.exit(1);
			}
			
			case "9": {
				ehSair = true;
			}
			
			default:
				
			}
		}
		
		return false;
	}
	
	public boolean menuFuncionario(int prCodigoPessoa) {
		visual = new VisualPessoa();
		
		// SETTAR CONFIGURACOES DA PESSOA QUE ACESSOU O SISTEMA
		modelo = new ModeloPessoa();
		modelo.setCodigo(prCodigoPessoa);
		modelo = persistencia.buscar(modelo);
		
		boolean ehSair = false;
		
		while (!ehSair) {
			String escolha = visual.menuPrincipalFuncionario(modelo.getNome());
			
			switch (escolha) {
			case "1": {
				// MENU GERENCIAMENTO DE ALUNOS
				menuGerenciamentoAluno();
				break;
			}
			
			case "0": {
				// SAIR DO SISTEMA
				System.exit(1);
				break;
			}
			
			case "9": {
				// VOLTAR PARA O LOGIN
				ehSair = true;
				break;
			}
			
			default:
				visual.mensagemOpcaoInvalida();
			}
		}
		
		return false;
	}
	
	public void menuGerenciamentoAluno() {
		boolean ehSair = false;
		
		while (!ehSair) {
			String escolha = visual.menuGerenciamentoAlunos();
			
			switch (escolha) {
			case "1": {
				// FORMULARIO DE CADASTRO DO ALUNO
				formularioCadastroAluno();
				break;
			}
			
			case "2": {
				// MENU DE BUSCA DO ALUNO
				formularioBuscaAluno();
				break;
			}
			
			case "9": {
				// VOLTAR PARA O MENU ANTERIOR
				ehSair = true;
				break;
			}
			
			case "0": {
				// SAIR DO SISTEMA
				System.exit(1);
				break;
			}
			
			default:
				// MENSAGEM DE OPCAO INVALIDA
				visual.mensagemOpcaoInvalida();
			}
		}
	}
	
	private void formularioCadastroAluno() {
		String escolha = visual.formularioCadastroAluno();
		
		switch (escolha) {
		case "1": {
			ModeloPessoa aluno = new ModeloPessoa();
			aluno = new ModeloPessoa();
			
			aluno.setCodigo(persistencia.buscarProximo());
			aluno.setCpf(visual.getCpf());
			aluno.setNome(visual.getNome());
			
			if (persistencia.salvar(aluno)) {
				visual.mensagemAlunoSalvo();
			}
			
			break;
		}
		
		case "2": {
			
			break;
		}
		
		default:
			visual.mensagemOpcaoInvalida();
		}
	}

	private void formularioBuscaAluno() {
		visual.formularioBuscaAluno();
		
		ModeloPessoa aluno = new ModeloPessoa();
		
		aluno.setCodigo(Integer.parseInt(visual.getCodigo()));
		aluno.setCpf(visual.getCpf());
		aluno.setNome(visual.getNome());
		
		aluno = persistencia.buscar(aluno);
		
		if (aluno != null) {
			visual.setCodigo(String.format("%d", aluno.getCodigo()));
			visual.setCpf(aluno.getCpf());
			visual.setNome(aluno.getNome());
			
			visual.visualizarDadosAluno();
			visual.menuBuscaPessoa();
		} else {
			visual.mensagemAlunoNaoEncontrado();
		}
		
	}
	
	
	
	
	// GETTERS AND SETTERS
	public VisualPessoa getVisual() {
		return visual;
	}
	public void setVisual(VisualPessoa visual) {
		this.visual = visual;
	}
	public Persistencia<ModeloPessoa> getPersistencia() {
		return persistencia;
	}
	public void setPersistencia(Persistencia<ModeloPessoa> persistencia) {
		this.persistencia = persistencia;
	}
}
