package com.thebois.springbootdrinksapi.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class DrinkIngredient {
    @EmbeddedId
    private DrinkIngredientKey id;

    @ManyToOne
    @MapsId("drinkId")
    @JoinColumn(
            name = "drink_id",
            foreignKey = @ForeignKey(name = "drink_id_fk")
    )
    @JsonIgnore
    private Drink drink;

    @ManyToOne
    @MapsId("ingredientId")
    @JoinColumn(
            name = "ingredient_id",
            foreignKey = @ForeignKey(name = "ingredient_id_fk")
    )
    @JsonIgnore
    private Ingredient ingredient;

    @Column(
            name = "unit",
            nullable = false
    )
    private String unit;

    @Column(
            name = "amount",
            nullable = false
    )
    private Double amount;

    public DrinkIngredient() {
    }

    public DrinkIngredient(Drink drink, Ingredient ingredient, String unit, Double amount) {
        this.id = new DrinkIngredientKey(drink.getId(), ingredient.getId());
        this.drink = drink;
        this.ingredient = ingredient;
        this.unit = unit;
        this.amount = amount;
    }

    public DrinkIngredient(DrinkIngredientKey id, Drink drink, Ingredient ingredient, String unit, Double amount) {
        this.id = id;
        this.drink = drink;
        this.ingredient = ingredient;
        this.unit = unit;
        this.amount = amount;
    }

    public DrinkIngredientKey getId() {
        return id;
    }

    public void setId(DrinkIngredientKey id) {
        this.id = id;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
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

    @Override
    public String toString() {
        return "DrinkIngredient{" +
                "id=" + id +
                ", drink=" + drink +
                ", ingredient=" + ingredient +
                ", unit='" + unit + '\'' +
                ", amount=" + amount +
                '}';
    }
}
