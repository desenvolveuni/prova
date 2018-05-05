package model;

import static org.junit.Assert.assertTrue;

import java.util.regex.Matcher;

import org.junit.Test;

public class ExpressaoTest {
    
    @Test
    public void matcher() {
        String expressaoCount = "count\\*";
        String entrada = "count*";
        Matcher matcher = Expressao.matcher(expressaoCount, entrada);
        assertTrue(matcher.find());
    }
}
