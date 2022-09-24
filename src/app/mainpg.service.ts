import { HttpClient} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginuserService } from './loginuser.service';
import { Savedstock } from './savedstock';
import { StockObj } from './stock-obj';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})

export class MainpgService 
{
  private baseUrl1="http://localhost:8083/mainpg"
  private baseUrl2="http://localhost:8083/save"
  currentuser:User=new User;
  constructor(private httpClient: HttpClient,private loginuser:LoginuserService) { }
  public getStocks(): Observable<any> {
    return this.httpClient.get<any>(this.baseUrl1,{
      observe: 'body',
      responseType: 'json',
  });}

  public putStocks(saved:Savedstock):Observable<any>{
    return this.httpClient.post(this.baseUrl2,saved);
  }

 /* findUser():User{

    this.currentuser=this.loginuser.getUser();
    return this.currentuser;
  }*/
}
