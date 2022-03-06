import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Recipe } from 'src/app/interfaces/recipe';
import { FormGroup } from '@angular/forms';

@Injectable({
  providedIn: 'root'
})
export class RecipeService {

    entityUrl = environment.REST_API_URL + 'recipes';

    constructor(
        private http: HttpClient
      ) { }
    
      getRecipes(): Observable<Recipe[]>{
        return this.http.get<Recipe[]>(this.entityUrl + '/');
      }

      addRecipe(recipe: FormGroup): Observable<any> {
        return this.http.post(this.entityUrl + '/', recipe);
      }
}