package com.thebois.springbootdrinksapi.dto.drink.response;

import com.thebois.springbootdrinksapi.domain.DrinkIngredient;
import com.thebois.springbootdrinksapi.domain.ingredient.Ingredient;

import java.io.Serializable;

public class DrinkIngredientElement implements Serializable {
    private Long id;
    private String name;
    private String type;
    private String description;
    private String unit;
    private Double amount;

    public DrinkIngredientElement(DrinkIngredient drinkIngredient) {
        Ingredient ingredient = drinkIngredient.getIngredient();
        id = ingredient.getId();
        name = ingredient.getName();
        type = ingredient.getType();
        description = ingredient.getDescription();
        unit = drinkIngredient.getUnit();
        amount = drinkIngredient.getAmount();
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
