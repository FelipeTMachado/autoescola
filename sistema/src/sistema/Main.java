package sistema;

import sistema.controle.ControlePessoa;
import sistema.controle.ControleUsuario;
import sistema.controle.FabricaControle;
import sistema.persistencia.TipoPersistencia;
import sistema.persistencia.mysql.ConexaoMySQL;
import sistema.sistema.Aplicacao;

public class Main {
	public static void main(String[] args) {
		try {
			Aplicacao.getInstance().setTipoPersistencia(TipoPersistencia.XML);
			ConexaoMySQL.getInstance().iniciarConexao("localhost", "root", "315865", "AUTOESCOLA", 3306);
				
			//iniciarTelas();
			
			ControleUsuario controle = FabricaControle.criarControleUsuario();
			controle.buscar();
			//controle.salvarUsuario();
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
