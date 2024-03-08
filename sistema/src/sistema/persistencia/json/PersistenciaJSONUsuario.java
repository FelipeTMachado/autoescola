package sistema.persistencia.json;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import sistema.modelo.ModeloUsuario;
import sistema.persistencia.interfaces.Persistencia;

public class PersistenciaJSONUsuario implements Persistencia<ModeloUsuario> {
	// ATRIBUTOS
	private List<ModeloUsuario> listaUsuarios = new ArrayList<ModeloUsuario>();
	private String LocalArquivo = "dados/json/usuario.json";
	
	
	
	// CONSTRUTOR
	public PersistenciaJSONUsuario() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	// METODOS DA INTERFACE
	@Override
	public ModeloUsuario buscar(ModeloUsuario prModelo) {
		buscarTodosUsuarios();
	    
	    for (ModeloUsuario modelo : listaUsuarios) {
	    	if (modelo.getUsuario().equals(prModelo.getUsuario())) {
	    		if (modelo.getSenha().equals(prModelo.getSenha())) {
	    			listaUsuarios.clear();
		    		return modelo;
		    	}
	    	}
	    }
		
		return null;
	}
	
	@Override
	public boolean excluir(ModeloUsuario prModelo) {
		buscarTodosUsuarios();
		
		List<ModeloUsuario> listaAlterada = new ArrayList<ModeloUsuario>();
		
		
		for (ModeloUsuario modelo: listaUsuarios) {
			if (!(prModelo.getCodigo() == modelo.getCodigo())) {
				listaAlterada.add(modelo);
			}
		}
		
//		listaUsuarios = null;
		listaUsuarios = listaAlterada;
		
		return salvarTodosUsuarios();
	}
	
	@Override
	public boolean salvar(ModeloUsuario prModelo) {
		buscarTodosUsuarios();
		
		if (buscar(prModelo) == null) {
			listaUsuarios.add(prModelo);
			return salvarTodosUsuarios();
		}
		
		return false;
	}
	
	public int buscarProximo() {
		buscarTodosUsuarios();
		
		
		if (listaUsuarios.isEmpty()) {
			return 1;
		} else {
			ModeloUsuario modeloAux = null;
			for (ModeloUsuario modelo: listaUsuarios) {
				modeloAux = modelo;
			}
			
			return modeloAux.getCodigo() + 1;
		}
	}
	
	// METODOS DE SUPORTE
	public void buscarTodosUsuarios() {
		listaUsuarios.clear();
		
		boolean exists = (new File(LocalArquivo)).exists();
		
		if (exists) {
			BufferedReader leitor = null;
			
			try {
				leitor = new BufferedReader(new FileReader(LocalArquivo));
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			Type listType = new TypeToken<ArrayList<ModeloUsuario>>(){}.getType();
		    listaUsuarios = new Gson().fromJson(leitor, listType);
		}
	}

	public boolean salvarTodosUsuarios() {
		GsonBuilder construtorGson = new GsonBuilder();
		Gson gson = construtorGson.create();
		
		
		FileWriter escritor;
		try {
			escritor = new FileWriter(LocalArquivo);
			escritor.write(gson.toJson(listaUsuarios));
		
			escritor.close();
			listaUsuarios.clear();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
