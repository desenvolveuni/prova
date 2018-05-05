package controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.Arquivo;
import model.ArquivoBuilder;

public class CountDistinctTest {
    
    private Arquivo arquivo = new Arquivo();
    
    @Before
    public void setUp() {
        ArquivoBuilder arquivoBuilder = new ArquivoBuilder();
        arquivo = arquivoBuilder.comCabecalho().comElemento().constroi();
    }
    
    @Test
    public void executaCountExpressaoValida() {
        CountDistinct.executarCountDistinct(arquivo, "count distinct [uf]");
    }
    
    @Test
    public void executaCountExpressaoInvalida() {
        CountDistinct.executarCountDistinct(arquivo, "count distinct [coluna]");
    }
    
    @Test
    public void expressaoPertenceAoTipoDistinctCount() {
        assertTrue(CountDistinct.isCountDistinct("count distinct [uf]"));
    }
    
    @Test
    public void expressaoNaoPertenceAoTipoDistinctCount() {
        assertFalse(CountDistinct.isCountDistinct("count distinct[]"));
    }
}
