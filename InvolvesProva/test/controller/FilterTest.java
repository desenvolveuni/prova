package controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.Arquivo;
import model.ArquivoBuilder;

public class FilterTest {
    
    private Arquivo arquivo = new Arquivo();
    
    @Before
    public void setUp() {
        ArquivoBuilder arquivoBuilder = new ArquivoBuilder();
        arquivo = arquivoBuilder.comCabecalho().comElemento().constroi();
    }
    
    @Test
    public void executaFilterExpressaoValidaEInformacaoExistente() {
        Filter.executarFilter(arquivo, "filter [uf] [SC]");
    }
    
    @Test
    public void executaFilterPropriedadeInvalida() {
        Filter.executarFilter(arquivo, "filter [[uf] [SC]");
    }
    
    @Test
    public void executaFilterInformacaoExistente() {
        Filter.executarFilter(arquivo, "filter [uf] [RO]");
    }
    
    @Test
    public void expressaoPertenceAoTipoFilter() {
        assertTrue(Filter.isFilter("filter [propriedade] [valor]"));
    }
    
    @Test
    public void expressaoNaoPertenceAoTipoFilter() {
        assertFalse(Filter.isFilter("filter [propriedade]"));
    }
}
