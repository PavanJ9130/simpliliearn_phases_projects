import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthserviceService } from 'src/app/myservices/authservice.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

  constructor(private authserice:AuthserviceService,private router:Router) { }

  logout(){
    this.authserice.logout();
    this.router.navigate(['/login']);
  }
  username:string='';
  ngOnInit(): void {
    if(this.authserice.isAdminLogin){
      this.username="admin";
    }else{
      this.username=this.authserice.username;

    }
  }

}
