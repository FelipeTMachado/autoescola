package sistema.persistencia.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import sistema.modelo.ModeloPessoa;
import sistema.persistencia.interfaces.Persistencia;

public class PersistenciaMySQLPessoa implements Persistencia<ModeloPessoa>{
	public PersistenciaMySQLPessoa() {
		// TODO Auto-generated constructor stub
	}
	
	public ModeloPessoa buscarPorCpf(String prCpf) {
		ModeloPessoa resultado;
		
		// CRIA O CODIGO DA PESQUISA
		String sql = "SELECT * "
				+ "   FROM PESSOA "
				+ "   WHERE PES_CPF = ?";

		try {
			PreparedStatement st = ConexaoMySQL.getInstance().getConexao().prepareStatement(sql);
			
			// CONCATENA OS DADOS NA STRING DE PESQUISA
			st.setString(1, prCpf);
			
			try (ResultSet vQuery = st.executeQuery()){
				if (vQuery.next()) {
					resultado = new ModeloPessoa();
					
					resultado.setCodigo(vQuery.getInt("PES_CODIGO"));
					resultado.setNome(vQuery.getString("PES_NOME"));
					resultado.setCpf(vQuery.getString("PES_CPF"));

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
	
	public ModeloPessoa buscarPorCodigo(int prCodigo) {
		ModeloPessoa resultado;
		
		// CRIA O CODIGO DA PESQUISA
		String sql = "SELECT * "
				+ "   FROM PESSOA "
				+ "   WHERE PES_CODIGO = ?";

		try {
			PreparedStatement st = ConexaoMySQL.getInstance().getConexao().prepareStatement(sql);
			
			// CONCATENA OS DADOS NA STRING DE PESQUISA
			st.setInt(1, prCodigo);
			
			try (ResultSet vQuery = st.executeQuery()){
				if (vQuery.next()) {
					resultado = new ModeloPessoa();
					
					resultado.setCodigo(vQuery.getInt("PES_CODIGO"));
					resultado.setNome(vQuery.getString("PES_NOME"));
					resultado.setCpf(vQuery.getString("PES_CPF"));

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
	public ModeloPessoa buscar(ModeloPessoa prModelo) {
		if (prModelo.getCodigo() != 0) {
			return buscarPorCodigo(prModelo.getCodigo());
		} else {
			return buscarPorCpf(prModelo.getCpf());
		}
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
