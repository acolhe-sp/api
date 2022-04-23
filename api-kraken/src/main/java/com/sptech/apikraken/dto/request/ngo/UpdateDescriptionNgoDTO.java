package com.sptech.apikraken.dto.request.ngo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class UpdateDescriptionNgoDTO {

    @Positive
    private Integer id;

    @NotBlank
    private String description;

    public UpdateDescriptionNgoDTO() {}

    public UpdateDescriptionNgoDTO(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
