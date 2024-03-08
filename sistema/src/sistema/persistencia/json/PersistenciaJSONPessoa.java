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

import sistema.modelo.ModeloPessoa;
import sistema.persistencia.interfaces.Persistencia;

public class PersistenciaJSONPessoa implements Persistencia<ModeloPessoa> {
	// ATRIBUTOS
	private List<ModeloPessoa> listaPessoas = new ArrayList<ModeloPessoa>();
	private String LocalArquivo = "dados/json/pessoa.json";
	
	
	
	// CONSTRUTOR
	public PersistenciaJSONPessoa() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	// METODOS DA INTERFACE
	@Override
	public ModeloPessoa buscar(ModeloPessoa prModelo) {
		buscarTodasPessoas();
	    
	    for (ModeloPessoa modelo : listaPessoas) {
	    	if (modelo.getCpf().equals(prModelo.getCpf())) {
	    		listaPessoas.clear();
		    	return modelo;
		    }
	    	
	    	if (modelo.getCodigo() == prModelo.getCodigo()) {
	    		listaPessoas.clear();
		    	return modelo;
		    }
	    }
		
		return null;
	}
	
	@Override
	public boolean excluir(ModeloPessoa prModelo) {
		buscarTodasPessoas();
		
		List<ModeloPessoa> listaAlterada = new ArrayList<ModeloPessoa>();
		
		
		for (ModeloPessoa modelo: listaPessoas) {
			if (!(prModelo.getCpf().equals(modelo.getCpf()))) {
				listaAlterada.add(modelo);
			}
		}
		
		listaPessoas = null;
		listaPessoas = listaAlterada;
		
		return salvarTodasPessoas();
	}
	
	@Override
	public boolean salvar(ModeloPessoa prModelo) {
		buscarTodasPessoas();
		
		if (buscar(prModelo) == null) {
			listaPessoas.add(prModelo);
			return salvarTodasPessoas();
		}
		
		return false;
	}
	
	public int buscarProximo() {
		buscarTodasPessoas();
		
		
		if (listaPessoas.isEmpty()) {
			return 1;
		} else {
			ModeloPessoa modeloAux = null;
			for (ModeloPessoa modelo: listaPessoas) {
				modeloAux = modelo;
			}
			
			return modeloAux.getCodigo() + 1;
		}
	}
	
	
	// METODOS DE SUPORTE
	public void buscarTodasPessoas() {
		listaPessoas.clear();
		
		boolean exists = (new File(LocalArquivo)).exists();
		
		if (exists) {
			BufferedReader leitor = null;
			
			try {
				leitor = new BufferedReader(new FileReader(LocalArquivo));
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
			Type listType = new TypeToken<ArrayList<ModeloPessoa>>(){}.getType();
			listaPessoas = new Gson().fromJson(leitor, listType);
			
			if (listaPessoas == null) {
				listaPessoas = new ArrayList<ModeloPessoa>();
			}
		}
	}
	
	public boolean salvarTodasPessoas() {
		GsonBuilder construtorGson = new GsonBuilder();
		Gson gson = construtorGson.create();
		
		
		FileWriter escritor;
		try {
			escritor = new FileWriter(LocalArquivo);
			escritor.write(gson.toJson(listaPessoas));
		
			escritor.close();
			listaPessoas.clear();
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}	
