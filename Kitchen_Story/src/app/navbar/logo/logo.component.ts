
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-logo',

  template: `
   <a class="navbar-brand fs-3" routerLink="home"> 𝔎𝔦𝔱𝔠𝔥𝔢𝔫 𝔖𝔱𝔬𝔯𝔶 </a>
  `,
  styles: [' a { font-size: 1.3rem;}',' a:hover { color: #00582f;}']
 
})
export class LogoComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
