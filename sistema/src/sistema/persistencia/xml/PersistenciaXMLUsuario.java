package sistema.persistencia.xml;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import sistema.modelo.ModeloUsuario;
import sistema.persistencia.interfaces.Persistencia;

public class PersistenciaXMLUsuario implements Persistencia<ModeloUsuario>{
	private List<ModeloUsuario> listaUsuarios = new ArrayList<ModeloUsuario>();
	private String LocalArquivo = "dados/xml/usuario.xml";
	
	
	// CONSTRUTOR
	public PersistenciaXMLUsuario() {
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public boolean salvar(ModeloUsuario prModelo) {
		gravarTodosUsuarios();
		
		return false;
	}
	
	public void buscarTodosUsuarios() {
		listaUsuarios.clear();
	
		Document documento = null;
		
		SAXBuilder construtor = new SAXBuilder();
		try {
			documento = construtor.build(LocalArquivo);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
		
		Element total = documento.getRootElement();
		
		List<Element> lista = total.getChildren("usuario");
		
		for (Iterator<Element> i = lista.iterator(); i.hasNext();) {
			Element elemento = (Element) i.next();
			
			ModeloUsuario modelo = new ModeloUsuario();
			modelo.setCodigo(Integer.parseInt(elemento.getAttributeValue("usu_codigo")));
			modelo.setPessoa(Integer.parseInt(elemento.getChildText("pes_codigo")));
			modelo.setSenha(elemento.getChildText("usu_senha"));
			modelo.setUsuario(elemento.getChildText("usu_usuario"));
			modelo.setTipo(Integer.parseInt(elemento.getChildText("usu_tipo")));
			
			listaUsuarios.add(modelo);
		}
	}
	
	public boolean gravarTodosUsuarios() {
		// CRIAR ELEMENTO QUE SERA O ROOT 
		Element total = new Element("usuarios");
		// SETA O ELEMENTO COMO ROOT
		Document documento = new Document(total);
		
		// ELEMENTO QUE NOMEIA A PERSISTENCIA
		Element titulo = new Element("titulo");
		titulo.setText("Usuarios");
		
		// ADICIONA O TITULO NA TAG PRINCIPAL
		total.addContent(titulo);
		
		for (ModeloUsuario modelo: listaUsuarios) {
			Element usuario = new Element("usuario");
			usuario.setAttribute("usu_codigo", String.format("%d", modelo.getCodigo()));
			
			Element usu_usuario = new Element("usu_usuario");
			usu_usuario.setText(modelo.getUsuario());
			
			Element usu_senha = new Element("usu_senha");
			usu_senha.setText(modelo.getSenha());
			
			Element pes_codigo = new Element("pes_codigo");
			pes_codigo.setText(String.format("%d", modelo.getPessoa()));
		
			Element usu_tipo = new Element("usu_tipo");
			usu_tipo.setText(String.format("%d", modelo.getTipo()));
			
			
			usuario.addContent(usu_usuario);
			usuario.addContent(usu_senha);
			usuario.addContent(pes_codigo);
			usuario.addContent(usu_tipo);
			
			total.addContent(usuario);
		}
		
		XMLOutputter geradorXML = new XMLOutputter();
		
		try {
			BufferedWriter arquivo = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(LocalArquivo), "UTF-8"));
			geradorXML.output(documento, arquivo);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
				
		return false;
	}
}
