package com.thebois.springbootdrinksapi.dto.drink.request;

import java.io.Serializable;
import java.util.List;

public class DrinkCreateRequest implements Serializable {
    private String name;
    private String imageUrl;
    private String videoUrl;
    private boolean isAlcoholic;
    private String instructions;
    private String description;
    private List<IngredientInfo> ingredients;

    public DrinkCreateRequest(String name, String imageUrl, String videoUrl, boolean isAlcoholic,
                              String instructions, List<IngredientInfo> ingredients, String description) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.videoUrl = videoUrl;
        this.isAlcoholic = isAlcoholic;
        this.instructions = instructions;
        this.ingredients = ingredients;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public boolean isAlcoholic() {
        return isAlcoholic;
    }

    public void setAlcoholic(boolean alcoholic) {
        isAlcoholic = alcoholic;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public List<IngredientInfo> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientInfo> ingredients) {
        this.ingredients = ingredients;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
