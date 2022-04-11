package com.sptech.apikraken.dto;

import com.sptech.apikraken.entity.User;

public class PayloadRetornoLogon {
    private User user;
    private boolean isValid;

    public PayloadRetornoLogon() {}

    public PayloadRetornoLogon(User user, boolean isValid) {
        this.user = user;
        this.isValid = isValid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
            isValid = valid;
        }
}
