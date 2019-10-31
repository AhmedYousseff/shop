import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  BASE_URL = 'http://localhost:8080/api';

  constructor(private httpClient: HttpClient) { }

  getAllUser = () => {
    this.httpClient.get(this.BASE_URL + '/users').subscribe((res) => console.error(res))
  }
}
