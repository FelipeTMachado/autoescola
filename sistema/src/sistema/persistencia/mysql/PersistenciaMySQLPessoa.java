package sistema.persistencia.mysql;

import sistema.modelo.ModeloPessoa;
import sistema.persistencia.interfaces.Persistencia;

public class PersistenciaMySQLPessoa implements Persistencia<ModeloPessoa>{
	public PersistenciaMySQLPessoa() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ModeloPessoa buscar(ModeloPessoa prModelo) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean excluir(ModeloPessoa prModelo) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean salvar(ModeloPessoa prModelo) {
		// TODO Auto-generated method stub
		return false;
	}
}