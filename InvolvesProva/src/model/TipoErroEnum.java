package model;

public enum TipoErroEnum {
    REGISTRO_NAO_ENCONTRADO("Não existem registros com esse valor"),
    PROPRIEDADE_NAO_EXISTENTE("Essa propriedade não existe"),
    EXPRESSAO_INVALIDA("Expressão inválida");

    private String descricao;

    TipoErroEnum(String descricao) {
        this.descricao = descricao;
    }

    public String descricao() {
        return descricao;
    }
}
