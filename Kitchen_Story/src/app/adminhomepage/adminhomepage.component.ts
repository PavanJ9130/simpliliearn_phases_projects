import { Component, OnInit } from '@angular/core';
import { AbstractControl, FormControl, FormGroup, Validators } from '@angular/forms';
import { product, products } from '../Models/product';
import { ServicesService } from '../myservices/services.service';

@Component({
  selector: 'app-adminhomepage',
  templateUrl: './adminhomepage.component.html'
})
export class AdminhomepageComponent implements OnInit {

  addproductform = new FormGroup({
    id: new FormControl('', [Validators.required]),
    name: new FormControl('', [Validators.required]),
    price: new FormControl('', [Validators.required]),
    category: new FormControl('', [Validators.required])
  });

  constructor(public service: ServicesService) { }
  ngOnInit(): void {

  }
  addproduct() {
    this.service.addproduct(
      new product(+this.id.value, this.name.value, +this.price.value, this.category.value));
    this.addproductform.reset();
  }
  removeproduct(id: number) {
    this.service.getproducts().splice(this.service.getproducts().findIndex(a => a.id === id), 1);
  }
  get id() {
    return this.addproductform.get('id');
  }
  get name() {
    return this.addproductform.get('name');
  }
  get price() {
    return this.addproductform.get('price');
  }
  get category() {
    return this.addproductform.get('category');
  }

}
