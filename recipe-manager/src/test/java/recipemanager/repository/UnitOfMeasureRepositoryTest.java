package recipemanager.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import recipemanager.entity.UnitOfMeasure;

import java.util.ArrayList;
import java.util.Collections;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UnitOfMeasureRepositoryTest {

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Test
    public void createUnitsOfMeasure(){
        ArrayList<UnitOfMeasure> units = new ArrayList<>();
        UnitOfMeasure unit1 = new UnitOfMeasure("TSP");
        UnitOfMeasure unit2 = new UnitOfMeasure("TBSP");
        UnitOfMeasure unit3 = new UnitOfMeasure("OZ");
        UnitOfMeasure unit4 = new UnitOfMeasure("ML");
        UnitOfMeasure unit5 = new UnitOfMeasure("L");
        UnitOfMeasure unit6 = new UnitOfMeasure("dL");
        UnitOfMeasure unit7 = new UnitOfMeasure("mG");
        UnitOfMeasure unit8 = new UnitOfMeasure("G");
        UnitOfMeasure unit9 = new UnitOfMeasure("kG");

        Collections.addAll(units, unit1, unit2, unit3, unit4, unit5, unit6, unit7, unit8, unit9);
        this.unitOfMeasureRepository.saveAll(units);

        assertThat(units.size()).isGreaterThan(0);

    }
}
