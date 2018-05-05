package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Expressao {
	
	public static Matcher matcher(String expressao, String entrada) {
		Pattern p = Pattern.compile(expressao);
		return p.matcher(entrada);
	}
	
}
