package recipemanager.dto;

import recipemanager.entity.Cuisine;
import recipemanager.entity.Difficulty;
import recipemanager.entity.RecipeType;

import java.util.List;

public class RecipeDTO {

    private Long recipeId;
    private String name;
    private String description;
    private float rating;
    private String timePrep;
    private byte[] image;
    private String preparation;
    private List<String> ingredients;
    private Difficulty difficulty;
    private RecipeType recipeType;
    private Cuisine cuisine;

    public RecipeDTO(Long recipeId, String name, String description, float rating, String timePrep, byte[] image, String preparation,
                     List<String> ingredients, Difficulty difficulty, RecipeType recipeType, Cuisine cuisine) {
        this.recipeId = recipeId;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.timePrep = timePrep;
        this.image = image;
        this.preparation = preparation;
        this.ingredients = ingredients;
        this.difficulty = difficulty;
        this.recipeType = recipeType;
        this.cuisine = cuisine;
    }

    public RecipeDTO() {
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
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

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getTimePrep() {
        return timePrep;
    }

    public void setTimePrep(String timePrep) {
        this.timePrep = timePrep;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public RecipeType getRecipeType() {
        return recipeType;
    }

    public void setRecipeType(RecipeType recipeType) {
        this.recipeType = recipeType;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public void setCuisine(Cuisine cuisine) {
        this.cuisine = cuisine;
    }

    @Override
    public String toString() {
        return "RecipeDTO{" +
                "recipeId=" + recipeId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", timePrep='" + timePrep + '\'' +
                ", image='" + image + '\'' +
                ", preparation='" + preparation + '\'' +
                ", ingredients=" + ingredients +
                ", difficulty=" + difficulty +
                ", recipeType=" + recipeType +
                ", cuisine=" + cuisine +
                '}';
    }
}
