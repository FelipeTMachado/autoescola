package sistema.persistencia.xml;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import sistema.modelo.ModeloPessoa;
import sistema.persistencia.interfaces.Persistencia;

public class PersistenciaXMLPessoa implements Persistencia<ModeloPessoa>{
	// ATRIBUTOS
	private List<ModeloPessoa> listaPessoas = new ArrayList<ModeloPessoa>();
	private String pastaDestino = "dados/xml";
	private String nomeArquivo = "pessoa.xml";
	private String local = pastaDestino + "/" + nomeArquivo;
	
	// ATRIBUTOS XML
	private Document documento;
	private Element root;
	
	
	// CONSTRUTOR
	public PersistenciaXMLPessoa() {
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
		File arquivo = new File(local);
		
		
		try {
			if (arquivo.exists()) {
				SAXBuilder builder = new SAXBuilder();
				
				documento = builder.build(arquivo);
				root = (Element) documento.getRootElement();
				
				List<Element> pessoas = root.getChildren();
				
				for (Element elemento: pessoas) {
					ModeloPessoa pes = new ModeloPessoa();
					
					pes.setCodigo(Integer.parseInt(elemento.getAttributeValue("COD_PESSOA")));
					pes.setNome(elemento.getChildText("PES_NOME"));
					pes.setCpf(elemento.getChildText("PES_CPF"));
					
					listaPessoas.add(pes);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean salvarTodasPessoas() {
		criarArquivo();
		if (!listaPessoas.isEmpty()) {
			// CRIA O DOCUMENTO
			documento         = new Document();
			
			// DEFINE O ELEMENTO QUE SERA O ROOT
			root              = new Element("PESSOAS");		
			documento.setRootElement(root);
			
			for (ModeloPessoa modelo: listaPessoas) {
				Element pessoa = new Element("PESSOA");
				pessoa.setAttribute("COD_PESSOA", String.format("%d", modelo.getCodigo()));
				
				Element nome = new Element("PES_NOME");
				nome.setText(modelo.getNome());
				
				Element cpf = new Element("PES_CPF");
				cpf.setText(modelo.getCpf());
				
				pessoa.addContent(nome);
				pessoa.addContent(cpf);
				root.addContent(pessoa);
			}
			
			try {
				XMLOutputter xout = new XMLOutputter();
				OutputStream out = new FileOutputStream(new File(local));
				xout.output(documento, out);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
			
			return true;
		} else {
			return false;
		}
	}

	private File criarArquivo() {
		File arquivo = new File(local);
		File locall = new File(pastaDestino);
		
		try {
			if (!arquivo.exists()) {	
				locall.mkdir();
				arquivo.createNewFile();
			} else {
				arquivo.delete();
				arquivo.createNewFile();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return arquivo;
	}
}
