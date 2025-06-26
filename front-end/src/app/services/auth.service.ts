import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { environment } from '../../environments/environment';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

interface LoginResponse {
  token: string;
}

@Injectable({ providedIn: 'root' })
export class AuthService {
  private readonly AUTH_KEY = 'sonatel_auth';
  private readonly baseUrl = environment.apiUrl;

  constructor(private router: Router, private http: HttpClient) {}

    login(email: any, password: any): Observable<LoginResponse> {
      const body = { email, password };
      return this.http.post<LoginResponse>(this.baseUrl + "auth/login", body);
    }


  logout(): void {
    localStorage.removeItem(this.AUTH_KEY);
    this.router.navigate(['/login']);
  }

  isAuthenticated(): boolean {
    return localStorage.getItem(this.AUTH_KEY) === 'true';
  }
}
