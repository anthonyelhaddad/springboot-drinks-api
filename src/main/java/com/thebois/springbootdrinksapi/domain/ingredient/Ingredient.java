package com.thebois.springbootdrinksapi.domain.ingredient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.thebois.springbootdrinksapi.api.rest.IngredientController;
import com.thebois.springbootdrinksapi.domain.DrinkIngredient;
import org.springframework.hateoas.RepresentationModel;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Entity
@Table(
        name = "ingredient",
        uniqueConstraints = {
                @UniqueConstraint(name = "ingredient_name_unique", columnNames = "name")
        }
)
public class Ingredient extends RepresentationModel<Ingredient> {
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
    @JsonIgnore
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

    public Ingredient addLinks() {
        final Long id = getId();
        add(linkTo(IngredientController.class).withRel("ingredients"));
        add(linkTo(methodOn(IngredientController.class).getDrinks(id)).withRel("drinks"));
        add(linkTo(methodOn(IngredientController.class).getIngredient(id)).withSelfRel());
        return this;
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
