package com.thebois.springbootdrinksapi.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class DrinkIngredientKey implements Serializable {
    @Column(name = "drink_id")
    private Long drinkId;

    @Column(name = "ingredient_id")
    private Long ingredientId;

    public DrinkIngredientKey() {
    }

    public DrinkIngredientKey(Long drinkId, Long ingredientId) {
        this.drinkId = drinkId;
        this.ingredientId = ingredientId;
    }

    public Long getDrinkId() {
        return drinkId;
    }

    public void setDrinkId(Long drinkId) {
        this.drinkId = drinkId;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Long ingredientId) {
        this.ingredientId = ingredientId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DrinkIngredientKey that = (DrinkIngredientKey) o;
        return Objects.equals(drinkId, that.drinkId) && Objects.equals(ingredientId, that.ingredientId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(drinkId, ingredientId);
    }
}
