package sistema;

import sistema.controle.ControlePessoa;
import sistema.controle.ControleUsuario;
import sistema.controle.FabricaControle;
import sistema.persistencia.TipoPersistencia;
import sistema.sistema.Aplicacao;

public class Main {
	public static void main(String[] args) {
		try {
			if (args.length == 0) {
				Aplicacao.getInstance().setTipoPersistencia(TipoPersistencia.MYSQL);
				
				iniciarTelas();
			} else {
				if (args[0].equals("criar")) {
					Aplicacao.getInstance().setTipoPersistencia(TipoPersistencia.JSON);
					
					ControlePessoa pessoa = FabricaControle.criarControlePessoa();
					pessoa.salvarPessoaPadrao();
					
					ControleUsuario usuario = FabricaControle.criarControleUsuario();
					usuario.salvarUsuarioPadrao();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}
	
	public static void iniciarTelas() {
		boolean ehSair = false; 
		int contagem = 0;
		
		while (!ehSair) {
			ControleUsuario controleUsuario = FabricaControle.criarControleUsuario();
			controleUsuario.login();
			
			if (Aplicacao.getInstance().getUsuarioConectado() == 1) {
				contagem = 0;
				
				ControlePessoa controlePessoa = FabricaControle.criarControlePessoa();
				ehSair = controlePessoa.menuFuncionario(controleUsuario.getModelo().getPessoa());
			}
			
			if (Aplicacao.getInstance().getUsuarioConectado() == 2) {
				contagem = 0;
			
				ControlePessoa controlePessoa = FabricaControle.criarControlePessoa();
				ehSair = controlePessoa.menuAluno(controleUsuario.getModelo().getPessoa());
			}
			
			if (Aplicacao.getInstance().getUsuarioConectado() == 0) {
				controleUsuario.getVisual().tentativas(contagem);
				contagem ++;
				
				if (contagem == 3)
					ehSair = true;	
			}
		}
	}
}
