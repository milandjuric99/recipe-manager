package recipemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recipemanager.entity.Recipe;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
