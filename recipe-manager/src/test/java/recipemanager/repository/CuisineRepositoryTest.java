package recipemanager.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;
import recipemanager.entity.Cuisine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class CuisineRepositoryTest {

    @Autowired
    private CuisineRepository cuisineRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void testCreateCuisine(){
        Cuisine cuisine = new Cuisine("Serbian");
        cuisineRepository.save(cuisine);

        assertThat(cuisine.getCuisineId()).isGreaterThan(0);
    }

    @Test
    public void testCreateCuisines(){
        ArrayList<Cuisine> cuisines = new ArrayList<>();
        Cuisine cuisine1 = new Cuisine("Serbian");
        Cuisine cuisine2 = new Cuisine("Italian");
        Cuisine cuisine3 = new Cuisine("Chinese");
        Cuisine cuisine4 = new Cuisine("Mexican");
        Cuisine cuisine5 = new Cuisine("Mediterranean");

        Collections.addAll(cuisines, cuisine1, cuisine2, cuisine3, cuisine4, cuisine5);

        cuisineRepository.saveAll(cuisines);
        cuisines.forEach(System.out::println);

        assertThat(cuisines.size()).isGreaterThan(0);
    }

    @Test
    public void textFindCuisineById(){
        Optional<Cuisine> cuisine = this.cuisineRepository.findById(2L);
        System.out.println(cuisine);
        assertThat(cuisine).isNotNull();
    }
}
