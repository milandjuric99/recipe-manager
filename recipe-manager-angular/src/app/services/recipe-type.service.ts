import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { RecipeType } from 'src/app/interfaces/recipe-type';

@Injectable({
  providedIn: 'root'
})
export class RecipeTypeService {

    entityUrl = environment.REST_API_URL + 'recipeType';

    constructor(
        private http: HttpClient
      ) { }
    
      getTypes(): Observable<RecipeType[]>{
        return this.http.get<RecipeType[]>(this.entityUrl + '/');
      }
}