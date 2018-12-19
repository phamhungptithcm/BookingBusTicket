import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { Trip } from 'src/app/models/trip';
import { URLServer } from 'src/app/shared/urlserver';

const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};

@Injectable({
  providedIn: 'root'
})
export class TripServiceImp extends URLServer{
  constructor(private http: HttpClient) {
    super()
   }

  findAll(): Observable<Trip[]> {
    return this.http.get<Trip[]>(this.tripUrlFU).pipe(
      tap(data => console.log(`data = ${JSON.stringify(data)}`)),
      catchError(error => of([]))
    );
  }
  findById(id: number): Observable<Trip> {
    return null;
  }
  delete(id: number): Observable<Trip> {
    return null;
  }
  save(trip: Trip): Observable<Trip> {
    return null;
  }
  update(trip: Trip): Observable<any> {
    return null;
  }
  findByRouteId(id: number): Observable<Trip[]> {
    const url = `${this.tripUrlFU}/?routeId=${id}`;
    return this.http.get<Trip[]>(url).pipe(
      tap(),
      catchError(error => of([]))
    );
  }
  findByBusId(id: number): Observable<Trip> {
    const url = `${this.tripUrlFU}/bybus?id=${id}`;
    return this.http.get<Trip>(url).pipe(
      tap(),
      catchError(error => of(null))
    );
  }

  private tripUrl = 'http://localhost:8080/staff/trip';




  //localhost:8080/staff/trip?id=1&
  findAllKhai(): Observable<Trip[]> {
    return this.http.get<Trip[]>(this.tripUrl).pipe(
      tap(data => console.log(`data = ${JSON.stringify(data)}`)),
      catchError(error => of([]))
    );
  }
  // const url = `${this.domain}/staff/provinces/provinceFrom=${val}?${this.tokenUrl}`
  findAllByRouteId(val:any): Observable<Trip[]> {
    const url = `${this.domain}/staff/trip?id=${val}&${this.tokenUrl}`;
    alert(url);
    return this.http.get<Trip[]>(url).pipe(
      tap(data => console.log(`data = ${JSON.stringify(data)}`)),
      catchError(error => of([]))
    );
  }
}
