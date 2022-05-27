package com.sptech.apikraken.entity.keys;

import javax.persistence.Column;
import java.io.Serializable;

public class FollowKey implements Serializable {
    @Column(name = "fk_donor")
    private Integer donorId;

    @Column(name = "fk_ngo")
    private Integer ngoId;

    public FollowKey(Integer donorId, Integer ngoId) {
        this.donorId = donorId;
        this.ngoId = ngoId;
    }

    public FollowKey() {}

}
