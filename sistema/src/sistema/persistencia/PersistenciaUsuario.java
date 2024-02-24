package sistema.persistencia;

import sistema.modelo.ModeloUsuario;

public interface PersistenciaUsuario {
	public ModeloUsuario buscar(String prUsuario, String prSenha);
	public boolean salvar(ModeloUsuario prModeloUsuario);
	public boolean excluir(ModeloUsuario prModeloUsuario);
}
