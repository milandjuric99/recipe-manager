package recipemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recipemanager.entity.Cuisine;
import recipemanager.service.CuisineService;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping(value = "/cuisines")
public class CuisineController {

    @Autowired
    private CuisineService cuisineService;

    @GetMapping(value = "/")
    public ResponseEntity<?> getCuisines(){
        Collection<Cuisine> cuisines = this.cuisineService.findAll();
        if(cuisines == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cuisines, HttpStatus.OK);
    }
}
