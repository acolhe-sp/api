package com.sptech.apikraken.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comment")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "fk_post", referencedColumnName = "id_post")
    private Post post;

    @Column(name = "datetime_comment")
    private LocalDateTime dateTime;

    @Column(name = "description_comment")
    private String description;

    @Column(name = "amount_evaluate_comment")
    private int amountEvaluate;

    public Comment() {}

    public Comment(Integer id, User user, Post post, LocalDateTime dateTime, String description, int amountEvaluate) {
        this.id = id;
        this.user = user;
        this.post = post;
        this.dateTime = dateTime;
        this.description = description;
        this.amountEvaluate = amountEvaluate;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", user=" + user +
                ", post=" + post +
                ", dateTime=" + dateTime +
                ", description='" + description + '\'' +
                ", amountEvaluate=" + amountEvaluate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmountEvaluate() {
        return amountEvaluate;
    }

    public void setAmountEvaluate(int amountEvaluate) {
        this.amountEvaluate = amountEvaluate;
    }
}
