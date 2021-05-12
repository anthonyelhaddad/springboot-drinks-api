package com.thebois.springbootdrinksapi;

import com.thebois.springbootdrinksapi.dao.jpa.DrinkRepository;
import com.thebois.springbootdrinksapi.dao.jpa.IngredientRepository;
import com.thebois.springbootdrinksapi.domain.Drink;
import com.thebois.springbootdrinksapi.domain.DrinkIngredient;
import com.thebois.springbootdrinksapi.domain.Ingredient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootDrinksApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDrinksApiApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(
            IngredientRepository ingredientRepository,
            DrinkRepository drinkRepository
            ) {
        return args -> {
            Ingredient ingredient = new Ingredient(
                    "Vodka",
                    "Vodka boi",
                    "spirit"
            );

            Drink drink = new Drink(
                    "Vodka sec",
                    "lol.com",
                    "lolo.com",
                    true,
                    "Nope"
            );

            drink.addIngredient(new DrinkIngredient(
                    drink, ingredient, "oz", (double) 10
            ));

            drinkRepository.save(drink);
        };
    }
}
