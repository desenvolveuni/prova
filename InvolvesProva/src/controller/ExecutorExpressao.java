package controller;

import model.Arquivo;

public class ExecutorExpressao {
	
	public static void executarExpressao(Arquivo arquivo, String entrada) {
		if(Count.isCount(entrada)) {
			Count.executarCount(arquivo);
		} else if(CountDistinct.isCountDistinct(entrada)) {
	        CountDistinct.executarCountDistinct(arquivo, entrada);
		} else if (Filter.isFilter(entrada)) {
			Filter.executarFilter(arquivo, entrada);
		}
	}
	
}
