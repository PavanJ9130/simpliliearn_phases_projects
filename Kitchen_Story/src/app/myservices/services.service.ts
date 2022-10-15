import { Injectable } from '@angular/core';
import { CartComponent } from '../cart/cart.component';
import { Cart } from '../Models/Cart';
import { product, products, } from '../Models/product';
import { User, Users } from '../Models/User';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {
  product: product;
  Constructor() {

  }

  addproduct(product: product) {
    products.push(product);
  }
  getuser(): User[] {
    return Users;
  }
  setuser(user: User) {
    Users.push(user);
  }
  getproducts(): product[] {
    return products;
  }
  searchproduct(product: product): void {
    this.product = product;
  }
  getsearchproduct() {
    return this.product;
  }

}
