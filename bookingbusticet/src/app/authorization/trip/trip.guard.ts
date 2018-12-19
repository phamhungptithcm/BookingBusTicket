import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { SweetAlert } from 'src/app/shared/sweet-alert/sweet-alert';

@Injectable({
  providedIn: 'root'
})
export class TripGuard extends SweetAlert implements CanActivate {
  constructor(private router: Router) {
    super()
  }
  departureDate: Date = null;
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
      this.departureDate = JSON.parse(sessionStorage.getItem('departureDate'));
      if(this.departureDate === null) {
        this.router.navigate(['/']);
        this.showMessageToastCenter('warning','Departure Date is null');
        return false;
      }
    return true;
  }
}
