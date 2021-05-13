package com.thebois.springbootdrinksapi.dto.drink.response;

import com.thebois.springbootdrinksapi.domain.Drink;
import com.thebois.springbootdrinksapi.domain.DrinkIngredient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DrinkResponse implements Serializable {
    private Long id;
    private String name;
    private String imageUrl;
    private String videoUrl;
    private boolean isAlcoholic;
    private String instructions;
    private List<DrinkIngredientElement> drinkIngredientElements = new ArrayList<>();

    public DrinkResponse(Drink drink) {
        id = drink.getId();
        name = drink.getName();
        imageUrl = drink.getImageUrl();
        videoUrl = drink.getVideoUrl();
        isAlcoholic = drink.getIsAlcoholic();
        instructions = drink.getInstructions();

        List<DrinkIngredient> drinkIngredientList = drink.getDrinkIngredients();
        for (DrinkIngredient drinkIngredient: drinkIngredientList) {
            drinkIngredientElements.add(new DrinkIngredientElement(drinkIngredient));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<DrinkIngredientElement> getDrinkIngredientElements() {
        return drinkIngredientElements;
    }

    public void setDrinkIngredientElements(List<DrinkIngredientElement> drinkIngredientElements) {
        this.drinkIngredientElements = drinkIngredientElements;
    }
}
