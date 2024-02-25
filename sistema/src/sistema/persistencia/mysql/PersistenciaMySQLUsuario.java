package sistema.persistencia.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sistema.modelo.ModeloUsuario;
import sistema.persistencia.interfaces.Persistencia;

public class PersistenciaMySQLUsuario implements Persistencia<ModeloUsuario>{
	// CONSTRUTOR
	public PersistenciaMySQLUsuario() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	@Override
	public ModeloUsuario buscar(ModeloUsuario prModelo) {
		ModeloUsuario resultado;
		
		// CRIA O CODIGO DA PESQUISA
		String sql = "SELECT * "
				+ "   FROM USUARIO "
				+ "   WHERE USU_USUARIO = ? AND USU_SENHA = ?";

		try {
			PreparedStatement st = ConexaoMySQL.getInstance().getConexao().prepareStatement(sql);
			
			// CONCATENA OS DADOS NA STRING DE PESQUISA
			st.setString(1, prModelo.getUsuario());
			st.setString(2, prModelo.getSenha());
			
			try (ResultSet vQuery = st.executeQuery()){
				if (vQuery.next()) {
					resultado = new ModeloUsuario();
					
					resultado.setCodigo(vQuery.getInt("USU_CODIGO"));
					resultado.setUsuario(vQuery.getString("USU_USUARIO"));
					resultado.setSenha(vQuery.getString("USU_SENHA"));
					resultado.setTipo(vQuery.getInt("USU_TIPO"));
					resultado.setPessoa(vQuery.getInt("PES_CODIGO"));
					
					return resultado;
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return null;
	}
	
	@Override
	public boolean excluir(ModeloUsuario prModelo) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean salvar(ModeloUsuario prModelo) {
		// TODO Auto-generated method stub
		return false;
	}
}
