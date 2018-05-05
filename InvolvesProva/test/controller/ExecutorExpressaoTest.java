package controller;

import org.junit.Before;
import org.junit.Test;

import model.Arquivo;
import model.ArquivoBuilder;

public class ExecutorExpressaoTest {

    private Arquivo arquivo = new Arquivo();
    
    @Before
    public void setUp() {
        ArquivoBuilder arquivoBuilder = new ArquivoBuilder();
        arquivo = arquivoBuilder.comCabecalho().comElemento().constroi();
    }
    
    @Test
    public void executaExpressaoCount() {

;
    }
    
    @Test
    public void executaExpressaoFilter() {
        ExecutorExpressao.executarExpressao(arquivo, "filter [uf] [SC]");
    }
    
    @Test
    public void executaExpressaoCountDistinct() {
        ExecutorExpressao.executarExpressao(arquivo, "count distinct [uf]");
    }
}
