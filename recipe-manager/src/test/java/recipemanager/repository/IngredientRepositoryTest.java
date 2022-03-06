package recipemanager.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import recipemanager.entity.Ingredients;
import recipemanager.entity.UnitOfMeasure;

import java.util.ArrayList;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class IngredientRepositoryTest {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Test
    public void addIngredients(){
        UnitOfMeasure unit1 = this.unitOfMeasureRepository.findById(1L).get();
        UnitOfMeasure unit2 = this.unitOfMeasureRepository.findById(2L).get();
        UnitOfMeasure unit3 = this.unitOfMeasureRepository.findById(3L).get();
        UnitOfMeasure unit4 = this.unitOfMeasureRepository.findById(4L).get();
        UnitOfMeasure unit5 = this.unitOfMeasureRepository.findById(5L).get();
        UnitOfMeasure unit6 = this.unitOfMeasureRepository.findById(6L).get();
        UnitOfMeasure unit7 = this.unitOfMeasureRepository.findById(7L).get();
        UnitOfMeasure unit8 = this.unitOfMeasureRepository.findById(8L).get();
        UnitOfMeasure unit9 = this.unitOfMeasureRepository.findById(9L).get();

        ArrayList<Ingredients> ingredients = new ArrayList<>();

        Ingredients ingredient1 = new Ingredients("Rice", 100, unit8);
        Ingredients ingredient2 = new Ingredients("Eggs", 3);
        Ingredients ingredient3 = new Ingredients("Olive Oil", 2, unit2);
        Ingredients ingredient4 = new Ingredients("Chicken Breasts", 200, unit8);
        Ingredients ingredient5 = new Ingredients("Vegetable Spice", 2, unit1);
        Ingredients ingredient6 = new Ingredients("Spring Onions", 30, unit8);

        Collections.addAll(ingredients, ingredient1, ingredient2, ingredient3, ingredient4, ingredient5, ingredient6);

        this.ingredientRepository.saveAll(ingredients);

        assertThat(ingredients.size()).isGreaterThan(0);

    }
}
