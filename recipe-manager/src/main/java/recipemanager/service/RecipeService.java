package recipemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipemanager.entity.*;
import recipemanager.repository.*;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class RecipeService {

    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;
    private final DifficultyRepository difficultyRepository;
    private final RecipeTypeRepository recipeTypeRepository;
    private final CuisineRepository cuisineRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository, IngredientRepository ingredientRepository, DifficultyRepository difficultyRepository,
                         RecipeTypeRepository recipeTypeRepository, CuisineRepository cuisineRepository) {
        this.recipeRepository = recipeRepository;
        this.ingredientRepository = ingredientRepository;
        this.difficultyRepository = difficultyRepository;
        this.recipeTypeRepository = recipeTypeRepository;
        this.cuisineRepository = cuisineRepository;
    }

    public ArrayList<Recipe> findAll(){
        return (ArrayList<Recipe>) this.recipeRepository.findAll();
    }

    public Optional<Recipe> findById(Long recipeId){
        return this.recipeRepository.findById(recipeId);
    }

    public void deleteById(Long recipeId){
        this.recipeRepository.deleteById(recipeId);
    }

    public void save(Recipe recipe){
        Optional<Difficulty> difficulty = this.difficultyRepository.findById(recipe.getDifficulty().getDificultyId());
        Optional<Cuisine> cuisine = this.cuisineRepository.findById(recipe.getCuisine().getCuisineId());
        Optional<RecipeType> recipeType = this.recipeTypeRepository.findById(recipe.getRecipeType().getRecipeTypeId());
        Recipe newRecipe = new Recipe();
        newRecipe.setRecipeId(0L);
        newRecipe.setName(recipe.getName());
        newRecipe.setDescription(recipe.getDescription());
        newRecipe.setTimePrep(recipe.getTimePrep());
        newRecipe.setRating(recipe.getRating());
        newRecipe.setPreparation(recipe.getPreparation());
        if(difficulty.isPresent()){
            difficulty.ifPresent(recipe::setDifficulty);
        }
        if(recipeType.isPresent()){
            recipeType.ifPresent(recipe::setRecipeType);
        }
        if(cuisine.isPresent()){
            cuisine.ifPresent(recipe::setCuisine);
        }
        this.recipeRepository.save(recipe);
    }
}
