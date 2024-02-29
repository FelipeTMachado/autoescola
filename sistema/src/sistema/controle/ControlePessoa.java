package sistema.controle;

import sistema.modelo.ModeloPessoa;
import sistema.persistencia.interfaces.Persistencia;
import sistema.visual.VisualPessoa;

public class ControlePessoa {
	VisualPessoa visual;
	ModeloPessoa modelo;
	
	private Persistencia<ModeloPessoa> persistencia;
	
	public ControlePessoa(Persistencia<ModeloPessoa> prPersistencia) {
		persistencia = prPersistencia;
	}
	
	public boolean menuAluno(int prCodigoPessoa) {
		visual = new VisualPessoa();
		modelo = new ModeloPessoa();
		modelo.setCodigo(prCodigoPessoa);
		
		modelo = persistencia.buscar(modelo);
		
		visual.menuAluno(modelo.getNome());
		
		return true;
	}
	
	public boolean menuFuncionario(int prCodigoPessoa) {
		visual = new VisualPessoa();
		modelo = new ModeloPessoa();
		modelo.setCodigo(prCodigoPessoa);
		
		modelo = persistencia.buscar(modelo);
		
		visual.menuFuncionario(modelo.getNome());
		
		return true;
	}

	// GETTERS AND SETTERS
	public VisualPessoa getVisual() {
		return visual;
	}
	public void setVisual(VisualPessoa visual) {
		this.visual = visual;
	}
	public Persistencia<ModeloPessoa> getPersistencia() {
		return persistencia;
	}
	public void setPersistencia(Persistencia<ModeloPessoa> persistencia) {
		this.persistencia = persistencia;
	}
}
