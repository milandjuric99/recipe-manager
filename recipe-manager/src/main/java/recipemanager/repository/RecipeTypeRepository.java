package recipemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recipemanager.entity.RecipeType;

@Repository
public interface RecipeTypeRepository extends JpaRepository<RecipeType, Long> {
}
