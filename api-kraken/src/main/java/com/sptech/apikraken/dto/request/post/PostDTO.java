package com.sptech.apikraken.dto.request.post;

import com.sptech.apikraken.entity.Donor;
import com.sptech.apikraken.entity.NGO;
import com.sptech.apikraken.entity.Post;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostDTO {

    @Positive
    private Integer id;

    @NotNull
    private NGO ngo;

    @NotBlank
    private String description;

    private String img;

    @PastOrPresent
    private LocalDateTime dateTime;

    private List<Donor> usersToNotify;

    public PostDTO() {}

    public PostDTO(NGO ngo, String description, String img, LocalDateTime dateTime) {
        this.ngo = ngo;
        this.description = description;
        this.img = img;
        this.dateTime = dateTime;
        this.usersToNotify = new ArrayList<>();
    }

    public PostDTO(Integer id, NGO ngo, String description, String img, LocalDateTime dateTime) {
        this(ngo, description, img, dateTime);
        this.id = id;
    }

    public PostDTO(NGO ngo, String description, String img) {
        this(ngo, description, img, LocalDateTime.now());
    }

    public PostDTO(Post post) {
        this(
                post.getId(),
                post.getNgo(),
                post.getDescription(),
                post.getImg(),
                post.getDateTime()
        );
        this.usersToNotify = post.getUsersToNotify();
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

    public List<Donor> getUsersToNotify() {
        return usersToNotify;
    }

    public void setUsersToNotify(List<Donor> usersToNotify) {
        this.usersToNotify = usersToNotify;
    }
}
