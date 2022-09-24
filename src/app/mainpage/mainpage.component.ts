//import { Component, OnInit } from '@angular/core';
import { Component, OnInit, ViewChild } from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {MatTableDataSource} from '@angular/material/table';
import { MainpgService } from 'app/mainpg.service';
import { Savedstock } from 'app/savedstock';
import { StockObj } from 'app/stock-obj';
import { User } from 'app/user';
import { LoginuserService } from 'app/loginuser.service';
//import { LoginpageComponent } from 'app/loginpage/loginpage.component';

export interface Stockobj {
  comapany_name: string;
  nse_price: number;
  bse_price: number;
  diff: number;
}

//const ELEMENT_DATA: PeriodicElement[] = [
  //{position: 1, name: 'HDFC', NSE: 4.0026, BSE: 7.09, difference: 3.0},

//];

/**{position: 1, name: 'Hydrogen', weight: 1.0079, symbol: 'H'},
  {position: 2, name: 'Helium', weight: 4.0026, symbol: 'He'},
  {position: 3, name: 'Lithium', weight: 6.941, symbol: 'Li'},
  {position: 4, name: 'Beryllium', weight: 9.0122, symbol: 'Be'},
  {position: 5, name: 'Boron', weight: 10.811, symbol: 'B'},
  {position: 6, name: 'Carbon', weight: 12.0107, symbol: 'C'},
  {position: 7, name: 'Nitrogen', weight: 14.0067, symbol: 'N'},
  {position: 8, name: 'Oxygen', weight: 15.9994, symbol: 'O'},
  {position: 9, name: 'Fluorine', weight: 18.9984, symbol: 'F'},
  {position: 10, name: 'Neon', weight: 20.1797, symbol: 'Ne'}, */

/**
 * @title Basic use of `<table mat-table>`
 */
@Component({
  selector: 'app-mainpage',
  templateUrl: './mainpage.component.html',
  styleUrls: ['./mainpage.component.css']
})

export class MainpageComponent implements OnInit {

  data:Stockobj[]=[];
  s: Savedstock=new Savedstock();
  //loginpagecomponent!: LoginpageComponent;
  displayedColumns: string[] = ['name', 'NSE', 'BSE','difference','save'];
  //dataSource = ELEMENT_DATA;
  //dataSource = new MatTableDataSource<PeriodicElement>(ELEMENT_DATA);
  @ViewChild(MatPaginator, { static: true })
  paginator!: MatPaginator;
  dataSource!: MatTableDataSource<StockObj>;

  currentuser:User=new User();
  constructor(private mainpgservice:MainpgService,private loginuserservice:LoginuserService){}
  //stocks= new Array<StockObj>();

  ngOnInit() {
    //this.dataSource.paginator = this.paginator
    this.mainpgservice.getStocks().subscribe(response => {
      this.data = response;
      //console.log(this.data);
      //this.dataSource = new MatTableDataSource(this.stocks);
      //this.dataSource.paginator = this.paginator
    });
  }
  getRecord(name:String,nsep:Number,bsep:Number,d:Number)
 {
    //alert("Saved");
    this.currentuser=this.loginuserservice.getUser()
    this.s.username=this.currentuser.username;
    this.s.name=name;
    this.s.nseprice=nsep;
    this.s.bseprice=bsep;
    this.s.difference=d;
    console.log(this.s);
    this.mainpgservice.putStocks(this.s).subscribe(data=>{alert("--")},error=>alert("Opportunity saved"));
  }
  
}

