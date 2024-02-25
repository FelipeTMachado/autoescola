package sistema.persistencia.interfaces;

public interface Persistencia<T> {
	public T buscar(T prModelo);
	public boolean salvar(T prModelo);
	public boolean excluir(T prModelo);
}
