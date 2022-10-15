import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CartComponent } from './cart/cart.component';
import { LoginformComponent } from './loginform/loginform.component';
import { AccountComponent } from './navbar/account/account.component';
import { LoginComponent } from './navbar/login/login.component';
import { LogoComponent } from './navbar/logo/logo.component';
import { MinicartComponent } from './navbar/minicart/minicart.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SearchboxComponent } from './navbar/searchbox/searchbox.component';
import { RegisterformComponent } from './registerform/registerform.component';
import { AdminhomepageComponent } from './adminhomepage/adminhomepage.component';
import { HomeComponent } from './home/home.component';
import { SlidesComponent } from './slides/slides.component';
import { FrtcardsComponent } from './frtcards/frtcards.component';



@NgModule({
  declarations: [
    AppComponent,
    RegisterformComponent,
    LoginformComponent,
    RegisterformComponent,
    NavbarComponent,
    CartComponent,
    AccountComponent,
    LoginComponent,
    LogoComponent,
    MinicartComponent,
    SearchboxComponent,
    AdminhomepageComponent,
    SlidesComponent,
    FrtcardsComponent,
    HomeComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule
  ],
  exports: [

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
