import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class LoginuserService {
  static getUser(): User {
    throw new Error('Method not implemented.');
  }

  private baseUrl="http://localhost:8083/user/login"
  constructor(private httpClient: HttpClient) { }
  curr_user:User=new User();
  loginUser(user: User):Observable<object>{
    console.log(user)
    this.curr_user=user;
    return this.httpClient.post(this.baseUrl,user);
  }

  getUser():User{
    return this.curr_user;
  }

}
