package com.sptech.apikraken.entity;

import com.sptech.apikraken.dto.request.post.PostDTO;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_post")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_ngo", referencedColumnName = "id_ngo")
    @NotNull
    private NGO ngo;

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

    @ManyToMany(mappedBy = "notifications")
    private List<Donor> usersToNotify;

    public Post() {}

    public Post(NGO ngo, String description, String img, int amountEvaluate) {
        this.ngo = ngo;
        this.description = description;
        this.img = img;
        this.dateTime = LocalDateTime.now();
        this.amountEvaluate = amountEvaluate;
        this.usersToNotify = new ArrayList<>();
    }

    public Post(Integer id, NGO ngo, String description, String img, int amountEvaluate) {
        this(ngo, description, img, amountEvaluate);
        this.id = id;
    }

    public Post(Integer id, NGO ngo, String description, String img, LocalDateTime dateTime, int amountEvaluate) {
        this(id, ngo, description, img, amountEvaluate);
        this.dateTime = dateTime;
    }

    public Post(PostDTO post) {
        this(post.getNgo(), post.getDescription(), post.getImg(), post.getAmountEvaluate());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public NGO getNgo() {
        return ngo;
    }

    public void setNgo(NGO ngo) {
        this.ngo = ngo;
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

    public List<Donor> getUsersToNotify() {
        return usersToNotify;
    }

    public void setUsersToNotify(List<Donor> usersToNotify) {
        this.usersToNotify = usersToNotify;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", ngo=" + ngo +
                ", description='" + description + '\'' +
                ", img='" + img + '\'' +
                ", dateTime=" + dateTime +
                ", amountEvaluate=" + amountEvaluate +
                '}';
    }
}
