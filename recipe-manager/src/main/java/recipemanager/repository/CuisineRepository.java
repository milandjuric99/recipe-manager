package recipemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recipemanager.entity.Cuisine;

@Repository
public interface CuisineRepository extends JpaRepository<Cuisine, Long> {
}
