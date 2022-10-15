import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Cart } from '../Models/Cart';
import { UserData } from '../Models/User';
import { ServicesService } from '../myservices/services.service';

@Component({
  selector: 'app-registerform',
  templateUrl: './registerform.component.html'
})
export class RegisterformComponent implements OnInit {

  registerform = new FormGroup({
    fname: new FormControl('', [Validators.required, Validators.pattern("[a-z0-9_-]{3,15}$")]),
    lname: new FormControl('', [Validators.required, Validators.pattern("[a-z0-9_-]{3,15}$")]),
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)]),
    terms: new FormControl('', [Validators.requiredTrue])
  })
  constructor(private router: Router, private service: ServicesService) { }

  ngOnInit(): void {
  }
  ufname: any;
  ulname: any;
  uemail: any;
  upassword: any;
  cart: Cart;
  userregister() {
    this.ufname = this.fname?.value;
    this.ulname = this.lname?.value;
    this.uemail = this.email?.value;
    this.upassword = this.password?.value;
    this.cart = {
      id: 0,
      items: 0,
      totalprice: 0,
      product: []
    };
    let userdata = new UserData(this.fname.value, this.ulname, this.uemail, this.upassword, this.cart);
    this.service.setuser(userdata);
    alert("Registration Successfully Done! Please Login ");
    this.router.navigate(['login']);

  }
  get fname() { return this.registerform.get('fname') }
  get lname() { return this.registerform.get('lname') }
  get email() { return this.registerform.get('email') }
  get password() { return this.registerform.get('password') }
  get terms() { return this.registerform.get('terms') }
}
