package com.sptech.apikraken.utils.enums;

public enum NGOCategoryEnum {

    ASSIS_SOCIAL(1),
    CULTURA(2),
    DESENV_DEF_DIREITOS(3),
    EDUC_PESQUISA(4),
    HABILITACAO(5),
    MEIO_AMBIENTE(6),
    SAUDE(7);

    private final int category;

    NGOCategoryEnum(int category) {
        this.category = category;
    }

    public int getCategory() {
        return category;
    }

}
