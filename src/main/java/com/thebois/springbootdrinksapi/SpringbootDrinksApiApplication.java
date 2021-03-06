package com.thebois.springbootdrinksapi;

import com.thebois.springbootdrinksapi.dao.jpa.DrinkRepository;
import com.thebois.springbootdrinksapi.dao.jpa.IngredientRepository;
import com.thebois.springbootdrinksapi.domain.drink.Drink;
import com.thebois.springbootdrinksapi.domain.DrinkIngredient;
import com.thebois.springbootdrinksapi.domain.ingredient.Ingredient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootDrinksApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDrinksApiApplication.class, args);
    }
}
