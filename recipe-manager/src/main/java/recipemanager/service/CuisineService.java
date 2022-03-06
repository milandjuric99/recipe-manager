package recipemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recipemanager.entity.Cuisine;
import recipemanager.repository.CuisineRepository;

import java.util.Collection;

@Service
public class CuisineService {

    @Autowired
    private CuisineRepository cuisineRepository;

    public Collection<Cuisine> findAll(){
        return cuisineRepository.findAll();
    }
}
