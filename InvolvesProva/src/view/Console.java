package view;

import java.io.IOException;
import java.util.Scanner;

import controller.ExecutorExpressao;
import controller.ManipuladorArquivo;
import controller.Mensagem;
import controller.ValidadorExpressao;
import model.Arquivo;
import model.TipoErroEnum;

public class Console {
	
	private static Arquivo arquivo = new Arquivo();
	private static final String SAIR = "sair";
	
	private static final String TITULO_CODIGO = "Código:";
	
	private static final String INFORMACAO_SAIR = "Para finalizar digite 'sair'";
	
	private static String path = Console.class.getResource("/arquivo/cidades.csv").getPath();
	
	public static void main(String[] args) throws IOException {
		arquivo = ManipuladorArquivo.lerArquivo(path);
		Scanner scan = new Scanner(System.in);
		String entrada = "";
		System.out.println(INFORMACAO_SAIR);
		
		do {
			scan = new Scanner(System.in);
			System.out.print(TITULO_CODIGO);
			entrada = scan.nextLine();
			
			if (!entrada.equals(SAIR)) {
				processaExpressao(entrada);
			} else {
				break;
			}
		} while (!entrada.equals(SAIR));
		
        scan.close();		
	}
	
	private static void processaExpressao(String entrada){
		if (expressaoValida(entrada)) {
			executarExpressao(entrada);	
		} else {
			Mensagem.imprimirErro(TipoErroEnum.EXPRESSAO_INVALIDA.descricao());
		}
	}
	
	private static void executarExpressao(String entrada) {
		ExecutorExpressao.executarExpressao(arquivo, entrada);
	}
	
	private static boolean expressaoValida(String entrada) {
		return ValidadorExpressao.validarExpressao(entrada);
	}
}
