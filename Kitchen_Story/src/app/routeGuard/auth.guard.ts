import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { AuthserviceService } from '../myservices/authservice.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private authservice: AuthserviceService, private route: Router) { }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): boolean {
    let isLoggedIn = this.authservice.isauthenticated();
    if (isLoggedIn) {
      return true;
    }
    this.route.navigate(['login']);
    return false
  }

}
