package com.sptech.apikraken.dto.response.logon;

import com.sptech.apikraken.entity.Donor;
import com.sptech.apikraken.entity.NGO;
import com.sptech.apikraken.entity.User;

public class PayloadRetornoLogon {
    private User user;
    private Donor donor;
    private NGO ngo;
    private boolean isValid;

    public PayloadRetornoLogon() {}

    public PayloadRetornoLogon(User user, Donor donor, boolean isValid) {
        this.user = user;
        this.donor = donor;
        this.isValid = isValid;
    }

    public PayloadRetornoLogon(User user, NGO ngo, boolean isValid) {
        this.user = user;
        this.ngo = ngo;
        this.isValid = isValid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public NGO getNgo() {
        return ngo;
    }

    public void setNgo(NGO ngo) {
        this.ngo = ngo;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
            isValid = valid;
        }
}
