package controller;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class ManipuladorArquivoTest {
    
    @Test
    public void preencheCabecalho() {
        String[] elemento = new String[2];
        elemento[0] = "nome";
        elemento[1] = "uf";

        ArrayList<String> cabecalho = ManipuladorArquivo.preencherCabecalho(elemento);
        assertEquals(2, cabecalho.size());
    }
}
