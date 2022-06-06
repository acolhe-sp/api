package com.sptech.apikraken.entity;

import com.sptech.apikraken.entity.keys.LikeKey;

import javax.persistence.*;

@Entity
public class LikeDonorPost {

    @EmbeddedId
    LikeKey id;

    @ManyToOne
    @MapsId("donorId")
    @JoinColumn(name = "fk_donor")
    private Donor donor;

    @ManyToOne
    @MapsId("postId")
    @JoinColumn(name = "fk_post")
    private Post post;

    public LikeDonorPost() {}

    public LikeDonorPost(LikeKey id, Donor donor, Post post) {
        this.id = id;
        this.donor = donor;
        this.post = post;
    }

    public LikeKey getId() {
        return id;
    }

    public void setId(LikeKey id) {
        this.id = id;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
