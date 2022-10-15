import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminhomepageComponent } from './adminhomepage/adminhomepage.component';
import { CartComponent } from './cart/cart.component';
import { HomeComponent } from './home/home.component';
import { LoginformComponent } from './loginform/loginform.component';
import { RegisterformComponent } from './registerform/registerform.component';
import { AuthGuard } from './routeGuard/auth.guard';
const routes: Routes = [
  { path: 'cart', component: CartComponent },
  { path: 'login', component: LoginformComponent },
  { path: 'register', component: RegisterformComponent },
  { path: 'home', component: HomeComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'adminhome', component: AdminhomepageComponent, canActivate: [AuthGuard] },
  { path: '**', component: HomeComponent }


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
