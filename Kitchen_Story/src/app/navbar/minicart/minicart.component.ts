import { Component, OnInit } from '@angular/core';
import { Cart } from 'src/app/Models/Cart';
import { product } from 'src/app/Models/product';
import { AuthserviceService } from 'src/app/myservices/authservice.service';

@Component({
  selector: 'app-minicart',
  templateUrl: './minicart.component.html'
})
export class MinicartComponent implements OnInit {

items:number=0;
  constructor(public authser:AuthserviceService) {   
  }
  
  ngOnInit(): void {
    
  }

}
