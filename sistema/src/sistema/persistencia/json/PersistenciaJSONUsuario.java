package sistema.persistencia.json;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import sistema.modelo.ModeloUsuario;
import sistema.persistencia.interfaces.Persistencia;

public class PersistenciaJSONUsuario implements Persistencia<ModeloUsuario> {
	private List<ModeloUsuario> listaUsuarios = new ArrayList<ModeloUsuario>();
	
	// CONSTRUTOR
	public PersistenciaJSONUsuario() {
		// TODO Auto-generated constructor stub
	}
	
	public void buscarTodosUsuarios() {
		listaUsuarios.clear();
		
		BufferedReader leitor = null;
		
		try {
			leitor = new BufferedReader(new FileReader("dados/json/usuario.json"));
			
			
		} catch (FileNotFoundException e) {
			// TODO TRATAR ERRO E PASSAR PARA FRENTE
		}
		
		Type listType = new TypeToken<ArrayList<ModeloUsuario>>(){}.getType();
	    listaUsuarios = new ArrayList<ModeloUsuario>();
	    listaUsuarios = new Gson().fromJson(leitor, listType);
	}

	public boolean gravarTodosUsuarios() {
		GsonBuilder construtorGson = new GsonBuilder();
		Gson gson = construtorGson.create();
		
		
		FileWriter escritor;
		try {
			escritor = new FileWriter("dados/json/usuario.json");
			escritor.write(gson.toJson(listaUsuarios));
		
			escritor.close();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
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
		
		listaUsuarios = null;
		listaUsuarios = listaAlterada;
		
		return gravarTodosUsuarios();
	}
	
	
	
	@Override
	public boolean salvar(ModeloUsuario prModelo) {
		buscarTodosUsuarios();
		
		listaUsuarios.add(prModelo);
		
		return gravarTodosUsuarios();
	}
}
