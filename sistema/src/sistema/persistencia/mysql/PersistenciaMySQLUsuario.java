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

	
	// METODOS DA INTERFACE
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
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	@Override
	public boolean excluir(ModeloUsuario prModelo) {
		String sql = "DELETE FROM USUARIO WHERE USU_CODIGO == ?";
		
		try (PreparedStatement st = ConexaoMySQL.getInstance().getConexao().prepareStatement(sql)){
			st.setInt(1, prModelo.getCodigo());
			
			st.execute();
			return true;			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}
	
	@Override
	public boolean salvar(ModeloUsuario prModelo) {
		String sql = "INSERT INTO USUARIO (USU_USUARIO, USU_SENHA, USU_TIPO, PES_CODIGO) VALUES (?, ?, ?, ?)";
		
		try (PreparedStatement st = ConexaoMySQL.getInstance().getConexao().prepareStatement(sql)){
			st.setString(1, prModelo.getUsuario());
			st.setString(2, prModelo.getSenha());
			st.setInt(3, prModelo.getTipo());
			st.setInt(4, prModelo.getPessoa());
			
			st.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public int buscarProximo() {
		return 10;
	}
}
