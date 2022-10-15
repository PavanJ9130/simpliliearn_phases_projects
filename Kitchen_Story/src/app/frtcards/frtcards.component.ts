import { Component, OnInit } from '@angular/core';
import { ServicesService } from 'src/app/myservices/services.service';
import { product } from 'src/app/Models/product';
import { AuthserviceService } from 'src/app/myservices/authservice.service';
import { Cart } from 'src/app/Models/Cart';


@Component({
  selector: 'app-frtcards',
  templateUrl: './frtcards.component.html',
  styleUrls: ['./frtcards.component.css']
})
export class FrtcardsComponent implements OnInit {
  products: product[] = [];
  cartproduct: product[] = [];
  constructor(private service: ServicesService, private authser: AuthserviceService) { }

  ngOnInit(): void {
    this.products = this.service.getproducts();
    this.cartproduct = this.authser.usercart.product;
  }
  cartbtnshow: boolean[] = [];
  addtocartclick(id: number, product: product) {
    this.cartbtnshow[id] = true;
    if (this.cartproduct.length === 0) {
      this.authser.usercart.product.push(product);
      this.authser.usercart.totalprice = product.price;
      this.authser.usercart.items = 1;
    } else {
      for (let p of this.authser.usercart.product) {
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
          this.authser.usercart.totalprice += p.price;
        }
      }
    }
  }
}
