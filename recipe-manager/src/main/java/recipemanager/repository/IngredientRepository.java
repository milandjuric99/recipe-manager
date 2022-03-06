package recipemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recipemanager.entity.Ingredients;

@Repository
public interface IngredientRepository extends JpaRepository<Ingredients, Long> {
}
