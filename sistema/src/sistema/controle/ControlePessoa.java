package sistema.controle;

import sistema.modelo.ModeloPessoa;
import sistema.persistencia.interfaces.Persistencia;
import sistema.visual.VisualPessoa;

public class ControlePessoa {
	VisualPessoa visual;
	private Persistencia<ModeloPessoa> persistencia;
	
	public ControlePessoa(Persistencia<ModeloPessoa> prPersistencia) {
		persistencia = prPersistencia;
	}
	
	public boolean menuAluno() {
		visual = new VisualPessoa();
		visual.menuAluno("FELIPE");
		
		return true;
	}
	
	public boolean menuFuncionario() {
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
