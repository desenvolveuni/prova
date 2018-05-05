package controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.Arquivo;
import model.ArquivoBuilder;


public class CountTest {

    private Arquivo arquivo = new Arquivo();
    
    @Before
    public void setUp() {
        ArquivoBuilder arquivoBuilder = new ArquivoBuilder();
        arquivo = arquivoBuilder.comCabecalho().comElemento().constroi();
    }
    
    @Test
    public void executaCount() {
        Count.executarCount(arquivo);
    }
    
    @Test
    public void expressaoPertenceAoTipoCount() {
        assertTrue(Count.isCount("count*"));
    }
    
    @Test
    public void expressaoNaoPertenceAoTipoCount() {
        assertFalse(Count.isCount("ccount*"));
    }
}
