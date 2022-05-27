package com.sptech.apikraken.entity;

import com.sptech.apikraken.entity.keys.FollowKey;

import javax.persistence.*;

@Entity
public class FollowDonorNGO {

    @EmbeddedId
    FollowKey id;

    @ManyToOne
    @MapsId("donorId")
    @JoinColumn(name = "fk_donor")
    private Donor donor;

    @ManyToOne
    @MapsId("ngoId")
    @JoinColumn(name = "fk_ngo")
    private NGO ngo;

    public FollowDonorNGO() {}

    public FollowDonorNGO(FollowKey id, Donor donor, NGO ngo) {
        this.id = id;
        this.donor = donor;
        this.ngo = ngo;
    }

    public FollowKey getId() {
        return id;
    }

    public void setId(FollowKey id) {
        this.id = id;
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
}
