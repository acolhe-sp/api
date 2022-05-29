package com.sptech.apikraken.dto.response.donor;

import com.sptech.apikraken.entity.NGO;

import java.util.List;

public class DonorFollowing {

    private Integer qtdNGOFollowing;
    private List<NGO> ngosFollowing;

    public DonorFollowing(Integer qtdNGOFollowing, List<NGO> ngosFollowing) {
        this.qtdNGOFollowing = qtdNGOFollowing;
        this.ngosFollowing = ngosFollowing;
    }

    public Integer getQtdNGOFollowing() {
        return qtdNGOFollowing;
    }

    public void setQtdNGOFollowing(Integer qtdNGOFollowing) {
        this.qtdNGOFollowing = qtdNGOFollowing;
    }

    public List<NGO> getNgosFollowing() {
        return ngosFollowing;
    }

    public void setNgosFollowing(List<NGO> ngosFollowing) {
        this.ngosFollowing = ngosFollowing;
    }
}
