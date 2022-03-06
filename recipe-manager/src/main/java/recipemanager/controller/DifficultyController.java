package recipemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recipemanager.entity.Difficulty;
import recipemanager.service.DifficultyService;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping(value = "/difficulty")
public class DifficultyController {

    @Autowired
    private DifficultyService difficultyService;

    @GetMapping(value = "/")
    public ResponseEntity<?> findAll(){
        Collection<Difficulty> difficulty = this.difficultyService.findAll();
        if(difficulty == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(difficulty, HttpStatus.OK);
    }
}
