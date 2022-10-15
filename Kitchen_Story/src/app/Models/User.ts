import { Cart } from "./Cart";

export interface User {
  id: number;
  fname: string;
  lname: string;
  email: string;
  password: string;
  cart: Cart;
}

// mock user
export const Users: User[] = [
  {
    id: 1,
    fname: "akshay",
    lname: "hinge",
    email: "ahinge8@gmail.com",
    password: "123456",
    cart: {
      id: 1,
      items: 1,
      totalprice: 45,
      product: [{
        id: 1,
        name: "Tomato",
        imgurl: "/assets/img/tomato.jpg",
        price: 15,
        category: "vegetable",
        qty:3
      }]

    }

  }
]


export class UserData implements User {

  id!: number;
  fname: string;
  lname: string;
  email: string;
  password: string;
  cart: Cart;

  constructor(fname: string, lname: string, email: string, password: string,cart:Cart) {
    this.fname = fname;
    this.lname = lname;
    this.email = email;
    this.password = password;
    this.cart=cart;
  }


  setcart(cart: Cart) {
    this.cart = cart;
  }
  getcart() {
    return this.cart;
  }
getfname(){
  return this.fname;
}
getlname(){
  return this.lname;
}
getemail(){
  return this.email;
}
getpassword(){
  return this.password;
}

}

export class UserLogin {
  email: string;
  password: string;
  constructor(email: string, password: string) {
    this.email = email;
    this.password = password;
  }
  getemail() {
    return this.email;
  }

  getpassword() {
    return this.password;
  }
}


