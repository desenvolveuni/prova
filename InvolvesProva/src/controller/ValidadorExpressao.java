package controller;

import model.ExpressaoEnum;

public class ValidadorExpressao {
	
	public static boolean validarExpressao (String entrada) {
		for (ExpressaoEnum expressao : ExpressaoEnum.values()) {
			if(entrada.matches(expressao.expressao())) {
				return true;
			}
		}
		return false;
	}
	
}
