package model;

import java.util.ArrayList;
import java.util.Arrays;

public class ArquivoBuilder {
	
    private ArrayList<String[]> elementos = new ArrayList<>();
    
    private ArrayList<String> cabecalho = new ArrayList<>();
    
    public ArquivoBuilder comCabecalho() {
        cabecalho.addAll(Arrays.asList("nome", "uf"));
        return this;
    }
    
    public ArquivoBuilder comElemento() {
        String[] elemento = new String[2];;
        elemento[0] = "Tubarao";
        elemento[1] = "SC";
        elementos.add(elemento);
        return this;
    }
    
    public ArquivoBuilder completo() {
        comCabecalho();
        comElemento();
        return this;
    }
    
    public Arquivo constroi() {
        Arquivo arquivo = new Arquivo();
        arquivo.setCabecalho(cabecalho);
        arquivo.setElementos(elementos);
        return arquivo;
    }
}
