package recipemanager.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import recipemanager.entity.RecipeType;

import java.util.ArrayList;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class RecipeTypeRepositoryTest {

    @Autowired
    private RecipeTypeRepository recipeTypeRepository;

    @Test
    public void testCreateTypes(){
        ArrayList<RecipeType> types = new ArrayList<>();
        RecipeType recipeType1 = new RecipeType("Breakfast");
        RecipeType recipeType2 = new RecipeType("Lunch");
        RecipeType recipeType3 = new RecipeType("Dinner");

        Collections.addAll(types, recipeType1, recipeType2, recipeType3);
        this.recipeTypeRepository.saveAll(types);

        assertThat(types.size()).isGreaterThan(0);
    }
}
