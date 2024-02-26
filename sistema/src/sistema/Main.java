package sistema;

import sistema.controle.ControlePessoa;
import sistema.controle.ControleUsuario;
import sistema.controle.FabricaControle;
import sistema.persistencia.TipoPersistencia;
import sistema.persistencia.mysql.ConexaoMySQL;
import sistema.sistema.Aplicacao;
import sistema.visual.Visual;

public class Main {
	public static void main(String[] args) {
		try {
			Aplicacao.getInstance().setTipoPersistencia(TipoPersistencia.JSON);
			ConexaoMySQL.getInstance().iniciarConexao("localhost", "root", "315865", "AUTOESCOLA", 3306);
				
			iniciarTelas();
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
				ehSair = controlePessoa.menuFuncionario();
			}
			
			if (Aplicacao.getInstance().getUsuarioConectado() == 2) {
				contagem = 0;
			
				ControlePessoa controlePessoa = FabricaControle.criarControlePessoa();
				ehSair = controlePessoa.menuAluno();
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
