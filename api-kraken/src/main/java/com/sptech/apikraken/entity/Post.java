package com.sptech.apikraken.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "id_user")
    @NotNull
    private User user;

    @Column(name = "description_post")
    private String description;

    @Column(name = "img_post")
    @Length(min = 5, message = "imagem inválida")
    private String img;

    @Column(name = "datetime_post")
    @PastOrPresent
    private LocalDateTime dateTime;

    @Column(name = "amount_evaluate_post")
    @PositiveOrZero
    private int amountEvaluate;

    public Post() {}

    public Post(Integer id, User user, String description, String img, int amountEvaluate) {
        this.id = id;
        this.user = user;
        this.description = description;
        this.img = img;
        this.dateTime = LocalDateTime.now();
        this.amountEvaluate = amountEvaluate;
    }

    public Post(Integer id, User user, String description, String img, LocalDateTime dateTime, int amountEvaluate) {
        this(id, user, description, img, amountEvaluate);
        this.dateTime = dateTime;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getAmountEvaluate() {
        return amountEvaluate;
    }

    public void setAmountEvaluate(int amountEvaluate) {
        this.amountEvaluate = amountEvaluate;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", user=" + user +
                ", description='" + description + '\'' +
                ", img='" + img + '\'' +
                ", dateTime=" + dateTime +
                ", amountEvaluate=" + amountEvaluate +
                '}';
    }
}
