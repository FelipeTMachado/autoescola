package sistema.controle;

import sistema.persistencia.json.PersistenciaJSONUsuario;
import sistema.persistencia.mysql.PersistenciaMySQLUsuario;
import sistema.persistencia.xml.PersistenciaXMLUsuario;
import sistema.sistema.Aplicacao;

public class FabricaControle {
	public static ControleUsuario criarControleUsuario() {
		
		switch (Aplicacao.getInstance().getTipoPersistencia()) {
		case MYSQL: {
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
}
