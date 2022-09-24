import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { LoginuserService } from './loginuser.service';
import { MainpgService } from './mainpg.service';
import { SavedStockpgComponent } from './saved-stockpg/saved-stockpg.component';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class SavedstockpageService {
  private baseUrl="http://localhost:8083/findstock"
  existuser:User=new User();
  constructor(private httpClient: HttpClient,private mainpageservice:MainpgService) { }
  

  public displaysaved(): Observable<any> {
    return this.httpClient.get<any>(this.baseUrl);
  }
}
