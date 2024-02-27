package sistema.persistencia.xml;

import java.util.ArrayList;
import java.util.List;

import sistema.modelo.ModeloUsuario;
import sistema.persistencia.interfaces.Persistencia;

public class PersistenciaXMLUsuario implements Persistencia<ModeloUsuario>{
	private List<ModeloUsuario> listaUsuarios = new ArrayList<ModeloUsuario>();
	
	
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
