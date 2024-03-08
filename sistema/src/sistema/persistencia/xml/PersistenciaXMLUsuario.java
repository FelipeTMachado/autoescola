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

import sistema.modelo.ModeloUsuario;
import sistema.persistencia.interfaces.Persistencia;

public class PersistenciaXMLUsuario implements Persistencia<ModeloUsuario>{
	// ATRIBUTOS
	private List<ModeloUsuario> listaUsuarios = new ArrayList<ModeloUsuario>();
	private String pastaDestino = "dados/xml";
	private String nomeArquivo = "usuario.xml";
	private String local = pastaDestino + "/" + nomeArquivo;
	
	// ATRIBUTOS XML
	private Document documento;
	private Element root;
	
	
	// CONSTRUTOR
	public PersistenciaXMLUsuario() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	// METODOS DA INTERFACE
	@Override
	public ModeloUsuario buscar(ModeloUsuario prModelo) {
		buscarTodosUsuarios();
		
		for (ModeloUsuario modelo : listaUsuarios) {
			if (prModelo.getCodigo() == -1) {
				if (modelo.getUsuario().equals(prModelo.getUsuario())) {
		    		if (modelo.getSenha().equals(prModelo.getSenha())) {
		    			listaUsuarios.clear();
			    		return modelo;
			    	}
		    	}
			} else {
				if (modelo.getCodigo() == prModelo.getCodigo()) {
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
		File arquivo = new File(local);
		
		
		try {
			if (arquivo.exists()) {
				SAXBuilder builder = new SAXBuilder();
				
				documento = builder.build(arquivo);
				root = (Element) documento.getRootElement();
				
				List<Element> usuarios = root.getChildren();
				
				for (Element elemento: usuarios) {
					ModeloUsuario usu = new ModeloUsuario();
					
					usu.setCodigo(Integer.parseInt(elemento.getAttributeValue("COD_USUARIO")));
					usu.setPessoa(Integer.parseInt(elemento.getChildText("PES_CODIGO")));
					usu.setSenha(elemento.getChildText("USU_SENHA"));
					usu.setUsuario(elemento.getChildText("USU_USUARIO"));
					usu.setTipo(Integer.parseInt(elemento.getChildText("USU_TIPO")));
					
					listaUsuarios.add(usu);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean salvarTodosUsuarios() {
		criarArquivo();
		if (!listaUsuarios.isEmpty()) {
			// CRIA O DOCUMENTO
			documento         = new Document();
			
			// DEFINE O ELEMENTO QUE SERA O ROOT
			root              = new Element("USUARIOS");		
			documento.setRootElement(root);
			
			for (ModeloUsuario modelo: listaUsuarios) {
				Element usu = new Element("USUARIO");
				usu.setAttribute("COD_USUARIO", String.format("%d", modelo.getCodigo()));
				
				Element pes_codigo = new Element("PES_CODIGO");
				pes_codigo.setText(String.format("%d", modelo.getPessoa()));
				
				Element usu_tipo = new Element("USU_TIPO");
				usu_tipo.setText(String.format("%d", modelo.getTipo()));
				
				Element usu_usuario = new Element("USU_USUARIO");
				usu_usuario.setText(modelo.getUsuario());
				
				Element usu_senha = new Element("USU_SENHA");
				usu_senha.setText(modelo.getSenha());
				
				
				usu.addContent(pes_codigo);
				usu.addContent(usu_usuario);
				usu.addContent(usu_senha);
				usu.addContent(usu_tipo);
				root.addContent(usu);
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

	// ARQUIVOS
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
