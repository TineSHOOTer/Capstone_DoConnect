import { HttpClient, HttpResponse } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { tap, map, Observable, of } from 'rxjs';
import { environment } from 'src/environments/environment';
import { UserStorageService } from '../storage/user-storage.service';

const BASIC_URL = environment['BASIC_URL'];
export const AUTH_HEADER = 'authorization';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient,
    private userStorageService : UserStorageService) { }

    login(username: string, password: string): any {
      return this.http.post<[]>( BASIC_URL + 'authenticate', {
        username,
        password
      }, {observe: 'response'})
        .pipe(
          tap(_ => this.log('User Authentication')),
          map((res: HttpResponse<any>) => {
            this.userStorageService.saveUser(res.body);
            console.log(res);
            const tokenLength = res.headers.get(AUTH_HEADER).length;
            const bearerToken = res.headers.get(AUTH_HEADER).substring(7, tokenLength);
            this.userStorageService.saveToken(bearerToken);
            return res;
        }));
    }

  
  register(data):Observable<any>{
    console.log(data);
    return this.http.post(BASIC_URL+"sign-up",data);
  }

  log(message: string): void {
    console.log(`User Auth Service: ${message}`);
  }

  handleError<T>(operation = 'operation', result?: T): any {
    return (error: any): Observable<T> => {

      console.error(error);

      this.log(`${operation} failed: ${error.message}`);

      return of(result as T);
    };
  }
}
