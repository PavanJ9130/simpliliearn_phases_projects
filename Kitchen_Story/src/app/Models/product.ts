
export interface product {
    id: number;
    name: string;
    imgurl: string;
    price: number;
    category: string;
    qty:number;

  }
  export class product implements product{
    constructor(id:number,name:string,price:number,category:string){
      this.id=id;
      this.name=name;
      this.price=price;
      this.category=category;
      this.qty=1;
    }
  }

  export const products: product[] = [
    {
      id:1,
      name:"Tomato",
      imgurl:"/assets/img/tomato.jpg",
      price:15,
      category:"vegetable",
      qty:1
    },
    {
      id:2,
      name:"Bhendi",
      imgurl:"/assets/img/bhendi.jpg",
      price:12,
      category:"vegetable",
      qty:1
    },
    {
      id:3,
      name:"Lauki",
      imgurl:"/assets/img/lauki.jpg",
      price:10,
      category:"vegetable",
      qty:1
    },
    {
      id:4,
      name:"Onion",
      imgurl:"/assets/img/onion.jpg",
      price:25,
      category:"vegetable",
      qty:1
    },
    {
      id:5,
      name:"Potato",
      imgurl:"/assets/img/potato.jpg",
      price:18,
      category:"vegetable",
      qty:1
    },
    {
      id:6,
      name:"Watermelon",
      imgurl:"/assets/img/watermelon.jpg",
      price:50,
      category:"Fruits",
      qty:1
    },
    {
      id:7,
      name:"apple",
      imgurl:"/assets/img/apple.jpg",
      price:100,
      category:"Fruits",
      qty:1
    },
    {
      id:8,
      name:"banana",
      imgurl:"/assets/img/banana.jpg",
      price:40,
      category:"Fruits",
      qty:1
    },
    {
      id:9,
      name:"pineapple",
      imgurl:"/assets/img/pineapple.jpg",
      price:80,
      category:"Fruits",
      qty:1
    },
  ]

 