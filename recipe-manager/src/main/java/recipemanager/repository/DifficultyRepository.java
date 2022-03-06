package recipemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recipemanager.entity.Difficulty;
@Repository
public interface DifficultyRepository extends JpaRepository<Difficulty, Long> {
}
