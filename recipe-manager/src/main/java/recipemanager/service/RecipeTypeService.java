package recipemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipemanager.entity.RecipeType;
import recipemanager.repository.RecipeTypeRepository;

import java.util.Collection;

@Service
public class RecipeTypeService {

    @Autowired
    private RecipeTypeRepository recipeTypeRepository;

    public Collection<RecipeType> findAll(){
        return this.recipeTypeRepository.findAll();
    }
}
