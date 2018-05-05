package model;

import java.util.ArrayList;

public class Arquivo {
	
    private ArrayList<String[]> elementos = new ArrayList<>();
    private ArrayList<String> cabecalho = new ArrayList<>();
    
	public static int retornarPosicaoCabecalho(Arquivo arquivo, String propriedade) {
		for (int i = 0; i < arquivo.getCabecalho().size(); i++) {
			if (propriedade.equals(arquivo.getCabecalho().get(i))) {
				return i;
			}
		}
		return -1;
	}
	
	public static boolean isPosicaoCabecalhoValida(int posicao) {
		return posicao > 0;
	}

    public ArrayList<String[]> getElementos() {
        return elementos;
    }
	
    public void setElementos(ArrayList<String[]> elementos) {
        this.elementos = elementos;
    }
	
    public ArrayList<String> getCabecalho() {
        return cabecalho;
    }
	
    public void setCabecalho(ArrayList<String> cabecalho) {
        this.cabecalho = cabecalho;
    }
}
