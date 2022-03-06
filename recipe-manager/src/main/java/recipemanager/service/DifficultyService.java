package recipemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipemanager.entity.Difficulty;
import recipemanager.repository.DifficultyRepository;

import java.util.Collection;

@Service
public class DifficultyService {

    @Autowired
    private DifficultyRepository difficultyRepository;

    public Collection<Difficulty> findAll(){
        return this.difficultyRepository.findAll();
    }
}
