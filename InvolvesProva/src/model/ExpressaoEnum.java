package model;

public enum ExpressaoEnum {
    COUNT_DISTINCT("(count distinct) (\\[(?<propriedade>.*?)\\])"),
    FILTER("filter (\\[(?<propriedade>.*?)\\]) (\\[(?<valor>.*?)\\])"),
    COUNT("count\\*");

    private String expressao;

    ExpressaoEnum(String expressao) {
        this.expressao = expressao;
    }

    public String expressao() {
        return expressao;
    }
}
