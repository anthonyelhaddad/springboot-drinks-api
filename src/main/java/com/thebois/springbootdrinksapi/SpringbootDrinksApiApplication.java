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

    @Bean
    CommandLineRunner commandLineRunner(
            IngredientRepository ingredientRepository,
            DrinkRepository drinkRepository
            ) {
        return args -> {
            Ingredient ingredient = new Ingredient(
                    "Vodka",
                    "Vodka is a distilled beverage composed primarily of water and ethanol.",
                    "Vodka"
            );
            Ingredient ingredient1 = new Ingredient(
                    "Schweppes Russchian",
                    "Schweppes but make it Russchian",
                    "Schweppes"
            );

            Drink drink = new Drink(
                    "Vodka Russian",
                    "https://www.thecocktaildb.com/images/media/drink/rpttur1454515129.jpg",
                    "https://www.youtube.com/watch?v=Z0zqXFpuolw",
                    true,
                    "Mix it as a ordinary drink."
            );

            drink.addIngredient(new DrinkIngredient(
                    drink, ingredient, "oz", (double) 2
            ));

            drink.addIngredient(new DrinkIngredient(
                    drink, ingredient1, "oz", (double) 4
            ));

            drinkRepository.save(drink);
        };
    }
}
