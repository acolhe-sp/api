package com.sptech.apikraken.dto.request;

import com.sptech.apikraken.entity.Category;

import javax.validation.constraints.NotBlank;

public class CategoryDTO {

    private Integer id;

    @NotBlank
    private String description;

    public CategoryDTO(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public CategoryDTO(Category category) {
        this.id = category.getId();
        this.description = category.getDescription();
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
