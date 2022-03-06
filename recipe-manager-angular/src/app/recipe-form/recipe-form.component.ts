import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Cuisine } from '../interfaces/cuisine';
import { Difficulty } from '../interfaces/difficulty';
import { Recipe } from '../interfaces/recipe';
import { RecipeType } from '../interfaces/recipe-type';
import{ CuisineService } from '../services/cuisine.service';
import{ DifficultyService } from '../services/difficulty.service'
import { RecipeTypeService } from '../services/recipe-type.service';
import { RecipeService } from '../services/recipe.service';

@Component({
  selector: 'app-recipe-form',
  templateUrl: './recipe-form.component.html',
  styleUrls: ['./recipe-form.component.css']
})
export class RecipeFormComponent implements OnInit {

  form!: FormGroup;
  cuisines: Cuisine[] = [];
  difficulties: Difficulty[] = [];
  types: RecipeType[] = [];

  

  constructor(
    private cuisineService: CuisineService,
    private difficultyService: DifficultyService,
    private recipeTypeService: RecipeTypeService,
    private recipeService: RecipeService,
    private formBuilder: FormBuilder,
    private router: Router
    ) { }

  ngOnInit(): void {
    this.cuisineService.getCuisines().subscribe(
      cuisines => this.cuisines = cuisines);
    this.difficultyService.getDifficulties().subscribe(
      difficulties => this.difficulties = difficulties);
    this.recipeTypeService.getTypes().subscribe(
      types => this.types = types);

      this.form = this.formBuilder.group({
        name: [''],
        description: [''],
        rating: [''],
        timePrep: [''],
        preparation: [''],
        cuisine: [''],
        type: [''],
        difficulty: [''],
        image: ['']
      })
  }

  onSubmit(): void{
    const formData = new FormData();
    formData.append('file', this.form.get('image')?.value)
    JSON.stringify(this.form.value);
    this.recipeService.addRecipe(this.form).subscribe(

    );
    
  }

  onFileSelect(event: any) {
    if (event.target.files.length > 0) {
      const file = event.target.files[0];
      this.form.get('image')!.setValue(file);
    }
  }

}
