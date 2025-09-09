import { inject, Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { lastValueFrom, Observable } from 'rxjs';
import { User } from '../interfaces/user';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  httpClient = inject(HttpClient);
  private apiUrl = 'https://peticiones.online/api/users';

  constructor() { }

  getAllWithObservables(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl);
  }
  
  getAllWithPromises(): Promise<User[]> {
    return lastValueFrom(this.httpClient.get<User[]>(this.apiUrl));
  } 

  getByIdWithObservable(_id: string): Observable<User> {
    return this.httpClient.get<User>(`${this.apiUrl}/${_id}`);
  }

  getById(_id: string): Promise<User> {
    return lastValueFrom(this.httpClient.get<User>(`${this.apiUrl}/${_id}`))
  }

  insertObservable(user: User): Observable<User>{
    return this.httpClient.post<User>(this.apiUrl, user)
  }

  insert(user: User): Promise<User>{
    return lastValueFrom(this.httpClient.post<User>(this.apiUrl, user));
  }

  update(user: User): Promise<User> {
    return lastValueFrom(this.httpClient.put<User>(this.apiUrl + "/" +user._id, user));
  }

  delete(_id: string): Promise<User> {
    return lastValueFrom(this.httpClient.delete<User>(`${this.apiUrl}/${_id}`));
  }
}
