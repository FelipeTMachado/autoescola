package sistema.persistencia.mysql;

import java.sql.Connection;
import java.sql.DriverManager;

import sistema.visual.Visual;

public class ConexaoMySQL {
	private static ConexaoMySQL instancia;
	private Connection conexao;
	
	public ConexaoMySQL() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean iniciarConexao(String prLocal, String prUsuario, String prSenha, String prBanco, int prPorta) {
		String stringConexao = String.format("jdbc:mysql://%s:%d/%s", prLocal, prPorta, prBanco);
		
		try {
			conexao = DriverManager.getConnection(stringConexao, prUsuario, prSenha);
			
			if (conexao.isClosed()) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			Visual.getInstance().visualizarLinha();
			Visual.getInstance().visualizarTextoAlinhadoCentro("ERRO AO ABRIR O BANCO DE DADOS");
			Visual.getInstance().visualizarLinha();
			Visual.getInstance().visualizarTextoSemFormatacao(e.getMessage());
			return false;
		}
	}
	
	public static ConexaoMySQL getInstance() {
		if (instancia == null) {
			instancia = new ConexaoMySQL();
			
			return instancia;
		} else 
			return instancia;
	}

	public Connection getConexao() {
		return conexao;
	}

	public void setConexao(Connection conexao) {
		this.conexao = conexao;
	}
}
