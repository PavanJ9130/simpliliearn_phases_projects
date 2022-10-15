import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { product } from 'src/app/Models/product';
import { ServicesService } from 'src/app/myservices/services.service';

@Component({
  selector: 'app-searchbox',
  templateUrl: './searchbox.component.html'
})
export class SearchboxComponent implements OnInit {

  @Output() searchproduct = new EventEmitter<product>();

 
   products:product[]=[];
   product:product;
  constructor(private service:ServicesService,private router:Router) {
  }
  
  ngOnInit(): void {
    this.products = this.service.getproducts();
  }
  searchdata(item:string){
    const result = this.products.find(element => {
      return element.name.toLowerCase() === item.toLowerCase();
    });
    this.searchproduct.emit(result);
  }
}
