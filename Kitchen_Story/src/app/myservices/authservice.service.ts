import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Subject } from 'rxjs';
import { Cart } from '../Models/Cart';
import { products } from '../Models/product';
import { User, UserLogin } from '../Models/User';
import { ServicesService } from './services.service';

@Injectable({
  providedIn: 'root'
})
export class AuthserviceService {
  user: User[] = [];
  isAuthenticated = false;
  isAdminLogin = false;
  username: string = '';
  usercart: Cart = {
    id: 0,
    items: 0,
    totalprice: 0,
    product: []
  };

  constructor(private router: Router, private service: ServicesService) {
    this.user = service.getuser();
  }

  private readonly mockAdmin: UserLogin = new UserLogin("admin@gmail.com", '123456');

  changepassword(email: string, oldpassword: string, newpassword: string) {

    for (let u of this.user) {
      if (u.email === email && u.password === oldpassword) {
        u.password = newpassword;
        return true;
      }
    }
    return false;
  }
  authenticate(signInData: UserLogin): boolean {
    if (signInData.email === this.mockAdmin.getemail() && signInData.password === this.mockAdmin.getpassword()) {
      this.isAdminLogin = true;
      this.isAuthenticated=true;
      this.router.navigate(['adminhome']);
      return true;
    } else {
    for (let val of this.user) {
        if (val.email === signInData.getemail() && val.password === signInData.getpassword()) {
          this.isAuthenticated = true;
          this.router.navigate(['home']);
          this.username = val.fname;
          this.usercart = val.cart;
          return true;
        }
      }
    }
    this.isAuthenticated = false;
    return false;

  }
  logout() {
    this.isAdminLogin=false;
    this.isAuthenticated = false;
    this.usercart = {
      id: 0,
      items: 0,
      totalprice: 0,
      product: []
    };
    this.router.navigate(['']);
  }

  getIsAuthenticated(): boolean {
    return this.isAuthenticated;
  }
  getusercart(): Cart {
    return this.usercart;
  }
  getusername(): string {
    return this.username;
  }
  isauthenticated():boolean{
    return this.isAuthenticated;
  }

}
