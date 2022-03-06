package recipemanager.dto;

import org.springframework.stereotype.Component;
import recipemanager.entity.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import static java.util.stream.Collectors.toList;

@Component
public class Mapper {



    public RecipeDTO toDto(Recipe recipe){
        Long recipeId = recipe.getRecipeId();
        String name = recipe.getName();
        String description = recipe.getDescription();
        float rating = recipe.getRating();
        String timePrep = recipe.getTimePrep();
        String preparation = recipe.getPreparation();
        byte[] image = recipe.getImage();
        List<String> ingredients = recipe
                .getIngredients()
                .stream()
                .map(Ingredients::getName)
                .collect(toList());
        Difficulty difficulty = recipe.getDifficulty();
        RecipeType recipeType = recipe.getRecipeType();
        Cuisine cuisine = recipe.getCuisine();
        return new RecipeDTO(recipeId, name, description, rating, timePrep, image, preparation, ingredients, difficulty, recipeType, cuisine);
    }


}
