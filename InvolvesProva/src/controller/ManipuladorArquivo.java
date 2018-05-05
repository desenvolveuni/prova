package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.Arquivo;


public class ManipuladorArquivo {
	
	private static Arquivo arquivo = new Arquivo();

	public static Arquivo lerArquivo(String caminho) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(caminho)));
	    
	    ArrayList<String[]> elementos = new ArrayList<>();
		ArrayList<String> cabecalho = new ArrayList<>();
		
        String linha = null;
        boolean primeiraLinha = true;
        while ((linha = reader.readLine()) != null) {

        	String[] dadosLinha = linha.split(",");
        	String[] elemento = new String[dadosLinha.length];
        	
        	for (int i = 0; i < dadosLinha.length; i++) {
        	    elemento[i] = dadosLinha[i];
			}
        	
        	if (primeiraLinha) {
                cabecalho = preencherCabecalho(elemento);
        	} else {
        		elementos.add(elemento);
        	}
		    primeiraLinha = false;
        }
        reader.close();
        
        arquivo.setCabecalho(cabecalho);
        arquivo.setElementos(elementos);
        
        return arquivo;
	}
	
	public static ArrayList<String> preencherCabecalho(String[] elemento) {
		ArrayList<String> cabecalho = new ArrayList<>();

		for (int i = 0; i < elemento.length; i++) {
			cabecalho.add(elemento[i]);
		}
		return cabecalho;
	}
}
