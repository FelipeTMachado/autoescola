package sistema.sistema;

public class FabricaControle {
	private static FabricaControle fabrica;
	
	private FabricaControle() {
		
	}
	
	public FabricaControle getInstance() {
		if (fabrica == null) {
			fabrica = new FabricaControle();
			return fabrica;
		} else 
			return fabrica;
	}
	
//	public ControleUsuario criarControleUsuario() {
//		return new ControleUsuario(P);
//	}
}
