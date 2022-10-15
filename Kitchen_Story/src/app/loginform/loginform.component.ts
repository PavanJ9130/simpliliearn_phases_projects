import { Component, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthserviceService } from '../myservices/authservice.service';
import { User, UserLogin } from '../Models/User';

@Component({
  selector: 'app-loginform',
  templateUrl: './loginform.component.html'

})
export class LoginformComponent implements OnInit {
  @ViewChild('closebutton') closebutton;
  $: any;
  loginForm = new FormGroup({
    email: new FormControl('', [Validators.required, Validators.email]),
    password: new FormControl('', [Validators.required, Validators.minLength(6)])
  });
  changepasswordform = new FormGroup({
    useremail: new FormControl('', [Validators.required, Validators.email]),
    oldpassword: new FormControl('', [Validators.required, Validators.minLength(6)]),
    newpassword: new FormControl('', [Validators.required, Validators.minLength(6)])
  });

  constructor(private authservice: AuthserviceService, private route: Router) { }

  validuser = true;
  ispasswordchange = true;

  changepassword() {

    this.ispasswordchange = this.authservice.changepassword(this.useremail.value, this.oldpassword.value, this.newpassword.value);
    if (this.ispasswordchange) {
      alert("password changed! Please login again...");
      this.changepasswordform.reset();
      this.closebutton.nativeElement.click();
    }
  }

  userlogin() {
    const signInData = new UserLogin(this.email.value, this.password.value);
    if (this.authservice.authenticate(signInData)) {
      this.validuser = true;
    }
    else {
      this.validuser = false;
    }

  }
  get email() {
    return this.loginForm.get('email');
  }
  get password() {
    return this.loginForm.get('password');
  }
  get useremail() {
    return this.changepasswordform.get('useremail');
  }
  get oldpassword() {
    return this.changepasswordform.get('oldpassword');
  }
  get newpassword() {
    return this.changepasswordform.get('newpassword');
  }


  ngOnInit(): void {
  }

}
