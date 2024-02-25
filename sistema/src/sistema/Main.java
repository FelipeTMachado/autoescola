package sistema;

import sistema.controle.ControleUsuario;
import sistema.controle.FabricaControle;
import sistema.persistencia.TipoPersistencia;
import sistema.persistencia.mysql.ConexaoMySQL;
import sistema.sistema.Aplicacao;
import sistema.visual.Visual;

public class Main {
	public static void main(String[] args) {
		try {
			Aplicacao.getInstance().setTipoPersistencia(TipoPersistencia.MYSQL);
			ConexaoMySQL.getInstance().iniciarConexao("localhost", "root", "315865", "AUTOESCOLA", 3306);
				
			boolean ehSair = false; 
			int contagem = 0;
			
			while (!ehSair) {
				ControleUsuario controle = FabricaControle.criarControleUsuario();
				controle.login();
				
				if (Aplicacao.getInstance().getUsuarioConectado() == 1) {
					
				}
				
				if (Aplicacao.getInstance().getUsuarioConectado() == 2) {
					
				}
				
				if (Aplicacao.getInstance().getUsuarioConectado() == 0) {
					Visual.getInstance().visualizarTextoAlinhadoCentro(String.format("VOCE TEM %s TENTATIVA(S)", Math.abs(contagem - 2)));
					Visual.getInstance().visualizarLinha();
					Visual.getInstance().retornaDado("DIGITE ENTER PARA TENTAR NOVAMENTE...");
					contagem ++;
					
					if (contagem == 3)
						ehSair = true;	
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}
}
