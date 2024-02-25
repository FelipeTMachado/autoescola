package sistema.persistencia.json;

import sistema.modelo.ModeloUsuario;
import sistema.persistencia.interfaces.Persistencia;

public class PersistenciaJSONUsuario implements Persistencia<ModeloUsuario>{
	// CONSTRUTOR
	public PersistenciaJSONUsuario() {
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
