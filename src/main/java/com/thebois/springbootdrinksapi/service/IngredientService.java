package com.thebois.springbootdrinksapi.service;

import com.thebois.springbootdrinksapi.dao.jpa.IngredientRepository;
import com.thebois.springbootdrinksapi.domain.Ingredient;
import com.thebois.springbootdrinksapi.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredientService {
    private final IngredientRepository ingredientRepository;

    @Autowired
    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }

    public void addIngredient(Ingredient ingredient) {
        Optional<Ingredient> optionalIngredient = ingredientRepository.findByName(ingredient.getName());
        if (optionalIngredient.isPresent()) {
            throw new IllegalStateException("Ingredient with this name already exists");
        }
        ingredientRepository.save(ingredient);
    }

    public Ingredient getIngredientById(Long id) {
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ingredient not found"));
    }
}
