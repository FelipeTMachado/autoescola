package sistema.persistencia.mysql;

import sistema.modelo.ModeloUsuario;
import sistema.persistencia.PersistenciaUsuario;

public class PersistenciaMySQLUsuario implements PersistenciaUsuario{
	// CONSTRUTOR
	public PersistenciaMySQLUsuario() {
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
