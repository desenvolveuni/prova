package controller;

import java.util.regex.Matcher;

import model.Arquivo;
import model.Expressao;
import model.ExpressaoEnum;
import model.TipoErroEnum;

public class CountDistinct extends Expressao{
	
	public static void executarCountDistinct(Arquivo arquivo, String entrada) {
		Matcher m = matcher(ExpressaoEnum.COUNT_DISTINCT.expressao(), entrada);
		
		if(m.find()) {
			int posicao = Arquivo.retornarPosicaoCabecalho(arquivo, m.group("propriedade"));
			if(Arquivo.isPosicaoCabecalhoValida(posicao)) {
				System.out.println(contarElementosUnicos(arquivo, posicao));
			} else {
				Mensagem.imprimirErro(TipoErroEnum.PROPRIEDADE_NAO_EXISTENTE.descricao());
			}
		}
	}
	
	private static long contarElementosUnicos(Arquivo arquivo, int posicao) {
		return arquivo.getElementos().stream()
		        .map(x -> x[posicao])
		        .distinct()
		        .count();
	}
	
	public static boolean isCountDistinct(String entrada) {
		return entrada.matches(ExpressaoEnum.COUNT_DISTINCT.expressao());
	}
}
