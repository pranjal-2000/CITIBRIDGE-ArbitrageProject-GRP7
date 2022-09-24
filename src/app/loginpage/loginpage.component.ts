import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { GlobalConstants } from 'app/global-constants';
import { LoginuserService } from 'app/loginuser.service';
import { User } from 'app/user';

@Component({
  selector: 'app-loginpage',
  templateUrl: './loginpage.component.html',
  styleUrls: ['./loginpage.component.css']
})
export class LoginpageComponent implements OnInit {
  
  constructor(private loginuserservice: LoginuserService, private router:Router){}
  ngOnInit(): void {
  }
  user:User=new User();
  //curr_user:User=new User()
  title = 'homepage2';

  userLogin()
  {
    this.loginuserservice.loginUser(this.user).subscribe(data=>{this.router.navigate(['/mainpage'])},error=>alert("Sorry,please enter correct email and password"));
  }

}
