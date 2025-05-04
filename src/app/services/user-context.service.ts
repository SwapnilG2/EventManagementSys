import { Injectable } from '@angular/core';
import {jwtDecode} from 'jwt-decode';

export interface DecodedToken {
  sub: string;
  exp: number;
  role?: string;
  [key: string]: any;
}

@Injectable({
  providedIn: 'root'
})
export class UserContextService {
  private decodedToken: DecodedToken | null = null;

  constructor() {
    this.decodeToken();
  }

  private decodeToken(): void {
    const token = localStorage.getItem('token');
    if (token) {
      try {
        this.decodedToken = jwtDecode(token);
      } catch (e) {
        this.decodedToken = null;
        console.error('Invalid JWT token', e);
      }
    }
  }

  public getEmail(): string | null {
    return this.decodedToken?.sub || null;
  }

  public getRole(): string | null {
    return this.decodedToken?.role || null;
  }

  public isAdmin(): boolean {
    return this.getRole() === 'ADMIN';
  }

  public isOrganizer(): boolean {
    return this.getRole() === 'ORGANIZER';
  }

  public isAttendee(): boolean {
    return this.getRole() === 'ATTENDEE';
  }
}
