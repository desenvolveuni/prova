package controller;

import model.Arquivo;
import model.Expressao;
import model.ExpressaoEnum;

public class Count extends Expressao {
	
	public static void executarCount(Arquivo arquivo) {
		System.out.println(contarElementos(arquivo));
	}
	
	private static long contarElementos(Arquivo arquivo) {
		return arquivo.getElementos().size();
	}
	
	public static boolean isCount(String entrada) {
		return entrada.matches(ExpressaoEnum.COUNT.expressao());
	}
	
}
