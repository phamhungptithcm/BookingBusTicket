import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { SweetAlert } from 'src/app/shared/sweet-alert/sweet-alert';
import { User } from 'src/app/models/user';

declare var UIkit: any;
@Injectable({
  providedIn: 'root'
})
export class SellerGuard extends SweetAlert implements CanActivate {
  constructor(private router: Router) {
    super();
  }
  user: User = null;
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    this.user = JSON.parse(sessionStorage.getItem('user'));
    if (this.user !== null) {
      if (this.user.userRole !== 2) {
        this.router.navigate(['/']);
        this.showMessageToastCenter('warning', 'This account is not role seller');
        return false;
      }
    } else {
      this.router.navigate(['/']);
      this.showMessageToastCenter('error', 'You are not logged in');
      UIkit.modal(`#modal-login`).show();
      return false;
    }
    return true;
  }
}
