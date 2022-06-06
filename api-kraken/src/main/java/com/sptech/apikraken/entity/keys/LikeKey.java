package com.sptech.apikraken.entity.keys;

import javax.persistence.Column;
import java.io.Serializable;

public class LikeKey implements Serializable {
    @Column(name = "fk_donor")
    private Integer donorId;

    @Column(name = "fk_post")
    private Integer postId;

    public LikeKey(Integer donorId, Integer postId) {
        this.donorId = donorId;
        this.postId = postId;
    }

    public LikeKey() {}
}
