package controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

import model.Arquivo;
import model.Expressao;
import model.ExpressaoEnum;
import model.TipoErroEnum;


public class Filter extends Expressao {
	
	public static void executarFilter(Arquivo arquivo, String entrada) {
		Matcher m = matcher(ExpressaoEnum.FILTER.expressao(), entrada);
		
		while (m.find()) {
			int posicao = Arquivo.retornarPosicaoCabecalho(arquivo, m.group("propriedade"));
			if(Arquivo.isPosicaoCabecalhoValida(posicao)) {
				List<String[]> listaFiltrada = filtrarElementos(arquivo, posicao, m.group("valor"));
				if(!listaFiltrada.isEmpty()) {
				    imprimirLista(arquivo, listaFiltrada);
				} else {
				    Mensagem.imprimirErro(TipoErroEnum.REGISTRO_NAO_ENCONTRADO.descricao());
				}
			} else {
				Mensagem.imprimirErro(TipoErroEnum.PROPRIEDADE_NAO_EXISTENTE.descricao());
			}
		}
	}
	
	private static List<String[]> filtrarElementos(Arquivo arquivo, int posicao, String valor) {
		return arquivo.getElementos().stream()
				.filter(x -> x[posicao].equals(valor))
		        .collect(Collectors.toList());
	}
	
	private static void imprimirLista(Arquivo arquivo, List<String[]> listaFiltrada) {
		imprimirCabecalho(arquivo);
		System.out.println(" ");
        imprimirElementos(listaFiltrada);
	}
	
	private static void imprimirElementos(List<String[]> listaFiltrada) {
		for (int i = 0; i < listaFiltrada.size(); i++) {
			for (int j = 0; j < listaFiltrada.get(i).length; j++) {
				System.out.print(listaFiltrada.get(i)[j] + " ");
			}
			System.out.println(" ");
		}
	}
	
	private static void imprimirCabecalho(Arquivo arquivo) {
		arquivo.getCabecalho().stream().forEach(titulo -> System.out.print(titulo + " "));
	}
	
	public static boolean isFilter(String entrada) {
		return entrada.matches(ExpressaoEnum.FILTER.expressao());
	}
}
