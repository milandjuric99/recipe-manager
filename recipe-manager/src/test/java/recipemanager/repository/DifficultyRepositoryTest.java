package recipemanager.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import recipemanager.entity.Difficulty;

import java.util.ArrayList;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class DifficultyRepositoryTest {

    @Autowired
    private DifficultyRepository difficultyRepository;

    @Test
    public void testCreateDifficulties(){
        ArrayList<Difficulty> difficulties = new ArrayList<>();
        Difficulty difficulty1 = new Difficulty("Easy");
        Difficulty difficulty2 = new Difficulty("Medium");
        Difficulty difficulty3 = new Difficulty("Hard");

        Collections.addAll(difficulties, difficulty1, difficulty2, difficulty3);

        this.difficultyRepository.saveAll(difficulties);

        assertThat(difficulties.size()).isGreaterThan(0);

    }
}
