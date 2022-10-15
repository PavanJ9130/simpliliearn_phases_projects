import { Component, Input, OnInit, ViewChild } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { product, products } from '../Models/product';
import { AuthserviceService } from '../myservices/authservice.service';
import { ServicesService } from '../myservices/services.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
  @ViewChild('closebutton') closebutton;

  changepasswordform = new FormGroup({
    useremail: new FormControl('', [Validators.required, Validators.email]),
    oldpassword: new FormControl('', [Validators.required, Validators.minLength(6)]),
    newpassword: new FormControl('', [Validators.required, Validators.minLength(6)])
  });
  product: product;
  cartproduct: product[] = [];
  totalprice: number = 0;
  ispasswordchange = true;
  constructor(public authser: AuthserviceService, private route: ActivatedRoute, private myservice: ServicesService) {

  }

  changepassword() {
    this.ispasswordchange = this.authser.changepassword(this.useremail.value, this.oldpassword.value, this.newpassword.value);
    if (this.ispasswordchange) {
      alert("password changed! Please login again...");
      this.changepasswordform.reset();
      this.closebutton.nativeElement.click();

    }
  }

  searchproduct(p: product) {
    this.product = p;
    if (this.authser.usercart != null) {
      this.cartproduct = this.authser.usercart.product;
    }

  }
  ngOnInit(): void {
    console.log("admin" + this.authser.isAdminLogin);
    console.log("auth" + this.authser.isAuthenticated);

  }


  cartbtnshow: boolean[] = [];
  addtocartclick(id: number, product: product) {
    this.cartbtnshow[id] = true;
    if (this.cartproduct.length === 0) {
      this.authser.usercart.product.push(product);
      this.authser.usercart.totalprice = product.price;
      this.authser.usercart.items = 1;
    } else {
      for (let p of this.cartproduct) {
        if (p.id === product.id) {
          p.qty++;
          this.authser.usercart.totalprice += p.price;
        } else {
          this.authser.usercart.items++;
          this.authser.usercart.totalprice += product.price;
          this.authser.usercart.product.push(product);
          break;
        }
      }
    }
  }

  addqty(id: number) {
    for (let p of this.cartproduct) {
      if (p.id === id) {
        p.qty++;
        this.authser.usercart.totalprice += p.price;
      }
    }
  }
  rmvqty(id: number) {
    for (const [i, p] of this.cartproduct.entries()) {
      if (p.id === id) {
        if (p.qty <= 1) {
          this.cartbtnshow[id] = false;
          this.authser.usercart.product.splice(i, 1);
          this.authser.usercart.items--;
          this.authser.usercart.totalprice -= p.price;
        } else {
          p.qty--;
          this.authser.usercart.totalprice -= p.price;
        }
      }
    }
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

}
