package controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidadorExpressaoTest {
    
    @Test
    public void expressaoValida() {
        assertTrue(ValidadorExpressao.validarExpressao("count*"));
    }
    
    @Test
    public void expressaoInvalida() {
        assertFalse(ValidadorExpressao.validarExpressao("count"));
    }
}
