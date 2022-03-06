package recipemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recipemanager.entity.RecipeType;
import recipemanager.service.RecipeTypeService;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping(value = "/recipeType")
public class RecipeTypeController {

    @Autowired
    private RecipeTypeService recipeTypeService;

    @GetMapping(value = "/")
    public ResponseEntity<?> getRecipeTypes(){
        Collection<RecipeType> types = this.recipeTypeService.findAll();
        if(types == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(types, HttpStatus.OK);
    }
}
