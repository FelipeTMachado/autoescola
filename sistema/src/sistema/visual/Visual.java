package sistema.visual;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

import sistema.sistema.Sistema;

public class Visual {
	private static int tamanhoTela = 80;
	
	public static void configurarTela(int prTamanhoTela) {
		Visual.tamanhoTela = prTamanhoTela;
	}
	
	// RETORNA DADO
	public String retornaDado(String prTexto) {
		if (prTexto.trim().equals("")) {
			System.out.print(prTexto);
			return Sistema.leitura.nextLine();
		} else {
			if (Sistema.console == null) {
				System.out.print("| " + prTexto);
				
				return Sistema.leitura.nextLine();
			} else {
				String msg = ("| " + prTexto);
				return Sistema.console.readLine(msg);
			}
		}
	}
	
	// RETORNA DADO COM MASCARA DE SENHA
	public String retornaPassword(String prTexto) {
		if (Sistema.console == null) {
			System.out.print("| " + prTexto);
			return Sistema.leitura.nextLine();
		} else {
			return new String(Sistema.console.readPassword("| " + prTexto));
		}
	}
	
	public String multiplicarCaracteres(String prCaractere) {
		return multiplicarCaracteres(prCaractere, tamanhoTela);
	};
	
	public String multiplicarCaracteres(String prCaractere, int prTamanho) {
		String caracteres = "";
		
		for (int i = 0; i < prTamanho; i++) {
			caracteres += prCaractere;
		}
		
		return caracteres;
	};
	
	public void visualizarTelaLimpa() {
		try {
            PrintWriter writer = new PrintWriter(new PrintStream(System.out, true, StandardCharsets.UTF_8.name()));

            // ENVIAR SEQUENCIA DE CONTROLE PARA LIMPAR O CONSOLE
            writer.print("\033[H\033[2J");
            writer.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
	}
	
	public void visualizarEspacoEmBranco() {		
		String espacos = "|" + multiplicarCaracteres(" ") + "|";
		
		System.out.println(espacos);
	}
	
	public void visualizarTitulo(String prTexto) {
		visualizarLinha();
		visualizarTextoAlinhadoCentro(prTexto);
		visualizarLinha();
	}
	
	public void visualizarLinha() {
		String linha = "+" + multiplicarCaracteres("-") + "+";
		
		System.out.println(linha);
	}
	
	public void visualizarTextoAlinhadoDireita(String prTexto) {
		System.out.println("|" + multiplicarCaracteres(" ", (Visual.tamanhoTela - prTexto.length() - 1)) + prTexto + " |");
	}
	
	public void visualizarTextoAlinhadoEsquerda(String prTexto) {		
		System.out.println("| " + prTexto + multiplicarCaracteres(" ", (Visual.tamanhoTela - prTexto.length() - 1)) + "|");
	}
	
	public void visualizarTextoAlinhadoCentro(String prTexto) {
		String textoFinal    = "";
	
		int espacoTotal = 0;
		
		espacoTotal = Visual.tamanhoTela - prTexto.length();
		
		if ((espacoTotal % 2) == 0) {
			String lado = multiplicarCaracteres(" ", espacoTotal / 2);
			
			textoFinal = lado + prTexto + lado;
		} else {
			String lado = multiplicarCaracteres(" ", espacoTotal / 2);
			
			textoFinal = lado + " " + prTexto + lado; 
		}
		
		System.out.println("|" + textoFinal + "|");
	}
}
