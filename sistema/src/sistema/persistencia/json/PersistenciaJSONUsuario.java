package sistema.persistencia.json;

import sistema.modelo.ModeloUsuario;
import sistema.persistencia.PersistenciaUsuario;

public class PersistenciaJSONUsuario implements PersistenciaUsuario{
	// CONSTRUTOR
	public PersistenciaJSONUsuario() {
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public ModeloUsuario buscar(String prUsuario, String prSenha) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean excluir(ModeloUsuario prModeloUsuario) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean salvar(ModeloUsuario prModeloUsuario) {
		// TODO Auto-generated method stub
		return false;
	}
}
