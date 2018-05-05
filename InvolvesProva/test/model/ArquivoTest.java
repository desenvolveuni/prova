package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class ArquivoTest {
   
    @Test
    public void retornaPosicaoValidaCabecalho() {
        Arquivo arquivo = new Arquivo();
        arquivo.setCabecalho(retornaCabecalho());
        assertEquals(1, Arquivo.retornarPosicaoCabecalho(arquivo, "uf"));
    }
    
    @Test
    public void retornaPosicaoInvalidaCabecalho() {
        Arquivo arquivo = new Arquivo();
        arquivo.setCabecalho(retornaCabecalho());
        assertEquals(-1, Arquivo.retornarPosicaoCabecalho(arquivo, "capital"));
    }
    
    @Test
    public void posicaoValida() {
        int posicao = 1;
        assertTrue(Arquivo.isPosicaoCabecalhoValida(posicao));
    }
    
    @Test
    public void posicaoInvalida() {
        int posicao = -1;
        assertFalse(Arquivo.isPosicaoCabecalhoValida(posicao));
    }
    
    private ArrayList<String> retornaCabecalho() {
        ArrayList<String> cabecalho = new ArrayList<>();
        cabecalho.addAll(Arrays.asList("nome", "uf"));
        return cabecalho;
    }
}
