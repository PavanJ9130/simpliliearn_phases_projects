import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AuthserviceService } from './myservices/authservice.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Kitchen_Story';

  public constructor() {

  }
  ngOnInit(): void {
  }
}
