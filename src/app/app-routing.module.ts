import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MainpageComponent } from './mainpage/mainpage.component';
import { LoginpageComponent } from './loginpage/loginpage.component';
import { SavedStockpgComponent } from './saved-stockpg/saved-stockpg.component';

const routes: Routes = [
  {path:'',component: LoginpageComponent},
  {path:'mainpage',component: MainpageComponent},
  {path:'saved',component:SavedStockpgComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
