package sistema.persistencia.xml;

import sistema.modelo.ModeloUsuario;
import sistema.persistencia.interfaces.Persistencia;

public class PersistenciaXMLUsuario implements Persistencia<ModeloUsuario>{
	// CONSTRUTOR
	public PersistenciaXMLUsuario() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public ModeloUsuario buscar(ModeloUsuario prModelo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean excluir(ModeloUsuario prModelo) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean salvar(ModeloUsuario prModelo) {
		// TODO Auto-generated method stub
		return false;
	}
}
