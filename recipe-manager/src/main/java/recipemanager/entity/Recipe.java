package recipemanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "recipes")
public class Recipe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recipeId;
    
    @Column(name = "name", length = 40, nullable = false)
    private String name;

    @Column(name = "description", length = 120, nullable = false)
    private String description;

    @Column(name = "rating")
    private float rating;
    
    @Column(name = "time_prep")
    private String timePrep;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Lob
    @Column(name = "preparation")
    private String preparation;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private List<Ingredients> ingredients;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "difficulty_id")
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "recipe_type_id")
    private RecipeType recipeType;

    @ManyToOne
    @JoinColumn(name = "cuisine_id")
    private Cuisine cuisine;

    public Recipe(String name, String description, float rating, String timePrep, byte[] image, String preparation,
                  List<Ingredients> ingredients, Difficulty difficulty, RecipeType recipeType, Cuisine cuisine) {
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
}
