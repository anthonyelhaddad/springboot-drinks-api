package com.thebois.springbootdrinksapi.service;

import com.thebois.springbootdrinksapi.dao.jpa.DrinkRepository;
import com.thebois.springbootdrinksapi.dao.jpa.IngredientRepository;
import com.thebois.springbootdrinksapi.domain.Drink;
import com.thebois.springbootdrinksapi.domain.DrinkIngredient;
import com.thebois.springbootdrinksapi.domain.Ingredient;
import com.thebois.springbootdrinksapi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.thebois.springbootdrinksapi.dto.drink.request.DrinkCreateRequest;
import com.thebois.springbootdrinksapi.dto.drink.request.IngredientInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DrinkService {
    private final DrinkRepository drinkRepository;
    private final IngredientRepository ingredientRepository;

    @Autowired
    public DrinkService(DrinkRepository drinkRepository, IngredientRepository ingredientRepository){
        this.drinkRepository = drinkRepository;
        this.ingredientRepository = ingredientRepository;
    }

    public List<Drink> getAllDrinks() {return drinkRepository.findAll();}

    public void addDrink(DrinkCreateRequest drinkCreateRequest){
        Optional<Drink> optionalDrink = drinkRepository.findByName(drinkCreateRequest.getName());
        if(optionalDrink.isPresent()){
            throw new IllegalStateException("Drink with this name already exists");
        }
        Drink drink = new Drink(
                drinkCreateRequest.getName(),
                drinkCreateRequest.getImageUrl(),
                drinkCreateRequest.getVideoUrl(),
                drinkCreateRequest.isAlcoholic(),
                drinkCreateRequest.getInstructions()
        );

        List<DrinkIngredient> drinkIngredientList = new ArrayList<>();
        for (IngredientInfo ingredientInfo: drinkCreateRequest.getIngredients()) {
            Ingredient ingredient = ingredientRepository.findById(ingredientInfo.getId())
                    .orElseThrow(() -> new ResourceNotFoundException("Ingredient not found"));
            drinkIngredientList.add(new DrinkIngredient(
                    drink,
                    ingredient,
                    ingredientInfo.getUnit(),
                    ingredientInfo.getAmount()
            ));
        }
        drink.setDrinkIngredients(drinkIngredientList);
        drinkRepository.save(drink);
    }

    public Drink getDrinkById(Long id) {
        return drinkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Drink not found"));
    }

    public List<Drink> search(String keyword) {
        return drinkRepository.search(keyword);
    }

    public void deleteDrinkById(Long id){
        drinkRepository.deleteById(id);
    }
}
