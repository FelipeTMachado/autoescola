package sistema.persistencia;

import sistema.modelo.ModeloPessoa;

public interface InterfacePersistenciaPessoa {
	public boolean salvar();
	public boolean excluir();
	public boolean alterar();
	public ModeloPessoa buscar();
}
