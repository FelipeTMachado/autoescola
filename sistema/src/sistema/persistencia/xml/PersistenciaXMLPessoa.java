package sistema.persistencia.xml;

import sistema.modelo.ModeloPessoa;
import sistema.persistencia.interfaces.Persistencia;

public class PersistenciaXMLPessoa implements Persistencia<ModeloPessoa>{
	public PersistenciaXMLPessoa() {
		// TODO Auto-generated constructor stub
	}
	
	public void gravarTodosUsuarios() {
//		Element config = new Element("Clientes");
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
