package sistema.controle;

import sistema.persistencia.json.PersistenciaJSONPessoa;
import sistema.persistencia.json.PersistenciaJSONUsuario;
import sistema.persistencia.mysql.ConexaoMySQL;
import sistema.persistencia.mysql.PersistenciaMySQLPessoa;
import sistema.persistencia.mysql.PersistenciaMySQLUsuario;
import sistema.persistencia.xml.PersistenciaXMLPessoa;
import sistema.persistencia.xml.PersistenciaXMLUsuario;
import sistema.sistema.Aplicacao;

public class FabricaControle {
	public static ControleUsuario criarControleUsuario() {
		switch (Aplicacao.getInstance().getTipoPersistencia()) {
		case MYSQL: {
			ConexaoMySQL.getInstance().iniciarConexao("localhost", "root", "315865", "AUTOESCOLA", 3306);
			return new ControleUsuario(new PersistenciaMySQLUsuario());
		}
		
		case JSON: {
			return new ControleUsuario(new PersistenciaJSONUsuario());
		}
		
		case XML: {
			return new ControleUsuario(new PersistenciaXMLUsuario());
		}
		
		default:
			return null;
		}		
	}
	
	public static ControlePessoa criarControlePessoa() {
		switch (Aplicacao.getInstance().getTipoPersistencia()) {
		case MYSQL: {
			return new ControlePessoa(new PersistenciaMySQLPessoa());
		}
		
		case JSON: {
			return new ControlePessoa(new PersistenciaJSONPessoa());
		}
		
		case XML: {
			return new ControlePessoa(new PersistenciaXMLPessoa());
		}
		
		default:
			return null;
		}		
	}
}
