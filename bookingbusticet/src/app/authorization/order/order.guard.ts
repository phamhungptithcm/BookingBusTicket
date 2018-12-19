import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Trip } from 'src/app/models/trip';
import { SweetAlert } from 'src/app/shared/sweet-alert/sweet-alert';

@Injectable({
  providedIn: 'root'
})
export class OrderGuard extends SweetAlert implements CanActivate {
  constructor(private router: Router) { 
    super()
  }
  trip: Trip;
  seats: number[] = [];
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {
    this.trip = JSON.parse(localStorage.getItem('trip'));
    this.seats = JSON.parse(localStorage.getItem('seats'));
    if(this.trip === null || this.seats === null){
      this.showMessageToastCenter('info','No data to order! Please check again');
      this.router.navigate(['/']);
      return false;
    }
    return true;
  }
}
