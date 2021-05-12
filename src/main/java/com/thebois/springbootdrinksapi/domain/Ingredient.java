package com.thebois.springbootdrinksapi.domain;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(
        name = "ingredient",
        uniqueConstraints = {
                @UniqueConstraint(name = "ingredient_name_unique", columnNames = "name")
        }
)
public class Ingredient {
    @Id
    @SequenceGenerator(
            name = "ingredient_sequence",
            sequenceName = "ingredient_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "ingredient_sequence"
    )
    @Column(
            name = "id"
    )
    private Long id;

    @Column(
            name = "name",
            nullable = false
    )
    private String name;

    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            name = "type",
            nullable = false
    )
    private String type;

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
            mappedBy = "ingredient"
    )
    private List<DrinkIngredient> drinkIngredients = new ArrayList<>();

    public Ingredient() {

    }

    public Ingredient(String name, String description, String type) {
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<DrinkIngredient> getDrinkIngredients() {
        return drinkIngredients;
    }

    public void setDrinkIngredients(List<DrinkIngredient> drinkIngredients) {
        this.drinkIngredients = drinkIngredients;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
