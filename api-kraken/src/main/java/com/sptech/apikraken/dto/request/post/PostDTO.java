package com.sptech.apikraken.dto.request.post;

import com.sptech.apikraken.entity.Donor;
import com.sptech.apikraken.entity.NGO;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostDTO {

    @NotNull
    private NGO ngo;

    @NotBlank
    private String description;

    private String img;

    @PastOrPresent
    private LocalDateTime dateTime;

    @PositiveOrZero
    private int amountEvaluate;

    private List<Donor> users_to_notify;

    public PostDTO(NGO ngo, String description, String img, LocalDateTime dateTime, int amountEvaluate) {
        this.ngo = ngo;
        this.description = description;
        this.img = img;
        this.dateTime = dateTime;
        this.amountEvaluate = amountEvaluate;
        this.users_to_notify = new ArrayList<>();
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

    public List<Donor> getUsers_to_notify() {
        return users_to_notify;
    }

    public void setUsers_to_notify(List<Donor> users_to_notify) {
        this.users_to_notify = users_to_notify;
    }
}
