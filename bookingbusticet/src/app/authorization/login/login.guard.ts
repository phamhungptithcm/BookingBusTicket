import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/user';

@Injectable({
  providedIn: 'root'
})
export class LoginGuard implements CanActivate {
  constructor(private router: Router) { }
  user: User;
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    this.user = JSON.parse(sessionStorage.getItem('user'));
    if (this.user !== null) {
      switch (this.user.userRole) {
        case 1:
          this.router.navigate(['/']);
          break;
        case 2:
          this.router.navigate(['/staff']);
          break;
        case 3:
          this.router.navigate(['/admin']);
          break;
        default:
          this.router.navigate(['/']);
          break;
      }
      return true;
    }
    return true;
  }
}
