import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Difficulty } from 'src/app/interfaces/difficulty';

@Injectable({
  providedIn: 'root'
})
export class DifficultyService {

    entityUrl = environment.REST_API_URL + 'difficulty';

    constructor(
        private http: HttpClient
      ) { }
    
      getDifficulties(): Observable<Difficulty[]>{
        return this.http.get<Difficulty[]>(this.entityUrl + '/');
      }
}