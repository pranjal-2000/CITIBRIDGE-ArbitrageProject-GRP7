import { HttpClient, HttpParams } from '@angular/common/http';
import { Component, OnInit, ViewChild } from '@angular/core';
import { CheckboxControlValueAccessor } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { MainpgService } from 'app/mainpg.service';
import { SavedstockpageService } from 'app/savedstockpage.service';
import { User } from 'app/user';

export interface Savedst {
  username: string;
  name: string;
  nseprice: number;
  bseprice: number;
  difference: number;
}

/*const ELEMENT_DATA: stocks[] = [
  {position: 1, name: 'Helium', NSE: 4.0026, BSE: 7.09, difference: 3.0},
  {position: 2, name: 'HDFC BANK', NSE: 1525.10, BSE: 1493.6, difference: 31.5},
];*/

@Component({
  selector: 'app-saved-stockpg',
  templateUrl: './saved-stockpg.component.html',
  styleUrls: ['./saved-stockpg.component.css']
})

export class SavedStockpgComponent implements OnInit {

  displayedColumns: string[] = ['name', 'NSE', 'BSE','difference'];
  saveddata:Savedst[]=[];
  curruser:User=new User();
  private baseUrl="http://192.168.0.102:8083/findstock";
  //dataSource = ELEMENT_DATA;
  //dataSource = new MatTableDataSource<stocks>(ELEMENT_DATA);
  @ViewChild(MatPaginator, { static: true })
  paginator!: MatPaginator;

  constructor(private savedstockpgserv:SavedstockpageService,private httpClient: HttpClient){}


  ngOnInit() {
    //console.log(this.curruser);
    this.savedstockpgserv.displaysaved().subscribe(response => {
    this.saveddata = response;
    //console.log(this.saveddata);
  });
  }
}
