import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Cuisine } from 'src/app/interfaces/cuisine';

@Injectable({
  providedIn: 'root'
})
export class CuisineService {

    entityUrl = environment.REST_API_URL + 'cuisines';

    constructor(
        private http: HttpClient
      ) { }
    
      getCuisines(): Observable<Cuisine[]>{
        return this.http.get<Cuisine[]>(this.entityUrl + '/');
      }
}