import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


const BASE_URL = 'http://localhost:8083';
@Injectable({
  providedIn: 'root'
})
export class EventService {
  constructor(private http: HttpClient) {}

  getAllEvents(): Observable<any[]> {
    return this.http.get<any[]>(`${BASE_URL}/events`);
  }

  getEventById(id: number): Observable<any> {
    return this.http.get<any>(`${BASE_URL}/events/${id}`);
  }

  createEvent(event: any): Observable<any> {
    return this.http.post(`${BASE_URL}/events`, event);
  }

  updateEvent(id: number, event: any): Observable<any> {
    return this.http.put(`${BASE_URL}/events/${id}`, event);
  }

  deleteEvent(id: number): Observable<any> {
    return this.http.delete(`${BASE_URL}/events/${id}`);
  }
}
