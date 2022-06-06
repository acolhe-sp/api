package com.sptech.apikraken.dto.response.post;

import com.sptech.apikraken.entity.Post;

import java.util.List;

public class PostAnalyticsPerfilNGO {

    private Integer qtdPosts;
    private List<Post> posts;
    private Double mediaLikesPosts;

    public PostAnalyticsPerfilNGO() {
    }

    public PostAnalyticsPerfilNGO(Integer qtdPosts, List<Post> posts, Double mediaLikesPosts) {
        this.qtdPosts = qtdPosts;
        this.posts = posts;
        this.mediaLikesPosts = mediaLikesPosts;
    }

    public Integer getQtdPosts() {
        return qtdPosts;
    }

    public void setQtdPosts(Integer qtdPosts) {
        this.qtdPosts = qtdPosts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Double getMediaLikesPosts() {
        return mediaLikesPosts;
    }

    public void setMediaLikesPosts(Double mediaLikesPosts) {
        this.mediaLikesPosts = mediaLikesPosts;
    }
}
