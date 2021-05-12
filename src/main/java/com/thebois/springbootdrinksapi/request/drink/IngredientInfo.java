package com.thebois.springbootdrinksapi.request.drink;

import java.io.Serializable;

public class IngredientInfo implements Serializable {
    private Long id;
    private String unit;
    private Double amount;

    public IngredientInfo(Long id, String unit, Double amount) {
        this.id = id;
        this.unit = unit;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
