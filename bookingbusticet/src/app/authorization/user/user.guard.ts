import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from 'src/app/models/user';
import { SweetAlert } from 'src/app/shared/sweet-alert/sweet-alert';
declare var UIkit: any;
@Injectable({
  providedIn: 'root'
})
export class UserGuard extends SweetAlert implements CanActivate {
  constructor(private router: Router) {
    super();
  }
  user: User = null;
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
      this.user = JSON.parse(sessionStorage.getItem('user'));
    if (this.user === null) {
      UIkit.modal(`#modal-login`).show();
      this.showMessageToastCenter('warning', 'You need log in before continue next step!')
      return false;
    }
    return true;
  }
}
