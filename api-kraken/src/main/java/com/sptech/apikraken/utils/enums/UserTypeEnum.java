package com.sptech.apikraken.utils.enums;

public enum UserTypeEnum {

    USER_NGO(1), USER_DONOR(2);

    private final int type;

    UserTypeEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }
}
