import { Component, OnInit } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { __values } from 'tslib';
import { Cart } from '../Models/Cart';
import { product } from '../Models/product';
import { AuthserviceService } from '../myservices/authservice.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html'
})
export class CartComponent implements OnInit {
  usercart: Cart;
  product: product[] = [];
  totalprice: number = 0;

  constructor(public authser: AuthserviceService, private router: Router) { }

  ngOnInit(): void {
    this.usercart = this.authser.getusercart();
    if (this.authser.usercart != null) {
      this.product = this.authser.usercart.product;
    }
  }

  addqty(id: number) {
    for (let p of this.authser.usercart.product) {
      if (p.id === id) {
        p.qty++;

        this.usercart.totalprice += p.price;
      }
    }

  }
  rmvqty(id: number) {
    for (const [i, p] of this.authser.usercart.product.entries()) {
      if (p.id === id) {
        if (p.qty <= 1) {
          this.authser.usercart.product.splice(i, 1);
          this.authser.usercart.items--;
          this.authser.usercart.totalprice -= p.price;
        } else {
          p.qty--;
          this.usercart.totalprice -= p.price;
        }
      }
    }
  }
  rmvproduct(id: number, product: product) {
    this.authser.usercart.product.splice(id, 1);
    this.authser.usercart.items--;
    this.authser.usercart.totalprice -= product.price;
  }
  orderplace() {
    this.router.navigate(['home']);
    this.authser.usercart.id = 0;
    this.authser.usercart.items = 0;
    this.authser.usercart.totalprice = 0;
    this.authser.usercart.product = [];
  }

}
