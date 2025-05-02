import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

apiUrl : 'http://localhost:8081';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  apiUrl: any;

  constructor(private http: HttpClient) { }

  register(user: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/users/register`, user);
  }
  
  login(credentials: any): Observable<any> {
    return this.http.post(`${this.apiUrl}/users/login`, credentials);
  }
}
